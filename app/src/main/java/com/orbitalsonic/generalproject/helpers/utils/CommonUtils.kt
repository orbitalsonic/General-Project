package com.orbitalsonic.generalproject.helpers.utils

import android.app.Activity
import android.content.Context
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
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

fun AppCompatActivity?.getResString(stringId: Int): String {
    return this?.resources?.getString(stringId) ?: ""
}

fun Fragment?.getResString(stringId: Int): String {
    return this?.resources?.getString(stringId) ?: ""
}

fun Context?.getResourceNameFromId(resourceId: Int): String? {
    this?.let {
        try {
            return this.resources.getResourceName(resourceId)
        } catch (e: Resources.NotFoundException) {
            e.printStackTrace()
        }
    }
    return null
}
