package com.orbitalsonic.generalproject.presentation.dialogs

import android.app.Activity
import android.app.AlertDialog
import com.orbitalsonic.generalproject.helpers.ui.safeDialog

fun Activity?.showPermissionDialog(
    onGranted: () -> Unit,
    onDenied: () -> Unit
) {
    safeDialog { activity ->

        AlertDialog.Builder(activity)
            .setTitle("Permission Required")
            .setMessage(
                "This app needs access to your location to provide complete access to the feature. Please grant the necessary permission to continue."
            )
            .setPositiveButton("Grant") { dialog, _ ->
                onGranted()
                dialog.dismiss()
            }
            .setNegativeButton("Deny") { dialog, _ ->
                onDenied()
                dialog.dismiss()
            }
            .show()
    }
}