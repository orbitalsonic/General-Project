package com.orbitalsonic.generalproject.utils.preferences

import android.content.SharedPreferences

private const val billingRequireKey = "isAppPurchased"

/**
 *
 * fetching preference in activity or fragment
val sharedPrefManager = SharedPrefManager(
    this.getSharedPreferences(
        "app_preferences",
        MODE_PRIVATE
    )
)
 */

class SharedPrefManager(private val sharedPreferences: SharedPreferences) {
    var isAppPurchased: Boolean
        get() = sharedPreferences.getBoolean(billingRequireKey, false)
        set(value) {
            sharedPreferences.edit().apply {
                putBoolean(billingRequireKey, value)
                apply()
            }
        }
}