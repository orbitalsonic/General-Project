package com.orbitalsonic.generalproject.presentation.startup

import android.app.Application
import android.content.Intent
import com.orbitalsonic.generalproject.databinding.FragmentStartupOnboardingBinding
import com.orbitalsonic.generalproject.presentation.MainActivity
import com.orbitalsonic.generalproject.presentation.base.fragments.BaseFragment
import com.orbitalsonic.generalproject.storage.preferences.SharedPrefManager


class FragmentStartupOnboarding :
    BaseFragment<FragmentStartupOnboardingBinding>(FragmentStartupOnboardingBinding::inflate) {

    private val sharedPrefManager by lazy { SharedPrefManager(requireActivity().getSharedPreferences(
        "app_preferences",
        Application.MODE_PRIVATE)) }

    override fun onViewCreated() {
        setupClicks()
    }

    private fun setupClicks() {
        binding.btnNext.setOnClickListener {
            sharedPrefManager.isFirstTimeEntrance = false
            startActivity(Intent(activity, MainActivity::class.java))
            activity?.finish()
        }
    }

}