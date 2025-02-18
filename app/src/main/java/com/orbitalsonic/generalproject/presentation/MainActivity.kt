package com.orbitalsonic.generalproject.presentation

import android.content.Intent
import android.os.Build
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.orbitalsonic.generalproject.R
import com.orbitalsonic.generalproject.databinding.ActivityMainBinding
import com.orbitalsonic.generalproject.helpers.ui.statusBarColorUpdate
import com.orbitalsonic.generalproject.presentation.base.activities.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

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
        navController = (supportFragmentManager.findFragmentById(binding.navHostFragmentContainer.id) as NavHostFragment).navController
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.fragmentHome)
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    private fun initNavListener() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.fragmentHome -> {}

                else -> {}
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    fun moveActivity(mIntent: Intent) {

        startActivity(mIntent)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
            overrideActivityTransition(
                OVERRIDE_TRANSITION_OPEN,
                R.anim.slide_enter,
                R.anim.slide_exit
            )
        } else {
            overridePendingTransition(R.anim.slide_enter, R.anim.slide_exit)
        }

    }

}