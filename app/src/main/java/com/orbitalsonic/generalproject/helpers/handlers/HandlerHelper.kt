package com.orbitalsonic.generalproject.helpers.handlers

import android.os.Handler
import android.os.Looper

/**
 * Performs an action with a delay.
 */
fun withDelay(delay: Long = 300, block: () -> Unit) {
    Handler(Looper.getMainLooper()).postDelayed(block, delay)
}