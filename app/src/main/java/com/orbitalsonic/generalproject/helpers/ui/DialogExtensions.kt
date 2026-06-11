package com.orbitalsonic.generalproject.helpers.ui

import android.app.Activity
import com.orbitalsonic.generalproject.helpers.utils.isActivityExist

inline fun Activity?.safeDialog(block: (Activity) -> Unit) {
    if (this == null) return
    if (!isActivityExist()) return
    block(this)
}

fun Activity.dialogWidth(percent: Double): Int {
    return (getScreenWidth() * percent).toInt()
}

fun Activity.dialogHeight(percent: Double): Int {
    return (getScreenHeight() * percent).toInt()
}