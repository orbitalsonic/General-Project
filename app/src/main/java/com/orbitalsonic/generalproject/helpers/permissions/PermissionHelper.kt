package com.orbitalsonic.generalproject.helpers.permissions

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat

fun Context?.isAudioPermissionGranted(): Boolean {
    return this?.let {
        ActivityCompat.checkSelfPermission(
            it, Manifest.permission.RECORD_AUDIO
        ) == PackageManager.PERMISSION_GRANTED
    } ?: false
}