package com.orbitalsonic.generalproject.storage.preferences

import android.content.SharedPreferences

private const val FIRST_TIME_ENTRANCE_KEY = "first_time_entrance"
private const val APP_LANGUAGE_CODE_KEY = "app_language_code"
private const val DARK_MODE_KEY = "dark_mode"

class SharedPrefManager(private val sharedPreferences: SharedPreferences) {

    var isFirstTimeEntrance: Boolean
        get() = sharedPreferences.getBoolean(FIRST_TIME_ENTRANCE_KEY, true)
        set(value) {
            sharedPreferences.edit().apply {
                putBoolean(FIRST_TIME_ENTRANCE_KEY, value)
                apply()
            }
        }

    var appLanguageCode: String
        get() = sharedPreferences.getString(APP_LANGUAGE_CODE_KEY, "en") ?: "en"
        set(value) {
            sharedPreferences.edit().apply {
                putString(APP_LANGUAGE_CODE_KEY, value)
                apply()
            }
        }

    var isDarkMode: Boolean
        get() = sharedPreferences.getBoolean(DARK_MODE_KEY, false)
        set(value) {
            sharedPreferences.edit().apply {
                putBoolean(DARK_MODE_KEY, value)
                apply()
            }
        }

}