package com.orbitalsonic.generalproject

import android.app.Application
import com.orbitalsonic.generalproject.helpers.theme.applyAppTheme
import com.orbitalsonic.generalproject.storage.preferences.SharedPrefManager

class MainApplication : Application() {

    private val sharedPrefManager by lazy {
        SharedPrefManager(getSharedPreferences("app_preferences", MODE_PRIVATE))
    }

    override fun onCreate() {
        super.onCreate()
        setDarkLightMode()
    }

    /** Restores the theme the user picked before any activity is created. */
    private fun setDarkLightMode() {
        applyAppTheme(sharedPrefManager.appThemeMode)
    }
}
