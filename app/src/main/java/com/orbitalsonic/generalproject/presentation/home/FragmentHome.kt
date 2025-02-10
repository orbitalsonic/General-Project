package com.orbitalsonic.generalproject.presentation.home

import com.orbitalsonic.generalproject.databinding.FragmentHomeBinding
import com.orbitalsonic.generalproject.presentation.base.fragments.BaseFragment

class FragmentHome : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    override fun onViewCreated() {
        setupClicks()
    }

    private fun setupClicks(){
        binding.apply {
            btnBottomNav.setOnClickListener {  }
            btnTabLayout.setOnClickListener {  }
            btnLanguage.setOnClickListener {  }
            btnLocation.setOnClickListener {  }
            btnPermission.setOnClickListener {  }
            btnResult.setOnClickListener {  }
            btnSettings.setOnClickListener {  }
            btnDialogs.setOnClickListener {  }
            btnDoubleClicks.setOnClickListener {  }

        }
    }

}