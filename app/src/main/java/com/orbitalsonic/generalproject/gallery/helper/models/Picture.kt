package com.orbitalsonic.generalproject.gallery.helper.models

import android.net.Uri
import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.File

@Parcelize
data class Picture(
    var file: File,
    var fileUri: Uri,
    var fileName: String,
    var dateCreated: String,
    var dateModified: String,
    var size: String,
    var exactDateCreated: Long,
    var exactDateModified: Long,
    var exactSize: Long,
    var isSelected: Boolean = false
) : Parcelable