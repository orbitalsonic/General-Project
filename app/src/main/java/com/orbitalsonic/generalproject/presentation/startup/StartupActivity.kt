package com.orbitalsonic.generalproject.presentation.startup

import android.app.Application
import android.content.Intent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.orbitalsonic.generalproject.R
import com.orbitalsonic.generalproject.databinding.ActivityStartupBinding
import com.orbitalsonic.generalproject.helpers.ui.statusBarColorUpdate
import com.orbitalsonic.generalproject.presentation.MainActivity
import com.orbitalsonic.generalproject.presentation.base.activities.BaseActivity
import com.orbitalsonic.generalproject.storage.preferences.SharedPrefManager

class StartupActivity : BaseActivity<ActivityStartupBinding>(ActivityStartupBinding::inflate) {

    private var navController: NavController? = null
    private var navListener: NavController.OnDestinationChangedListener? = null

    private val sharedPrefManager by lazy { SharedPrefManager(getSharedPreferences(
        "app_preferences",
        Application.MODE_PRIVATE)) }

    override fun initSplashScreen() {
        installSplashScreen()
    }

    override fun onCreated() {
        initNavController()
        initNavListener()
    }

    private fun initNavController() {
        navController =
            (supportFragmentManager.findFragmentById(binding.startupNavHostFragment.id) as NavHostFragment).navController
        val navInflater = navController?.navInflater
        val navGraph = navInflater?.inflate(R.navigation.startup_nav_graph)
        if (sharedPrefManager.isFirstTimeEntrance) {
            navGraph?.setStartDestination(R.id.startupOnboardingFragment)
        } else {
            navGraph?.setStartDestination(R.id.startupFragment)
        }
        navController?.graph = navGraph!!
    }

    private fun initNavListener() {
        navListener = NavController.OnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.startupOnboardingFragment -> {}
                R.id.startupFragment -> {}
            }
        }

        navController?.addOnDestinationChangedListener(navListener!!)
    }

    override fun onDestroy() {
        super.onDestroy()
        navListener?.let { navController?.removeOnDestinationChangedListener(it) }
    }


    private fun updateStatusBar(statusBarColor: Int) {
        statusBarColorUpdate(statusBarColor)
    }

}