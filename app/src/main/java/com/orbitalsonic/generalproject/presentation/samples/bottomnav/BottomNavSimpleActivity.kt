package com.orbitalsonic.generalproject.presentation.samples.bottomnav

import androidx.fragment.app.Fragment
import com.orbitalsonic.generalproject.R
import com.orbitalsonic.generalproject.databinding.ActivityBottomNavSimpleBinding
import com.orbitalsonic.generalproject.helpers.ui.statusBarColorUpdate
import com.orbitalsonic.generalproject.presentation.base.activities.BaseActivity

class BottomNavSimpleActivity :
    BaseActivity<ActivityBottomNavSimpleBinding>(ActivityBottomNavSimpleBinding::inflate) {

    override fun onCreated() {
        statusBarColorUpdate(R.color.primary600)
        initToolbar()
        initBottomNavigation()
        loadDefaultFragment()
    }

    private fun initToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(true)
    }

    private fun initBottomNavigation() {
        binding.navView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    loadFragment(FragmentNavHome())
                    true
                }
                R.id.nav_profile -> {
                    loadFragment(FragmentNavProfile())
                    true
                }
                R.id.nav_notification -> {
                    loadFragment(FragmentNavNotification())
                    true
                }
                R.id.nav_settings -> {
                    loadFragment(FragmentNavSettings())
                    true
                }
                else -> false
            }
        }
    }

    private fun loadDefaultFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, FragmentNavHome())
            .commit()
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, fragment)
            .commit()
    }
}
