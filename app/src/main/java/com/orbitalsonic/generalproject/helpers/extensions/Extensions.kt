package com.orbitalsonic.generalproject.helpers.extensions

import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity

object Extensions {

    fun AppCompatActivity.onBackPress(callback: () -> Unit) {
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                callback()
            }
        })
    }
}