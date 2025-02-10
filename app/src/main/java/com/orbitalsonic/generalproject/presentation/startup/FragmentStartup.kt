package com.orbitalsonic.generalproject.presentation.startup

import android.content.Intent
import com.orbitalsonic.generalproject.databinding.FragmentStartupBinding
import com.orbitalsonic.generalproject.helpers.handlers.withDelay
import com.orbitalsonic.generalproject.helpers.lifecycle.launchWhenResumed
import com.orbitalsonic.generalproject.presentation.MainActivity
import com.orbitalsonic.generalproject.presentation.base.fragments.BaseFragment


class FragmentStartup : BaseFragment<FragmentStartupBinding>(FragmentStartupBinding::inflate) {

    override fun onViewCreated() {
        withDelay(5500) {
            launchWhenResumed {
                if (isAdded){
                    startActivity(Intent(activity, MainActivity::class.java))
                    activity?.finish()
                }
            }
        }
    }

}