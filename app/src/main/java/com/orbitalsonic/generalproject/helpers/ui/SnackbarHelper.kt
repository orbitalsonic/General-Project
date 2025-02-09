package com.orbitalsonic.generalproject.helpers.ui

import android.app.Activity
import android.view.View
import androidx.annotation.StringRes
import com.google.android.material.snackbar.Snackbar
import com.orbitalsonic.generalproject.helpers.utils.isActivityExist


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