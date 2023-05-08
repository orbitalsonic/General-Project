package com.orbitalsonic.generalproject.helpers.firebase

import android.util.Log
import com.google.firebase.ktx.Firebase
import com.google.firebase.remoteconfig.ktx.get
import com.google.firebase.remoteconfig.ktx.remoteConfig
import com.google.firebase.remoteconfig.ktx.remoteConfigSettings
import com.orbitalsonic.generalproject.R
import com.orbitalsonic.generalproject.helpers.firebase.FirebaseUtils.recordException
import com.orbitalsonic.generalproject.helpers.firebase.RemoteConstants.INTER_SPLASH_KEY
import com.orbitalsonic.generalproject.helpers.firebase.RemoteConstants.NATIVE_SPLASH_KEY
import com.orbitalsonic.generalproject.helpers.managers.InternetManager

class RemoteConfiguration(private val internetManager: InternetManager) {

    private val configTag = "TAG_REMOTE_CONFIG"

    fun checkRemoteConfig(callback: (fetchSuccessfully: Boolean) -> Unit) {
        if (internetManager.isInternetConnected) {
            val remoteConfig = Firebase.remoteConfig
            val configSettings = remoteConfigSettings { minimumFetchIntervalInSeconds = 2 }
            remoteConfig.setConfigSettingsAsync(configSettings)
            remoteConfig.setDefaultsAsync(R.xml.remote_config_defaults)
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
                    ex.recordException("RemoteConfiguration > fetchRemoteValues")
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

        RemoteConstants.rcvInterSplash = remoteConfig[INTER_SPLASH_KEY].asLong().toInt()
        RemoteConstants.rcvNativeSplash = remoteConfig[NATIVE_SPLASH_KEY].asLong().toInt()

        Log.d(configTag, "checkRemoteConfig: Fetched Successfully")
        callback.invoke(true)
    }
}