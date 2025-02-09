package com.orbitalsonic.generalproject.helpers.ui

import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes
import com.orbitalsonic.generalproject.BuildConfig


/**
 * Shows a toast message.
 */
fun Context?.showDebugToast(message: String) {
    if (BuildConfig.DEBUG) {
        this?.let {
            try {
                Toast.makeText(it, message, Toast.LENGTH_SHORT).show()
            } catch (ex: Exception) {
                ex.printStackTrace()
            }
        }
    }
}

/**
 * Shows a toast message.
 */
fun Context?.showToast(message: String) {
    this?.let {
        try {
            Toast.makeText(it, message, Toast.LENGTH_SHORT).show()
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }
}

/**
 * Shows a toast message.
 */
fun Activity?.showToast(message: String) {
    try {
        this?.runOnUiThread {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    } catch (ex: Exception) {
        ex.printStackTrace()
    }
}


/**
 * Shows a toast message from string resource.
 */
fun Activity?.showToast(@StringRes stringId: Int) {
    val message = this?.getString(stringId) ?: ""
    showToast(message)
}
