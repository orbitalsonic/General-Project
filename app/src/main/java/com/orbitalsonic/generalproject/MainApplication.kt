package com.orbitalsonic.generalproject

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.orbitalsonic.generalproject.helpers.firebase.EventsProvider
import com.orbitalsonic.generalproject.helpers.firebase.FirebaseUtils.postFirebaseEvent
import com.orbitalsonic.generalproject.helpers.koin.modulesList
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

        EventsProvider.HOME_SCREEN.postFirebaseEvent()

        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@MainApplication)
            modules(modulesList)
        }
    }
}