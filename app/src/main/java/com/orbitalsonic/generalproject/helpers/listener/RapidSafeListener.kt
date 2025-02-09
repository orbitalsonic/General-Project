package com.orbitalsonic.generalproject.helpers.listener

import android.os.SystemClock
import android.view.MenuItem
import android.view.View
import androidx.appcompat.widget.Toolbar
import com.google.android.material.appbar.MaterialToolbar

object RapidSafeListener {

    private const val RAPID_DEFAULT_TIME = 500L
    private var lastClickTime: Long = 0

    fun View.setOnRapidClickSafeListener(rapidTime: Long = RAPID_DEFAULT_TIME, action: () -> Unit) {
        this.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                if (SystemClock.elapsedRealtime() - lastClickTime < rapidTime) return
                else action()
                lastClickTime = SystemClock.elapsedRealtime()
            }
        })
    }

    fun MaterialToolbar.setOnRapidSafeNavClickListener(rapidTime: Long = RAPID_DEFAULT_TIME, action: () -> Unit) {
        this.setNavigationOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                if (SystemClock.elapsedRealtime() - lastClickTime < rapidTime) return
                else action()
                lastClickTime = SystemClock.elapsedRealtime()
            }
        })
    }

    fun MaterialToolbar.setOnRapidSafeMenuItemClickListener(rapidTime: Long = RAPID_DEFAULT_TIME, action: (item: MenuItem?) -> Unit) {
        this.setOnMenuItemClickListener(object : Toolbar.OnMenuItemClickListener {
            override fun onMenuItemClick(item: MenuItem?): Boolean {
                if (SystemClock.elapsedRealtime() - lastClickTime < rapidTime) return false
                else action(item)
                lastClickTime = SystemClock.elapsedRealtime()
                return true
            }
        })
    }
}