package com.orbitalsonic.generalproject.utils.helpers

import android.app.Activity
import android.hardware.display.DisplayManager
import android.util.DisplayMetrics
import android.view.Display
import androidx.core.content.getSystemService

/*
 binding.myLayout.requestLayout()
 binding.myLayout.layoutParams.width =  (activity.getScreenWidth() * .90).toInt()
 binding.myLayout.layoutParams.height =  (activity.getScreenHeight() * .90).toInt()
 */

fun Activity?.getScreenWidth(): Int {
    this?.let {
        try {
            val defaultDisplay = it.getSystemService<DisplayManager>()?.getDisplay(Display.DEFAULT_DISPLAY)
            defaultDisplay?.let { display ->
                val displayContext = it.createDisplayContext(display)
                return displayContext.resources.displayMetrics.widthPixels
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }
    return 350
}

fun Activity?.getScreenHeight(): Int {
    this?.let {
        try {
            val defaultDisplay = it.getSystemService<DisplayManager>()?.getDisplay(Display.DEFAULT_DISPLAY)
            defaultDisplay?.let { display ->
                val displayContext = it.createDisplayContext(display)
                return displayContext.resources.displayMetrics.heightPixels
            }
        } catch (ex: Exception) {
            ex.printStackTrace()
        }
    }
    return 700
}

fun Activity?.isSupportFullScreen(): Boolean {
    try {
        this?.let {
            val outMetrics = DisplayMetrics()
            it.windowManager.defaultDisplay.getMetrics(outMetrics)
            if (outMetrics.heightPixels > 1280) {
                return true
            }
        }
    } catch (ex: Exception) {
        ex.printStackTrace()
    }
    return false
}