package com.orbitalsonic.generalproject.utils.extensions

import android.app.Activity
import android.content.Context
import android.os.Build
import android.os.IBinder
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.view.WindowManager
import android.view.inputmethod.InputMethodManager
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.fragment.app.FragmentContainerView


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
        val imm: InputMethodManager? =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
        imm?.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
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
    // Check the SDK version because the approach differs for different versions
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
        // For API level 30 and above
        window.setDecorFitsSystemWindows(false)
        window.insetsController?.let {
            it.hide(WindowInsets.Type.statusBars())
            it.systemBarsBehavior = WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
    } else {
        // For API level below 30
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
    }
}