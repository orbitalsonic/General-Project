package com.orbitalsonic.generalproject.presentation.samples.results.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class WildModel(
    val wildName: String,
    val wildInfo: String
): Parcelable