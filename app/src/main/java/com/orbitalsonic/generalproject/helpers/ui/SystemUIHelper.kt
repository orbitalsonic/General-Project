package com.orbitalsonic.generalproject.helpers.ui

import android.app.Activity
import android.os.Build
import android.os.IBinder
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.core.content.ContextCompat
import androidx.core.graphics.ColorUtils
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.fragment.app.FragmentContainerView
import com.orbitalsonic.generalproject.R
import com.orbitalsonic.generalproject.helpers.theme.isDarkThemeEnabled

/**
 * Paints the status bar with [color] and picks the icon color that stays readable on it.
 *
 * The default is the theme aware surface color, so the status bar follows
 * the dark/light theme automatically.
 */
fun Activity.statusBarColorUpdate(color: Int = R.color.surfaceColor) {
    try {
        val statusBarColor = ContextCompat.getColor(this, color)

        // Android 15 (API 35) enforces edge-to-edge and ignores this call: from there on the
        // status bar shows whatever the layout draws behind it. Kept for older devices.
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.VANILLA_ICE_CREAM) {
            @Suppress("DEPRECATION")
            window.statusBarColor = statusBarColor
        }

        // Light background -> dark icons, dark background -> light icons
        val useDarkIcons = ColorUtils.calculateLuminance(statusBarColor) > 0.5

        WindowInsetsControllerCompat(window, window.decorView).isAppearanceLightStatusBars =
            useDarkIcons

    } catch (ex: Exception) {
        ex.printStackTrace()
    }

}

/**
 * Keeps the system bar icons readable against the current theme,
 * useful for screens that do not paint their own status bar color.
 */
fun Activity.systemBarsIconsUpdate() {
    try {
        val isDarkTheme = isDarkThemeEnabled()
        WindowInsetsControllerCompat(window, window.decorView).apply {
            isAppearanceLightStatusBars = !isDarkTheme
            isAppearanceLightNavigationBars = !isDarkTheme
        }
    } catch (ex: Exception) {
        ex.printStackTrace()
    }
}

fun Activity.hideSystemUI(fcvContainerMain: FragmentContainerView) {
    try {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        WindowInsetsControllerCompat(window, fcvContainerMain).let { controller ->
            controller.hide(WindowInsetsCompat.Type.systemBars())
            controller.systemBarsBehavior =
                WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
    } catch (ex: Exception) {
        ex.printStackTrace()
    }

}

@Suppress("DEPRECATION")
fun Activity.showSystemUI() {
    try {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            WindowCompat.setDecorFitsSystemWindows(window, true)
            val controller = window.insetsController
            controller?.show(WindowInsets.Type.systemBars())
        } else {
            window.decorView.systemUiVisibility = (View.SYSTEM_UI_FLAG_VISIBLE)
            window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
        }
    } catch (ex: Exception) {
        ex.printStackTrace()
    }
}

fun Activity.showKeyboard() {
    try {
        // Requires a focused editable view - focus the input before calling this.
        val focusedView = currentFocus ?: window.decorView
        WindowInsetsControllerCompat(window, focusedView).show(WindowInsetsCompat.Type.ime())
    } catch (ex: Exception) {
        ex.printStackTrace()
    }
}

fun Activity.hideKeyboard() {
    try {
        val inputMethodManager: InputMethodManager =
            getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        val view: IBinder? = findViewById<View?>(android.R.id.content)?.windowToken
        inputMethodManager.hideSoftInputFromWindow(view, 0)
    } catch (ex: Exception) {
        ex.printStackTrace()
    }
}

fun Activity.hideStatusBar() {
    try {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        WindowInsetsControllerCompat(window, window.decorView).apply {
            hide(WindowInsetsCompat.Type.statusBars())
            systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
    } catch (ex: Exception) {
        ex.printStackTrace()
    }
}