package com.orbitalsonic.generalproject.ui.fragments.splash

import androidx.lifecycle.lifecycleScope
import com.orbitalsonic.generalproject.R
import com.orbitalsonic.generalproject.databinding.FragmentSplashStartBinding
import com.orbitalsonic.generalproject.ui.activities.SplashActivity
import com.orbitalsonic.generalproject.ui.fragments.base.BaseFragment

class FragmentSplashStart : BaseFragment<FragmentSplashStartBinding>(R.layout.fragment_splash_start) {

    override fun onViewCreatedOneTime() {
        fetchRemoteConfiguration()
    }

    private fun fetchRemoteConfiguration() {
        diComponent.remoteConfiguration.checkRemoteConfig {
            withDelay(3000) {
                lifecycleScope.launchWhenResumed {
                    navigateTo(R.id.fragmentStart, R.id.action_fragmentStart_to_fragmentSplashLanguage)
                }
            }
        }
    }

    override fun onViewCreatedEverytime() {}

    override fun navIconBackPressed() {}

    override fun onBackPressed() {}

}