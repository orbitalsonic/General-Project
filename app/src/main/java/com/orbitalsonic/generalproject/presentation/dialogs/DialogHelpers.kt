package com.orbitalsonic.generalproject.presentation.dialogs

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import com.orbitalsonic.generalproject.databinding.DialogMyCustomBinding
import com.orbitalsonic.generalproject.helpers.ui.getScreenHeight
import com.orbitalsonic.generalproject.helpers.ui.getScreenWidth
import com.orbitalsonic.generalproject.presentation.dialogs.callbacks.OnDialogClickListener

fun Activity?.showCountryDialog(
    onItemSelected: (String) -> Unit
) {
    this?.let { context ->
        val nuclearCountries = arrayOf(
            "Russia",
            "United States",
            "China",
            "France",
            "United Kingdom",
            "Pakistan",
            "India",
            "Israel",
            "North Korea"
        )
        // Show the dialog
        AlertDialog.Builder(context)
            .setTitle("Select a Nuclear Country") // Set your title
            .setSingleChoiceItems(nuclearCountries, 0) { dialog, which ->
                // Item selected, pass back the value
                onItemSelected(nuclearCountries[which])
                dialog.dismiss()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }
}

fun Activity?.myCustomDialog(
    listener: OnDialogClickListener
) {
    this?.let { mActivity ->
        val mDialog = Dialog(mActivity)
        val dialogBinding = DialogMyCustomBinding.inflate(mActivity.layoutInflater)
        mDialog.setContentView(dialogBinding.root)
        mDialog.setCanceledOnTouchOutside(false)
        mDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialogBinding.dialogLayout.requestLayout()
        dialogBinding.dialogLayout.layoutParams.width =
            (mActivity.getScreenWidth() * .85).toInt()
        dialogBinding.dialogLayout.layoutParams.height = (mActivity.getScreenHeight() * .45).toInt()

        dialogBinding.btnCancel.setOnClickListener {
            listener.onCancel()
            mDialog.dismiss()
        }

        dialogBinding.btnDone.setOnClickListener {
            listener.onProceed()
            mDialog.dismiss()
        }

        mDialog.show()
    }
}

fun Activity?.showPermissionDialog(
    onGranted: () -> Unit,
    onDenied: () -> Unit
) {
    this?.let { context ->
        AlertDialog.Builder(context)
            .setTitle("Permission Required")
            .setMessage("This app needs access to your location to provide complete access to the feature. Please grant the necessary permission to continue.")
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
