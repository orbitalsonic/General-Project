package com.orbitalsonic.generalproject.helpers.utils

import android.content.SharedPreferences

private const val isBillingRequireKey = "isBillingRequire"

class SharedPreferenceUtils(private val sharedPreferences: SharedPreferences) {

    /* ---------- Billing ---------- */

    var isBillingRequired: Boolean
        get() = sharedPreferences.getBoolean(isBillingRequireKey, true)
        set(value) {
            sharedPreferences.edit().apply {
                putBoolean(isBillingRequireKey, value)
                apply()
            }
        }
}