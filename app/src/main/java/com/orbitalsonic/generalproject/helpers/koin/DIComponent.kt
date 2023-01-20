package com.orbitalsonic.generalproject.helpers.koin

import com.orbitalsonic.generalproject.helpers.firebase.RemoteConfiguration
import com.orbitalsonic.generalproject.helpers.managers.InternetManager
import com.orbitalsonic.generalproject.helpers.utils.SharedPreferenceUtils
import com.orbitalsonic.generalproject.roomdb.viewmodel.GeneralProjectViewModel
import com.orbitalsonic.generalproject.ui.fragments.country.CountryViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class DIComponent : KoinComponent {

    // Utils
    val sharedPreferenceUtils by inject<SharedPreferenceUtils>()

    // Managers
    val internetManager by inject<InternetManager>()

    // ViewModels
    val countryViewModel by inject<CountryViewModel>()
    val generalProjectViewModel by inject<GeneralProjectViewModel>()

    // Remote Configuration
    val remoteConfiguration by inject<RemoteConfiguration>()

}