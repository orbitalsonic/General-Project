package com.orbitalsonic.generalproject.presentation.home

import com.orbitalsonic.generalproject.R
import com.orbitalsonic.generalproject.databinding.FragmentHomeBinding
import com.orbitalsonic.generalproject.helpers.navigation.navigateTo
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
            btnSettings.setOnClickListener {
                val action = FragmentHomeDirections.actionFragmentHomeToFragmentSettings()
                navigateTo(R.id.fragmentHome,action)
            }
            btnDialogs.setOnClickListener {
                val action = FragmentHomeDirections.actionFragmentHomeToFragmentDialogSample()
                navigateTo(R.id.fragmentHome,action)
            }
            btnDoubleClicks.setOnClickListener {  }

        }
    }

}