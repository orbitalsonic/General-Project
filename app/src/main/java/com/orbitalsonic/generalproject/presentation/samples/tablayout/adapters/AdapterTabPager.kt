package com.orbitalsonic.generalproject.presentation.samples.tablayout.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.orbitalsonic.generalproject.presentation.samples.tablayout.ui.FragmentTabHome
import com.orbitalsonic.generalproject.presentation.samples.tablayout.ui.FragmentTabNotification
import com.orbitalsonic.generalproject.presentation.samples.tablayout.ui.FragmentTabProfile
import com.orbitalsonic.generalproject.presentation.samples.tablayout.ui.FragmentTabSettings

class AdapterTabPager(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 4 // Total number of tabs

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FragmentTabHome()
            1 -> FragmentTabProfile()
            2 -> FragmentTabNotification()
            3 -> FragmentTabSettings()
            else -> FragmentTabHome()
        }
    }
}
