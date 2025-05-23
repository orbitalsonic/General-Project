package com.orbitalsonic.generalproject.presentation.samples.tablayout.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.orbitalsonic.generalproject.presentation.samples.common_fragments.FragmentNavHome
import com.orbitalsonic.generalproject.presentation.samples.common_fragments.FragmentNavNotification
import com.orbitalsonic.generalproject.presentation.samples.common_fragments.FragmentNavProfile
import com.orbitalsonic.generalproject.presentation.samples.common_fragments.FragmentNavSettings

class AdapterTabPager(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 4 // Total number of tabs

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FragmentNavHome()
            1 -> FragmentNavProfile()
            2 -> FragmentNavNotification()
            3 -> FragmentNavSettings()
            else -> FragmentNavHome()
        }
    }
}
