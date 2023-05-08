package com.orbitalsonic.generalproject.ui.fragments.splash

import androidx.lifecycle.lifecycleScope
import com.orbitalsonic.generalproject.R
import com.orbitalsonic.generalproject.databinding.FragmentSplashLanguageBinding
import com.orbitalsonic.generalproject.helpers.adapters.recyclerView.AdapterLanguage
import com.orbitalsonic.generalproject.helpers.dataModels.LanguageItem
import com.orbitalsonic.generalproject.helpers.dataProvider.DpLanguages
import com.orbitalsonic.generalproject.helpers.interfaces.OnLanguageItemClickListener
import com.orbitalsonic.generalproject.helpers.listeners.DebounceListener.setDebounceClickListener
import com.orbitalsonic.generalproject.ui.activities.SplashActivity
import com.orbitalsonic.generalproject.ui.fragments.base.BaseFragment

class FragmentSplashLanguage : BaseFragment<FragmentSplashLanguageBinding>(R.layout.fragment_splash_language), OnLanguageItemClickListener {

    private val adapterLanguage by lazy { AdapterLanguage(this) }
    private val dpLanguages by lazy { DpLanguages() }
    private var languageItem: LanguageItem? = null

    override fun onViewCreatedOneTime() {
        initRecyclerView()
        fillList()

        binding.btnContinue.setDebounceClickListener { onSubmitClick() }
    }

    override fun onViewCreatedEverytime() {}

    private fun initRecyclerView() {
        binding.langRecyclerview.adapter = adapterLanguage
    }

    private fun fillList() {
        val list = dpLanguages.getLanguagesList(diComponent.sharedPreferenceUtils.selectedLanguageCode)
        adapterLanguage.submitList(list)
    }

    override fun onItemClick(languageItem: LanguageItem) {
        this.languageItem = languageItem
        val newList = dpLanguages.getLanguagesList(languageItem.languageCode)
        adapterLanguage.submitList(newList)
    }

    private fun onSubmitClick() {
        languageItem?.let {
            diComponent.sharedPreferenceUtils.selectedLanguageCode = it.languageCode
        }
        lifecycleScope.launchWhenResumed {
            diComponent.sharedPreferenceUtils.showFirstScreen = false
            (activity as SplashActivity).nextActivity()
        }
    }

    override fun navIconBackPressed() {}
    override fun onBackPressed() {}
}