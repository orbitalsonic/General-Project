package com.orbitalsonic.generalproject.helpers.preferences

import android.content.SharedPreferences

private const val isBillingRequireKey = "isBillingRequire"
private const val isShowFirstScreenKey = "showFirstScreen"
private const val selectedLanguageCodeKey = "selectedLanguageCode"

class SharedPreferenceUtils(private val sharedPreferences: SharedPreferences) {

    /* ---------- Billing ---------- */

    var isAppPurchased: Boolean
        get() = sharedPreferences.getBoolean(isBillingRequireKey, false)
        set(value) {
            sharedPreferences.edit().apply {
                putBoolean(isBillingRequireKey, value)
                apply()
            }
        }

    /* ---------- UI ---------- */

    var showFirstScreen: Boolean
        get() = sharedPreferences.getBoolean(isShowFirstScreenKey, true)
        set(value) {
            sharedPreferences.edit().apply {
                putBoolean(isShowFirstScreenKey, value)
                apply()
            }
        }

    var selectedLanguageCode: String
        get() = sharedPreferences.getString(selectedLanguageCodeKey, "en") ?: "en"
        set(value) {
            sharedPreferences.edit().apply {
                putString(selectedLanguageCodeKey, value)
                apply()
            }
        }
}