package com.orbitalsonic.generalproject.helpers.koin

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import com.orbitalsonic.generalproject.helpers.managers.InternetManager
import com.orbitalsonic.generalproject.helpers.utils.SharedPreferenceUtils
import org.koin.dsl.module

class KoinModules(private val context: Context) {

    private val managerModules = module {
        single { InternetManager(context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager) }
    }

    private val utilsModules = module {
        single { SharedPreferenceUtils(context.getSharedPreferences("app_preferences", Application.MODE_PRIVATE)) }
    }

    val modulesList = listOf(utilsModules, managerModules)

}