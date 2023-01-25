package com.orbitalsonic.generalproject.ui.fragments.splash

import androidx.lifecycle.lifecycleScope
import com.orbitalsonic.generalproject.R
import com.orbitalsonic.generalproject.databinding.FragmentSplashBinding
import com.orbitalsonic.generalproject.ui.activities.SplashActivity
import com.orbitalsonic.generalproject.ui.fragments.base.BaseFragment

class FragmentSplash : BaseFragment<FragmentSplashBinding>(R.layout.fragment_splash) {

    override fun onViewCreatedOneTime() {
        fetchRemoteConfiguration()
    }

    override fun onViewCreatedEverytime() {}

    override fun navIconBackPressed() {}

    override fun onBackPressed() {}

    private fun fetchRemoteConfiguration() {
        diComponent.remoteConfiguration.checkRemoteConfig {
            withDelay(2000) {
                lifecycleScope.launchWhenResumed {
                    (activity as SplashActivity).nextActivity()
                }
            }
        }
    }

}