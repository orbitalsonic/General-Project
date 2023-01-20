package com.orbitalsonic.generalproject.helpers.koin

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import com.orbitalsonic.generalproject.helpers.dataProvider.DPCountry
import com.orbitalsonic.generalproject.helpers.managers.InternetManager
import com.orbitalsonic.generalproject.helpers.utils.SharedPreferenceUtils
import com.orbitalsonic.generalproject.roomdb.db.GeneralProjectDatabase
import com.orbitalsonic.generalproject.roomdb.repository.GeneralProjectRepository
import com.orbitalsonic.generalproject.roomdb.viewmodel.GeneralProjectViewModel
import com.orbitalsonic.generalproject.ui.fragments.country.CountryViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

private val applicationScope = CoroutineScope(SupervisorJob())

private val viewModelsModules = module {
    single { CountryViewModel() }
}

private val managerModules = module {
    single { InternetManager(androidContext().getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager) }
}

private val utilsModules = module {
    single { SharedPreferenceUtils(androidContext().getSharedPreferences("app_preferences", Application.MODE_PRIVATE)) }
}

private val dbModule = module {
    single { GeneralProjectDatabase.getDatabase(androidContext(), applicationScope).generalProjectDao() }

    single { GeneralProjectRepository(get()) }

    single { GeneralProjectViewModel(get()) }
}

val modulesList = listOf(viewModelsModules, utilsModules, managerModules, dbModule)