package com.orbitalsonic.generalproject.helpers.utils

import android.util.Log

object ALog {
    private val generalTAG = "GeneralTAG"

    fun d(tag: String = generalTAG, message: String) {
        Log.d(tag, message)
    }

    fun e(tag: String = generalTAG, message: String) {
        Log.e(tag, message)
    }

    fun i(tag: String = generalTAG, message: String) {
        Log.i(tag, message)
    }

    fun w(tag: String = generalTAG, message: String) {
        Log.w(tag, message)
    }

    fun v(tag: String = generalTAG, message: String) {
        Log.v(tag, message)
    }

}