package com.orbitalsonic.generalproject.presentation.samples.language.models

import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.annotation.Keep
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
data class LanguageItem(
    val languageCode: String,
    val languageShortName: String,
    val languageFullName: String,
    @DrawableRes val flag: Int,
    val selected: Boolean
) : Parcelable
