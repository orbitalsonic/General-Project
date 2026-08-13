package com.orbitalsonic.generalproject.helpers.theme

import android.content.Context
import android.content.res.Configuration
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatDelegate
import com.orbitalsonic.generalproject.R

/**
 * Supported app themes.
 *
 * These values are the ones persisted in [com.orbitalsonic.generalproject.storage.preferences.SharedPrefManager.appThemeMode]
 *
 * DARK   ->  0  Always dark
 * LIGHT  ->  1  Always light
 * SYSTEM -> -1  Follows the device (system) theme
 */
object AppTheme {
    const val DARK = 0
    const val LIGHT = 1
    const val SYSTEM = -1

    /** All modes in the order they are shown to the user. */
    val allModes = listOf(SYSTEM, LIGHT, DARK)
}

/**
 * Applies the given [themeMode] to the whole app.
 *
 * Every resource qualified with "-night" (colors, drawables, styles) is swapped
 * automatically and all visible activities are recreated by AppCompat itself.
 */
fun applyAppTheme(themeMode: Int) {
    val nightMode = when (themeMode) {
        AppTheme.DARK -> AppCompatDelegate.MODE_NIGHT_YES
        AppTheme.LIGHT -> AppCompatDelegate.MODE_NIGHT_NO
        else -> AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
    }

    if (nightMode != AppCompatDelegate.getDefaultNightMode()) {
        AppCompatDelegate.setDefaultNightMode(nightMode)
    }
}

/** Title of the given [themeMode], used in the settings screen and the theme dialog. */
@StringRes
fun themeTitleRes(themeMode: Int): Int = when (themeMode) {
    AppTheme.DARK -> R.string.theme_dark
    AppTheme.LIGHT -> R.string.theme_light
    else -> R.string.theme_system_default
}

/** True when the app is currently rendering with the dark theme. */
fun Context?.isDarkThemeEnabled(): Boolean {
    if (this == null) return false
    return (resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK) == Configuration.UI_MODE_NIGHT_YES
}
