package com.orbitalsonic.generalproject.ui.fragments.languages

import com.orbitalsonic.generalproject.R
import com.orbitalsonic.generalproject.databinding.FragmentLanguageBinding
import com.orbitalsonic.generalproject.helpers.adapters.listView.AdapterLanguage
import com.orbitalsonic.generalproject.helpers.dataModels.LanguageItem
import com.orbitalsonic.generalproject.helpers.dataProvider.DpLanguages
import com.orbitalsonic.generalproject.ui.activities.MainActivity
import com.orbitalsonic.generalproject.ui.fragments.base.BaseFragment

class FragmentLanguage : BaseFragment<FragmentLanguageBinding>(R.layout.fragment_language) {

    private val dpLanguages by lazy { DpLanguages() }
    private var languageItem: LanguageItem? = null
    private var adapterLanguage:AdapterLanguage? = null
    private val langList =  dpLanguages.getLanguagesList(diComponent.sharedPreferenceUtils.selectedLanguageCode)

    override fun onViewCreatedOneTime() {}

    override fun onViewCreatedEverytime() {
        initLanguages()
        binding.mbContinueLanguage.setOnClickListener { onContinueClick() }
    }

    private fun initLanguages() = binding.actDropDownLanguage.apply {
        adapterLanguage = AdapterLanguage(globalContext,langList)
        val indexOf = langList.indexOfFirst{ it.languageCode == diComponent.sharedPreferenceUtils.selectedLanguageCode }
        languageItem = langList[indexOf].also {
            setText(it.languageName, false)
        }
        setAdapter(adapterLanguage)
        setOnItemClickListener { parent, view, position, id ->
            languageItem = langList[position].also {
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
            (activity as MainActivity).onRecreate()
        }?: kotlin.run {
            popFrom(R.id.fragmentLanguage)
        }
    }

    override fun navIconBackPressed() {
        onBackPressed()
    }

    override fun onBackPressed() {
        popFrom(R.id.fragmentLanguage)
    }
}