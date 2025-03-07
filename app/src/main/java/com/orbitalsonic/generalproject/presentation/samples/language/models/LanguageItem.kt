package com.orbitalsonic.generalproject.presentation.samples.language.models

import android.os.Parcelable
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class LanguageItem(
    var languageCode: String,
    var languageShortName: String,
    var languageFullName: String,
    var selected: Boolean
) : Parcelable
