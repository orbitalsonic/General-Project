package com.orbitalsonic.generalproject.ui.fragments.home

import com.orbitalsonic.generalproject.R
import com.orbitalsonic.generalproject.databinding.FragmentHomeBinding
import com.orbitalsonic.generalproject.ui.fragments.base.BaseFragment

class FragmentHome : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    override fun onViewCreatedOneTime() {
        binding.mbClickHome.setOnClickListener { onContinueClick() }
        binding.mbGalleryHome.setOnClickListener { onGalleryClick() }
        binding.mbSampleHome.setOnClickListener { onSampleClick() }
        binding.mbLanguageHome.setOnClickListener { onLanguageClick() }
    }

    override fun onViewCreatedEverytime() {
        // For ViewModels
    }

    private fun onContinueClick() {
        navigateTo(R.id.fragmentHome, R.id.action_fragmentHome_to_fragmentEnlistCountry)
    }

    private fun onGalleryClick() {
        navigateTo(R.id.fragmentHome, R.id.action_fragmentHome_to_fragmentPictures)
    }

    private fun onSampleClick() {
        navigateTo(R.id.fragmentHome, R.id.action_fragmentHome_to_fragmentSampleResult)
    }

    private fun onLanguageClick() {
        navigateTo(R.id.fragmentHome, R.id.action_fragmentHome_to_fragmentLanguage)
    }

    override fun navIconBackPressed() {
        mainActivity.openDrawer()
    }

    override fun onBackPressed() {
        mainActivity.homeBackPressed()
    }
}