package com.orbitalsonic.generalproject.utils.extensions

import android.app.Activity
import android.content.Context
import androidx.recyclerview.widget.RecyclerView

fun Int.isValidPosition(list: List<Any>): Boolean {
    return this != RecyclerView.NO_POSITION && list.isNotEmpty() && this < list.size
}

fun Activity?.isActivityExist(): Boolean {
    return this?.let {
        !it.isFinishing && !it.isDestroyed
    } ?: false
}

fun String?.validateText(): Boolean {
    return !this.isNullOrEmpty() || !this.isNullOrBlank()
}

fun String.removeExtraLines(): String {
    return replace("\n", "").trim()
}

fun Context?.getResString(stringId: Int): String {
    return this?.resources?.getString(stringId) ?: ""
}