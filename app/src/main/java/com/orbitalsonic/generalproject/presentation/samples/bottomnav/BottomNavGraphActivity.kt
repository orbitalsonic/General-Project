package com.orbitalsonic.generalproject.presentation.samples.bottomnav

import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.orbitalsonic.generalproject.R
import com.orbitalsonic.generalproject.databinding.ActivityBottomNavGraphBinding
import com.orbitalsonic.generalproject.helpers.ui.statusBarColorUpdate
import com.orbitalsonic.generalproject.presentation.base.activities.BaseActivity

class BottomNavGraphActivity :
    BaseActivity<ActivityBottomNavGraphBinding>(ActivityBottomNavGraphBinding::inflate) {

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreated() {
        statusBarColorUpdate(R.color.primary600)
        initToolbar()
        initNavController()
        initNavListener()
    }

    private fun initToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(true)
    }

    private fun initNavController() {
        navController =
            (supportFragmentManager.findFragmentById(binding.navHostFragment.id) as NavHostFragment).navController
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.nav_home, R.id.nav_profile, R.id.nav_notification, R.id.nav_settings)
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navView.setupWithNavController(navController)
    }

    private fun initNavListener() {
        navController.addOnDestinationChangedListener(navDestinationListener)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    private val navDestinationListener =
        NavController.OnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.nav_home -> {}
                R.id.nav_profile -> {}
                R.id.nav_notification -> {}
                R.id.nav_settings -> {}

                else -> {}
            }
        }

    override fun onDestroy() {
        navController.removeOnDestinationChangedListener(navDestinationListener)
        super.onDestroy()
    }

}