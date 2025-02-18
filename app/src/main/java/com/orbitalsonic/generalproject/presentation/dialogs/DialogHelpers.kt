package com.orbitalsonic.generalproject.presentation.dialogs

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import com.orbitalsonic.generalproject.databinding.DialogPermissionBinding
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

fun Activity?.permissionDialog(
    listener: OnDialogClickListener
) {
    this?.let { mActivity ->
        val mDialog = Dialog(mActivity)
        val dialogBinding = DialogPermissionBinding.inflate(mActivity.layoutInflater)
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