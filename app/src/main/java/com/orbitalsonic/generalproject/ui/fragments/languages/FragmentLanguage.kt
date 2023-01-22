package com.orbitalsonic.generalproject.ui.fragments.languages

import androidx.appcompat.app.AppCompatDelegate
import com.orbitalsonic.generalproject.R
import com.orbitalsonic.generalproject.databinding.FragmentLanguageBinding
import com.orbitalsonic.generalproject.helpers.adapters.recyclerView.AdapterLanguage
import com.orbitalsonic.generalproject.helpers.dataModels.LanguageItem
import com.orbitalsonic.generalproject.helpers.dataProvider.DpLanguages
import com.orbitalsonic.generalproject.helpers.interfaces.OnLanguageItemClickListener
import com.orbitalsonic.generalproject.helpers.listeners.DebounceListener.setDebounceClickListener
import com.orbitalsonic.generalproject.ui.fragments.base.BaseFragment

class FragmentLanguage : BaseFragment<FragmentLanguageBinding>(R.layout.fragment_language), OnLanguageItemClickListener {

    private val adapterLanguage by lazy { AdapterLanguage(this) }
    private val dpLanguages by lazy { DpLanguages() }
    private var languageItem: LanguageItem? = null

    override fun onViewCreatedOneTime() {
        initRecyclerView()
        fillList()

        binding.mbSubmitLanguage.setDebounceClickListener { onSubmitClick() }
    }

    override fun onViewCreatedEverytime() {}

    private fun initRecyclerView() {
        binding.rvListLanguage.adapter = adapterLanguage
    }

    private fun fillList() {
        val languageCode = AppCompatDelegate.getApplicationLocales().toLanguageTags()
        val list = dpLanguages.getLanguagesList(languageCode)
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
            globalActivity.recreate()
        }
        popFrom(R.id.fragmentLanguage)
    }

    override fun navIconBackPressed() {
        onBackPressed()
    }

    override fun onBackPressed() {
        popFrom(R.id.fragmentLanguage)
    }
}