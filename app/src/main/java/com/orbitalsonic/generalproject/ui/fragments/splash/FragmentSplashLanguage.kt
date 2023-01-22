package com.orbitalsonic.generalproject.ui.fragments.splash

import com.orbitalsonic.generalproject.R
import com.orbitalsonic.generalproject.databinding.FragmentSplashLanguageBinding
import com.orbitalsonic.generalproject.helpers.adapters.listView.AdapterLanguage
import com.orbitalsonic.generalproject.helpers.dataModels.LanguageItem
import com.orbitalsonic.generalproject.helpers.dataProvider.DpLanguages
import com.orbitalsonic.generalproject.ui.activities.SplashActivity
import com.orbitalsonic.generalproject.ui.fragments.base.BaseFragment

class FragmentSplashLanguage : BaseFragment<FragmentSplashLanguageBinding>(R.layout.fragment_splash_language) {

    private val dpLanguages by lazy { DpLanguages() }
    private var languageItem: LanguageItem? = null
    private val adapterLanguage by lazy {
        AdapterLanguage(
            globalContext,
            dpLanguages.getLanguagesList(diComponent.sharedPreferenceUtils.selectedLanguageCode)
        )
    }

    override fun onViewCreatedOneTime() {
        initLanguages()

        binding.mbContinueLanguage.setOnClickListener { onContinueClick() }
    }

    override fun onViewCreatedEverytime() {}

    private fun initLanguages() = binding.actDropDownLanguage.apply {
        languageItem = dpLanguages.getLanguagesList()[0].also {
            setText(it.languageName, false)
        }
        setAdapter(adapterLanguage)
        setOnItemClickListener { parent, view, position, id ->
            languageItem = dpLanguages.getLanguagesList()[position].also {
                setText(it.languageName, false)
            }
        }
    }

    /**
     * Add Service in Manifest first
     */

    private fun onContinueClick() {
        languageItem?.let {
            diComponent.sharedPreferenceUtils.selectedLanguageCode = it.languageCode
            diComponent.sharedPreferenceUtils.showFirstScreen = false
            (activity as SplashActivity).nextActivity()
        }
    }

    override fun navIconBackPressed() {}

    override fun onBackPressed() {}
}