package com.orbitalsonic.generalproject.ui.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.orbitalsonic.generalproject.BuildConfig
import com.orbitalsonic.generalproject.R
import com.orbitalsonic.generalproject.databinding.ActivityMainBinding
import com.orbitalsonic.generalproject.helpers.extensions.Extensions.sonicBackPress
import com.orbitalsonic.generalproject.helpers.utils.SettingUtils.feedback
import com.orbitalsonic.generalproject.helpers.utils.SettingUtils.privacyPolicy
import com.orbitalsonic.generalproject.helpers.utils.SettingUtils.rateUs
import com.orbitalsonic.generalproject.helpers.utils.SettingUtils.shareApp
import java.util.*
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        setUI()
        initNavController()
        registerBackPressDispatcher()
        initNavListener()
        initNavDrawerListeners()
    }

    private fun setUI() {
        binding.includeDrawer.tvNavVersionName.text = String.format(Locale.getDefault(), "Version ${BuildConfig.VERSION_NAME}")
    }

    private fun initNavController() {
        navController = (supportFragmentManager.findFragmentById(binding.navHostFragmentContainer.id) as NavHostFragment).navController

        setSupportActionBar(binding.toolbarMain)
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.fragmentHome), binding.drawerLayoutMain)
        binding.toolbarMain.setupWithNavController(navController, appBarConfiguration)
    }

    private fun initNavListener() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.fragmentHome -> lockDrawer(false)
                else -> lockDrawer(true)
            }
        }
    }

    private fun lockDrawer(isLock: Boolean) {
        if (isLock) binding.drawerLayoutMain.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        else binding.drawerLayoutMain.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
    }

    private fun initNavDrawerListeners() {
        binding.includeDrawer.navPrivacyPolicy.setOnClickListener {
            binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
            privacyPolicy()
        }

        binding.includeDrawer.navShareApp.setOnClickListener {
            binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
            shareApp()
        }

        binding.includeDrawer.navRateUs.setOnClickListener {
            binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
            rateUs()
        }

        binding.includeDrawer.navFeedback.setOnClickListener {
            binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
            feedback()
        }

        binding.includeDrawer.navUpdateApp.setOnClickListener {
            binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
            rateUs()
        }
    }

    private fun registerBackPressDispatcher() {
        sonicBackPress {
            if (binding.drawerLayoutMain.isDrawerOpen(GravityCompat.START)) {
                binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
            } else {
                if (navController.currentDestination?.id == R.id.fragmentHome) {
                    finishAndRemoveTask()
                    exitProcess(0)
                }
            }
        }
    }
}