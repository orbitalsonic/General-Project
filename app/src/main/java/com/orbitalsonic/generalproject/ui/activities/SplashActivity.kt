package com.orbitalsonic.generalproject.ui.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.navigation.fragment.NavHostFragment
import com.orbitalsonic.generalproject.R
import com.orbitalsonic.generalproject.databinding.ActivitySplashBinding
import com.orbitalsonic.generalproject.ui.activities.base.BaseActivity

class SplashActivity : BaseActivity<ActivitySplashBinding>(R.layout.activity_splash) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        checkCaseType()
    }

    private fun checkCaseType() {
        if (diComponent.sharedPreferenceUtils.showFirstScreen) {
            navigateScreen()
        }
    }

    fun nextActivity(){
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    private fun navigateScreen() {
        val navController = (supportFragmentManager.findFragmentById(binding.fcvContainerSplash.id) as NavHostFragment).navController
        val navInflater = navController.navInflater
        val navGraph = navInflater.inflate(R.navigation.nav_graph_splash)
        navGraph.setStartDestination(R.id.fragmentStart)
        navController.graph = navGraph
    }
}