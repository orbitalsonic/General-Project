package com.orbitalsonic.generalproject.ui.activities

import android.os.Bundle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.orbitalsonic.generalproject.BuildConfig
import com.orbitalsonic.generalproject.MainNavGraphDirections
import com.orbitalsonic.generalproject.R
import com.orbitalsonic.generalproject.databinding.ActivityMainBinding
import com.orbitalsonic.generalproject.helpers.extensions.Extensions.sonicBackPress
import com.orbitalsonic.generalproject.helpers.listeners.DebounceListener.setDebounceClickListener
import com.orbitalsonic.generalproject.helpers.utils.CleanMemory
import com.orbitalsonic.generalproject.helpers.utils.CleanMemory.isActivityRecreated
import com.orbitalsonic.generalproject.helpers.utils.SettingUtils.feedback
import com.orbitalsonic.generalproject.helpers.utils.SettingUtils.privacyPolicy
import com.orbitalsonic.generalproject.helpers.utils.SettingUtils.rateUs
import com.orbitalsonic.generalproject.helpers.utils.SettingUtils.shareApp
import com.orbitalsonic.generalproject.ui.activities.base.BaseActivity
import java.util.*

class MainActivity : BaseActivity<ActivityMainBinding>(R.layout.activity_main) {

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    /**
     *  No need to setContentView()
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setSupportActionBar(binding.toolbarMain)
        setUI()
        initNavController()
        registerBackPressDispatcher()
        initNavListener()
        initNavDrawerListeners()
    }

    private fun setUI() {
        binding.includeDrawer.tvNavVersionName.text =
            String.format(Locale.getDefault(), "Version ${BuildConfig.VERSION_NAME}")
    }

    private fun initNavController() {
        navController =
            (supportFragmentManager.findFragmentById(binding.navHostFragmentContainer.id) as NavHostFragment).navController
        appBarConfiguration =
            AppBarConfiguration(setOf(R.id.fragmentHome), binding.drawerLayoutMain)
        //binding.toolbarMain.setupWithNavController(navController, appBarConfiguration)
        binding.navView.setupWithNavController(navController)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    private fun initNavListener() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.fragmentHome -> {
                    lockDrawer(false)
                    setToolbarIcon(R.drawable.ic_nav_option)
                }
                else -> {
                    lockDrawer(true)
                    setToolbarIcon(R.drawable.ic_nav_back)
                }
            }
        }
    }

    private fun lockDrawer(isLock: Boolean) {
        if (isLock) binding.drawerLayoutMain.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
        else binding.drawerLayoutMain.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
    }

    fun openDrawer() {
        binding.drawerLayoutMain.openDrawer(GravityCompat.START)
    }

    private fun setToolbarIcon(icon:Int) {
        binding.toolbarMain.setNavigationIcon(icon)
    }

    private fun initNavDrawerListeners() {
        binding.includeDrawer.navChangeLanguge.setDebounceClickListener {
            binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
            val action = MainNavGraphDirections.actionFragmentLanguage()
            navController.navigate(action)
        }

        binding.includeDrawer.navPrivacyPolicy.setDebounceClickListener {
            binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
            privacyPolicy()
        }

        binding.includeDrawer.navShareApp.setDebounceClickListener {
            binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
            shareApp()
        }

        binding.includeDrawer.navRateUs.setDebounceClickListener {
            binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
            rateUs()
        }

        binding.includeDrawer.navFeedback.setDebounceClickListener {
            binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
            feedback()
        }

        binding.includeDrawer.navUpdateApp.setDebounceClickListener {
            binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
            rateUs()
        }

        binding.includeDrawer.navRemoveAds.setDebounceClickListener {
            binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
            showToast("Action Remove Ads")
        }
    }

    fun homeBackPressed() {
        onBack()
    }

    private fun registerBackPressDispatcher() {
        sonicBackPress {
            onBack()
        }
    }

    private fun onBack() {
        if (binding.drawerLayoutMain.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
        } else {
            showExitDialog()
        }
    }

    private fun showExitDialog() {
        if (navController.currentDestination?.id == R.id.fragmentHome) {
            navController.navigate(R.id.dialogExit)
        }
    }

    /**
     *  Call 'CleanMemory.clean()' to avoid memory leaks.
     *  This destroys all the resources
     */


    override fun onRecreate() {
        isActivityRecreated = true
        recreate()
    }

    override fun onDestroy() {
        if (!isActivityRecreated){
            CleanMemory.clean()
        }else{
            isActivityRecreated = false
        }
        super.onDestroy()
    }
}