package com.orbitalsonic.generalproject.helpers.utils

import android.app.Application
import android.content.Context

private const val isBillingRequireKey = "isBillingRequire"

class SharedPreferenceUtils(context: Context) {

    /* -------------------------- Billing -------------------------- */
    private val sharedPreferences =
        context.getSharedPreferences("app_preferences", Application.MODE_PRIVATE)
    var isBillingRequired: Boolean
        get() = sharedPreferences.getBoolean(isBillingRequireKey, true)
        set(value) {
            sharedPreferences.edit().apply {
                putBoolean(isBillingRequireKey, value)
                apply()
            }
        }
}