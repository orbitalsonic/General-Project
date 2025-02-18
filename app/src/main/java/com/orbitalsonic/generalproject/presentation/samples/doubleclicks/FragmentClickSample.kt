package com.orbitalsonic.generalproject.presentation.samples.doubleclicks

import com.orbitalsonic.generalproject.databinding.FragmentClickSampleBinding
import com.orbitalsonic.generalproject.helpers.listener.RapidSafeListener.setOnRapidClickSafeListener
import com.orbitalsonic.generalproject.helpers.ui.showToast
import com.orbitalsonic.generalproject.presentation.base.fragments.BaseFragment

class FragmentClickSample :
    BaseFragment<FragmentClickSampleBinding>(FragmentClickSampleBinding::inflate) {

    override fun onViewCreated() {
        setupClicks()
    }


    private fun setupClicks() {
        binding.apply {
            /**
             * use setOnRapidClickSafeListener to prevent rapid clicking
             */
            btnDoubleClick.setOnRapidClickSafeListener {
                activity.showToast("Clicked")
            }
        }
    }

}