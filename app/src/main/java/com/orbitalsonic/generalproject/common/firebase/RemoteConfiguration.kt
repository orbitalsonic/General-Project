package com.orbitalsonic.generalproject.common.firebase

import android.content.SharedPreferences
import android.util.Log
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.get
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.remoteConfigSettings
import com.orbitalsonic.generalproject.common.firebase.RemoteConstants.FEATURES_VISIBILITY_KEY
import com.orbitalsonic.generalproject.common.network.InternetManager

class RemoteConfiguration(
    private val internetManager: InternetManager,
    private val sharedPreferences: SharedPreferences
) {

    private val configTag = "TAG_REMOTE_CONFIG"

    fun checkRemoteConfig(callback: (fetchSuccessfully: Boolean) -> Unit) {
        getPrefRemoteValues()
        if (internetManager.isInternetConnected) {
            val remoteConfig = Firebase.remoteConfig
            val configSettings = remoteConfigSettings { minimumFetchIntervalInSeconds = 2 }
            remoteConfig.setConfigSettingsAsync(configSettings)
            fetchRemoteValues(callback)
        } else {
            Log.d(configTag, "checkRemoteConfig: Internet Not Found!")
            callback.invoke(false)
        }
    }

    private fun fetchRemoteValues(callback: (fetchSuccessfully: Boolean) -> Unit) {
        val remoteConfig = Firebase.remoteConfig
        remoteConfig.fetchAndActivate().addOnCompleteListener {
            if (it.isSuccessful) {
                try {
                    updateRemoteValues(callback)
                } catch (ex: Exception) {
                    Log.d(configTag, "fetchRemoteValues: ${it.exception}")
                    callback.invoke(false)
                }
            } else {
                Log.d(configTag, "fetchRemoteValues: ${it.exception}")
                callback.invoke(false)
            }
        }.addOnFailureListener {
            Log.d(configTag, "fetchRemoteValues: ${it.message}")
            callback.invoke(false)
        }

    }

    @Throws(Exception::class)
    private fun updateRemoteValues(callback: (fetchSuccessfully: Boolean) -> Unit) {
        val remoteConfig = Firebase.remoteConfig

        setPrefRemoteValues(remoteConfig)
        getPrefRemoteValues()
        Log.d(configTag, "checkRemoteConfig: Fetched Successfully")
        callback.invoke(true)

    }

    fun getPrefRemoteValues() {
        /**
         * Feature
         */
        RemoteConstants.rcvFeatureVisibility =
            sharedPreferences.getBoolean(FEATURES_VISIBILITY_KEY, true)

    }

    @Throws(Exception::class)
    private fun setPrefRemoteValues(remoteConfig: FirebaseRemoteConfig) {
        sharedPreferences.edit().apply {
            /**
             * Feature Remote Config
             */
            putBoolean(FEATURES_VISIBILITY_KEY, remoteConfig[FEATURES_VISIBILITY_KEY].asBoolean())

            apply()
        }
    }
}