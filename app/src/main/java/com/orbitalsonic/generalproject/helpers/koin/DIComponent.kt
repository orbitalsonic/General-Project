package com.orbitalsonic.generalproject.helpers.koin

import com.orbitalsonic.generalproject.helpers.utils.SharedPreferenceUtils
import com.orbitalsonic.generalproject.helpers.managers.InternetManager
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class DIComponent : KoinComponent {

    // Utils
    val sharedPreferenceUtils by inject<SharedPreferenceUtils>()

    // Managers
    val internetManager by inject<InternetManager>()

}