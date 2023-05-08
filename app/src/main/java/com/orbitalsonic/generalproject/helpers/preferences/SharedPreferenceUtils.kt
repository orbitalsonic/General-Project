package com.orbitalsonic.generalproject.helpers.preferences

import android.content.SharedPreferences

private const val billingRequireKey = "isAppPurchased"
private const val isShowFirstScreenKey = "showFirstScreen"
private const val firstTimeAskingPermission = "firstTimeAskingPermission"
private const val selectedLanguageCodeKey = "selectedLanguageCode"

class SharedPreferenceUtils(private val sharedPreferences: SharedPreferences) {

    /* ---------- Billing ---------- */

    var isFirstTimeAskingPermission: Boolean
        get() = sharedPreferences.getBoolean(firstTimeAskingPermission, true)
        set(value) {
            sharedPreferences.edit().apply {
                putBoolean(firstTimeAskingPermission, value)
                apply()
            }
        }

    /* ---------- Permission ---------- */

    var isAppPurchased: Boolean
        get() = sharedPreferences.getBoolean(billingRequireKey, false)
        set(value) {
            sharedPreferences.edit().apply {
                putBoolean(billingRequireKey, value)
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