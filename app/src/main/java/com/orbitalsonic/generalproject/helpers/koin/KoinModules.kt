package com.orbitalsonic.generalproject.helpers.koin

import com.orbitalsonic.generalproject.helpers.managers.InternetManager
import com.orbitalsonic.generalproject.helpers.utils.SharedPreferenceUtils
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

private val managerModules = module {
    single { InternetManager(androidContext()) }
}

private val utilsModules = module {
    single { SharedPreferenceUtils(androidContext()) }
}

val modulesList = listOf(utilsModules, managerModules)