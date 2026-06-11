package com.orbitalsonic.generalproject.presentation.dialogs.base

import android.app.Activity
import android.app.AlertDialog
import android.graphics.Color
import android.view.View
import androidx.core.graphics.drawable.toDrawable
import com.google.android.material.bottomsheet.BottomSheetDialog

fun Activity.createAlertDialog(
    binding: View,
    cancelable: Boolean = false,
    touchOutside: Boolean = false
): AlertDialog {
    return AlertDialog.Builder(this)
        .setView(binding)
        .create()
        .apply {
            setCancelable(cancelable)
            setCanceledOnTouchOutside(touchOutside)
            window?.setBackgroundDrawable(Color.TRANSPARENT.toDrawable())
        }
}

fun Activity.createBottomSheet(
    binding: View,
    cancelable: Boolean = true
): BottomSheetDialog {
    return BottomSheetDialog(this).apply {
        setContentView(binding)
        setCancelable(cancelable)
        window?.setBackgroundDrawable(Color.TRANSPARENT.toDrawable())
    }
}