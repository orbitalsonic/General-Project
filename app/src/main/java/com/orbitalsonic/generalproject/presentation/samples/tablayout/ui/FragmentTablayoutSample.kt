package com.orbitalsonic.generalproject.presentation.samples.tablayout.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.orbitalsonic.generalproject.R
import com.orbitalsonic.generalproject.databinding.FragmentTablayoutSampleBinding
import com.orbitalsonic.generalproject.presentation.base.fragments.BaseFragment
import com.orbitalsonic.generalproject.presentation.samples.tablayout.adapters.AdapterTabPager

class FragmentTablayoutSample :
    BaseFragment<FragmentTablayoutSampleBinding>(FragmentTablayoutSampleBinding::inflate) {

    private var tabLayoutMediator: TabLayoutMediator? = null

    override fun onViewCreated() {
        setupTabs()
    }

    private fun setupTabs() {
        val adapter = AdapterTabPager(this)
        binding.viewPager.adapter = adapter

        // Attach TabLayout with ViewPager2
        tabLayoutMediator = TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.customView = createTabView(position) // Use custom tab view
        }
        tabLayoutMediator?.attach()

        // Add page change listener
        binding.viewPager.registerOnPageChangeCallback(pageChangeCallback)
    }

    private fun createTabView(position: Int): View {
        val tabView = LayoutInflater.from(requireContext()).inflate(R.layout.custom_tab, null)
        val tabIcon = tabView.findViewById<ImageView>(R.id.tab_icon)
        val tabText = tabView.findViewById<TextView>(R.id.tab_text)

        when (position) {
            0 -> {
                tabText.text = getString(R.string.tab_home)
                tabIcon.setImageResource(R.drawable.ic_home)
            }
            1 -> {
                tabText.text = getString(R.string.tab_profile)
                tabIcon.setImageResource(R.drawable.ic_profile)
            }
            2 -> {
                tabText.text = getString(R.string.tab_notification)
                tabIcon.setImageResource(R.drawable.ic_notifications)
            }
            3 -> {
                tabText.text = getString(R.string.tab_settings)
                tabIcon.setImageResource(R.drawable.ic_settings)
            }
        }
        return tabView
    }

    // Page change listener
    private val pageChangeCallback = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            // You can log the page selection or perform any action here
            Log.d("ViewPager2", "Selected Page: $position")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        tabLayoutMediator?.detach() // Remove TabLayoutMediator to prevent memory leaks
        binding.viewPager.unregisterOnPageChangeCallback(pageChangeCallback) // Unregister listener
    }
}


