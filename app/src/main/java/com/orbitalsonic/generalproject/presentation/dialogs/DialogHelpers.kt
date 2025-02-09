package com.orbitalsonic.generalproject.presentation.dialogs

import android.app.Activity
import android.app.AlertDialog
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import com.orbitalsonic.generalproject.R

fun Activity?.showPrayerAngleDialog(
    title:String,
    items: List<Double>,
    defaultSelection: Double?,
    onItemSelected: (Double) -> Unit
) {
    this?.let { context ->
        // Format the items for the dialog
        val formattedItems = items.map { "$it°" }.toTypedArray()

        // Determine the default selected index
        val defaultIndex = defaultSelection?.let {
            items.indexOf(it).takeIf { index -> index != -1 } // Only use if item exists
        } ?: 0

        // Show the dialog
        AlertDialog.Builder(context, R.style.SingleChoiceAlertDialogTheme)
            .setTitle(title)
            .setSingleChoiceItems(formattedItems, defaultIndex) { dialog, which ->
                // Item selected, pass back the value
                onItemSelected(items[which])
                dialog.dismiss()
            }
            .setNegativeButton(context.getResString(R.string.cancel)) { dialog, _ ->
                dialog.dismiss()
            }
            .show()
    }
}

fun Activity?.privacyDialog(
    listener: OnPrivacyDialogClickListener
) {
    this?.let { mActivity ->
        val mDialog = Dialog(mActivity)
        val dialogBinding = DialogPrivacyConsentBinding.inflate(mActivity.layoutInflater)
        mDialog.setContentView(dialogBinding.root)
        mDialog.setCanceledOnTouchOutside(false)
        mDialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        dialogBinding.dialogLayout.requestLayout()
        dialogBinding.dialogLayout.layoutParams.width =
            (mActivity.getScreenWidth() * .85).toInt()
        dialogBinding.dialogLayout.layoutParams.height = (mActivity.getScreenHeight() * .65).toInt()

        dialogBinding.btnBack.setOnRapidClickSafeListener {
            listener.onCancelClick()
            mDialog.dismiss()
        }

        dialogBinding.btnContinue.setOnRapidClickSafeListener {
            listener.onDoneClick()
            mDialog.dismiss()
        }

        dialogBinding.btnPrivacyPolicy.setOnRapidClickSafeListener {
            mActivity.privacyPolicy()
        }

        dialogBinding.mcbAccept.setOnCheckedChangeListener { _, isChecked ->
            dialogBinding.btnContinue.isEnabled = isChecked
        }

        mDialog.show()
    }
}