package com.orbitalsonic.generalproject.presentation.dialogs

import android.app.Activity
import android.app.AlertDialog
import com.orbitalsonic.generalproject.helpers.ui.safeDialog

fun Activity?.showAlertDialog(
    title: String,
    message: String,
    positiveText: String,
    negativeText: String? = null,
    onPositiveClick: (() -> Unit)? = null,
    onNegativeClick: (() -> Unit)? = null
) {
    safeDialog { activity ->

        AlertDialog.Builder(activity)
            .setTitle(title)
            .setMessage(message)
            .setPositiveButton(positiveText) { dialog, _ ->
                onPositiveClick?.invoke()
                dialog.dismiss()
            }
            .apply {
                negativeText?.let {
                    setNegativeButton(it) { dialog, _ ->
                        onNegativeClick?.invoke()
                        dialog.dismiss()
                    }
                }
            }
            .show()
    }
}