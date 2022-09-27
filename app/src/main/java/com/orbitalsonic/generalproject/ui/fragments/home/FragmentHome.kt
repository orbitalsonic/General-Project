package com.orbitalsonic.generalproject.ui.fragments.home

import androidx.navigation.fragment.findNavController
import com.orbitalsonic.generalproject.R
import com.orbitalsonic.generalproject.databinding.FragmentHomeBinding
import com.orbitalsonic.generalproject.ui.fragments.base.BaseFragment

class FragmentHome : BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {


    override fun onViewCreatedOneTime() {
        binding.btnClickHome.setOnClickListener { onContinueClick() }
    }

    override fun onViewCreatedEverytime() {
        // For ViewModels
    }

    private fun onContinueClick() {
        findNavController().navigate(R.id.action_fragmentHome_to_fragmentEnlistCountry)
    }

    override fun registerBackPressDispatcher() {

    }
}