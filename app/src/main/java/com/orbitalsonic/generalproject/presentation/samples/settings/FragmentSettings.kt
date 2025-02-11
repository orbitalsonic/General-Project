package com.orbitalsonic.generalproject.presentation.samples.settings

import android.os.Build
import com.orbitalsonic.generalproject.BuildConfig
import com.orbitalsonic.generalproject.databinding.FragmentSettingsBinding
import com.orbitalsonic.generalproject.helpers.settings.bugReport
import com.orbitalsonic.generalproject.helpers.settings.privacyPolicy
import com.orbitalsonic.generalproject.helpers.settings.rateUs
import com.orbitalsonic.generalproject.helpers.settings.shareApp
import com.orbitalsonic.generalproject.helpers.settings.support
import com.orbitalsonic.generalproject.presentation.base.fragments.BaseFragment

class FragmentSettings : BaseFragment<FragmentSettingsBinding>(FragmentSettingsBinding::inflate) {

    override fun onViewCreated() {
        setupClicks()
    }

    private fun setupClicks() {
        binding.apply {
            btnAppLanguage.setOnClickListener {}

            btnRateUs.setOnClickListener {
                activity.rateUs()
            }
            btnShareApp.setOnClickListener {
                activity.shareApp()
            }
            btnContactUs.setOnClickListener {
                activity.support()
            }
            btnReportBugs.setOnClickListener {
                activity.bugReport(deviceInfo())
            }
            btnPrivacyPolicy.setOnClickListener {
                activity.privacyPolicy()
            }
        }
    }

    private fun deviceInfo(): String {
        val stringBuilder = StringBuilder()

        stringBuilder.append("Please mention issue...: \n\n\n\n")


        // Device Info
        stringBuilder.append("Device Info \n")
        stringBuilder.append("Device: ${Build.DEVICE} \n")
        stringBuilder.append("Device Model: ${Build.MODEL} \n")
        stringBuilder.append("Device BRAND: ${Build.BRAND} \n")
        stringBuilder.append("Device MANUFACTURER: ${Build.MANUFACTURER} \n")
        stringBuilder.append("Version Name: ${BuildConfig.VERSION_NAME} \n")
        stringBuilder.append("Version Code: ${BuildConfig.VERSION_CODE} \n")


        return stringBuilder.toString()
    }

}