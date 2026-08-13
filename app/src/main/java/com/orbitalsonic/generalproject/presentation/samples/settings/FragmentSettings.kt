package com.orbitalsonic.generalproject.presentation.samples.settings

import android.app.Application
import android.os.Build
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.orbitalsonic.generalproject.BuildConfig
import com.orbitalsonic.generalproject.R
import com.orbitalsonic.generalproject.databinding.FragmentSettingsBinding
import com.orbitalsonic.generalproject.helpers.settings.bugReport
import com.orbitalsonic.generalproject.helpers.settings.privacyPolicy
import com.orbitalsonic.generalproject.helpers.settings.rateUs
import com.orbitalsonic.generalproject.helpers.settings.shareApp
import com.orbitalsonic.generalproject.helpers.settings.support
import com.orbitalsonic.generalproject.helpers.theme.AppTheme
import com.orbitalsonic.generalproject.helpers.theme.applyAppTheme
import com.orbitalsonic.generalproject.helpers.theme.themeTitleRes
import com.orbitalsonic.generalproject.presentation.base.fragments.BaseFragment
import com.orbitalsonic.generalproject.storage.preferences.SharedPrefManager

class FragmentSettings : BaseFragment<FragmentSettingsBinding>(FragmentSettingsBinding::inflate) {

    private val sharedPrefManager by lazy {
        SharedPrefManager(
            requireActivity().getSharedPreferences(
                "app_preferences",
                Application.MODE_PRIVATE
            )
        )
    }

    override fun onViewCreated() {
        initValues()
        setupClicks()
    }

    private fun initValues() {
        binding.mtvVersion.text = BuildConfig.VERSION_NAME
        updateThemeLabel()
    }

    private fun setupClicks() {
        binding.apply {
            btnAppLanguage.setOnClickListener {}

            btnAppTheme.setOnClickListener {
                showThemeDialog()
            }
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

    /**
     * Lets the user pick between System Default, Light and Dark.
     * Picking a mode saves it and applies it right away, AppCompat then
     * recreates the visible activities with the new theme.
     */
    private fun showThemeDialog() {
        val context = context ?: return
        val themeModes = AppTheme.allModes
        val themeTitles = themeModes.map { getString(themeTitleRes(it)) }.toTypedArray()
        val selectedIndex = themeModes.indexOf(sharedPrefManager.appThemeMode)

        MaterialAlertDialogBuilder(context)
            .setTitle(R.string.choose_theme)
            .setSingleChoiceItems(themeTitles, selectedIndex) { dialog, which ->
                dialog.dismiss()
                val selectedMode = themeModes[which]
                if (selectedMode != sharedPrefManager.appThemeMode) {
                    sharedPrefManager.appThemeMode = selectedMode
                    applyAppTheme(selectedMode)
                }
                updateThemeLabel()
            }
            .setNegativeButton(R.string.cancel, null)
            .show()
    }

    private fun updateThemeLabel() {
        binding.mtvTheme.setText(themeTitleRes(sharedPrefManager.appThemeMode))
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
