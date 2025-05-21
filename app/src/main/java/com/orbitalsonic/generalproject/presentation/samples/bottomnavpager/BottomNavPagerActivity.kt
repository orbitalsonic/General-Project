package com.orbitalsonic.generalproject.presentation.samples.bottomnavpager

import androidx.viewpager2.widget.ViewPager2
import com.orbitalsonic.generalproject.R
import com.orbitalsonic.generalproject.databinding.ActivityBottomNavPagerBinding
import com.orbitalsonic.generalproject.helpers.ui.statusBarColorUpdate
import com.orbitalsonic.generalproject.presentation.base.activities.BaseActivity
import com.orbitalsonic.generalproject.presentation.samples.common_fragments.FragmentNavHome
import com.orbitalsonic.generalproject.presentation.samples.common_fragments.FragmentNavNotification
import com.orbitalsonic.generalproject.presentation.samples.common_fragments.FragmentNavProfile
import com.orbitalsonic.generalproject.presentation.samples.common_fragments.FragmentNavSettings
import androidx.core.view.get

class BottomNavPagerActivity :
    BaseActivity<ActivityBottomNavPagerBinding>(ActivityBottomNavPagerBinding::inflate) {

    override fun onCreated() {
        statusBarColorUpdate(R.color.primary600)
        initToolbar()
        setupViewPager()
        setupBottomNavigation()
    }

    private fun initToolbar() {
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(true)
    }

    private fun setupViewPager() {
        binding.apply {
            val adapter = NavPagerAdapter(supportFragmentManager, lifecycle)
            binding.viewPager.adapter = adapter
            binding.viewPager.registerOnPageChangeCallback(viewPagerListener)
        }

    }

    private val viewPagerListener = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            binding.navView.menu[position].isChecked = true
        }
    }

    private fun setupBottomNavigation() {
        binding.apply {
            navView.setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.nav_home -> viewPager.currentItem = 0
                    R.id.nav_profile -> viewPager.currentItem = 1
                    R.id.nav_notification -> viewPager.currentItem = 2
                    R.id.nav_settings -> viewPager.currentItem = 3
                }
                true
            }
        }
    }

    override fun onDestroy() {
        binding.viewPager.unregisterOnPageChangeCallback(viewPagerListener)
        super.onDestroy()
    }
}