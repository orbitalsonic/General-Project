package com.orbitalsonic.generalproject

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.orbitalsonic.generalproject.helpers.koin.modulesList
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        initKoin()
    }

    private fun initKoin() {
        startKoin { modules(modulesList) }
    }
}