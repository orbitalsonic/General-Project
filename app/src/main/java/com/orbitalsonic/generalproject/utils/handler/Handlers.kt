package com.orbitalsonic.generalproject.utils.handler

import android.os.Handler
import android.os.Looper

/**
 * Performs an action with a delay.
 */
fun withDelay(delay: Long = 300, block: () -> Unit) {
    Handler(Looper.getMainLooper()).postDelayed(block, delay)
}