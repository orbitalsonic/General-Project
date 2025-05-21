package com.orbitalsonic.generalproject.presentation.samples.bottomnavpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.orbitalsonic.generalproject.presentation.samples.common_fragments.FragmentNavHome
import com.orbitalsonic.generalproject.presentation.samples.common_fragments.FragmentNavNotification
import com.orbitalsonic.generalproject.presentation.samples.common_fragments.FragmentNavProfile
import com.orbitalsonic.generalproject.presentation.samples.common_fragments.FragmentNavSettings

class NavPagerAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int = 4

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