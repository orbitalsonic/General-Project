package com.orbitalsonic.generalproject.presentation.samples.bottomnav

import android.content.Intent
import com.orbitalsonic.generalproject.databinding.FragmentBottomNavSampleBinding
import com.orbitalsonic.generalproject.presentation.base.fragments.BaseFragment

class FragmentBottomNavSample :
    BaseFragment<FragmentBottomNavSampleBinding>(FragmentBottomNavSampleBinding::inflate) {

    override fun onViewCreated() {
        setupClicks()
    }

    private fun setupClicks(){
        binding.btnBottomNav.setOnClickListener {
            startActivity(Intent(activity, BottomNavGraphActivity::class.java))
        }
        binding.btnBottomNavSimple.setOnClickListener {
            startActivity(Intent(activity, BottomNavSimpleActivity::class.java))
        }
    }
}