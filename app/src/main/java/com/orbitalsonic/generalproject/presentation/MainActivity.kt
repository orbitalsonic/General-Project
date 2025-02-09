package com.orbitalsonic.generalproject.presentation

import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.orbitalsonic.generalproject.R
import com.orbitalsonic.generalproject.databinding.ActivityMainBinding
import com.orbitalsonic.generalproject.presentation.base.activities.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>(ActivityMainBinding::inflate) {

    private lateinit var navController: NavController

    override fun onCreated() {
        initNavController()
        initNavListener()
    }

    private fun initNavController() {
        navController =
            (supportFragmentManager.findFragmentById(binding.navHostFragmentContainer.id) as NavHostFragment).navController
    }

    private fun initNavListener() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.fragmentHome -> {}

                else -> {}
            }
        }
    }

}