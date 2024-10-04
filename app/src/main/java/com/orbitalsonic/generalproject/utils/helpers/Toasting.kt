package com.orbitalsonic.generalproject.utils.helpers

import android.app.Activity
import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.annotation.StringRes
import com.google.android.material.snackbar.Snackbar
import com.orbitalsonic.generalproject.utils.extensions.isActivityExist


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

fun Activity?.showToastShort(message: String) {
    try {
        this?.runOnUiThread {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    } catch (ex: Exception) {
        ex.printStackTrace()
    }
}

fun Activity?.showToastLong(message: String) {
    try {
        this?.runOnUiThread {
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
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

fun Activity?.showSnackBar(view: View, message: String) {
    try {
        this?.runOnUiThread {
            Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show()
        }
    } catch (ex: Exception) {
        ex.printStackTrace()
    }
}

/**
 * Shows showSnackBar
 */
fun Activity?.showSnackBar(
    @StringRes messageStringId: Int, @StringRes actionStringId: Int,
    listener: View.OnClickListener?
) {
    this?.let {
        if (isActivityExist()) {
            try {
                Snackbar.make(
                    it.findViewById(android.R.id.content), it.getString(messageStringId),
                    Snackbar.LENGTH_LONG
                ).setAction(it.getString(actionStringId), listener).show()
            } catch (ex: Exception) {
                ex.printStackTrace()
            }
        }
    }
}