package com.orbitalsonic.generalproject.ui.fragments.splash

import com.orbitalsonic.generalproject.R
import com.orbitalsonic.generalproject.databinding.FragmentStartBinding
import com.orbitalsonic.generalproject.ui.fragments.base.BaseFragment

class FragmentStart : BaseFragment<FragmentStartBinding>(R.layout.fragment_start) {

    override fun onViewCreatedOneTime() {
        withDelay(2000) {
            navigateTo(R.id.fragmentStart, R.id.action_fragmentStart_to_fragmentLanguage)
        }
    }

    override fun onViewCreatedEverytime() {}

    override fun navIconBackPressed() {}

    override fun onBackPressed() {}

}