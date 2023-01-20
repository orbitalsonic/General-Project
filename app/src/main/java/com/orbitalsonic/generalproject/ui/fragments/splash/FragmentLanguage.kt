package com.orbitalsonic.generalproject.ui.fragments.splash

import android.content.Intent
import com.orbitalsonic.generalproject.R
import com.orbitalsonic.generalproject.databinding.FragmentLanguageBinding
import com.orbitalsonic.generalproject.helpers.adapters.listView.AdapterLanguage
import com.orbitalsonic.generalproject.helpers.dataProvider.DpLanguages
import com.orbitalsonic.generalproject.ui.activities.MainActivity
import com.orbitalsonic.generalproject.ui.fragments.base.BaseFragment

class FragmentLanguage : BaseFragment<FragmentLanguageBinding>(R.layout.fragment_language) {

    private val dpLanguages by lazy { DpLanguages() }
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
        val defaultLanguage = dpLanguages.getLanguagesList()[0]
        setText(defaultLanguage.languageName, false)
        setAdapter(adapterLanguage)
        setOnItemClickListener { parent, view, position, id ->
            val language = dpLanguages.getLanguagesList()[position]
            diComponent.sharedPreferenceUtils.selectedLanguageCode = language.languageCode
            setText(language.languageName, false)
        }
    }

    private fun onContinueClick() {
        //diComponent.sharedPreferenceUtils.showFirstScreen = false
        startActivity(Intent(globalActivity, MainActivity::class.java))
        globalActivity.finish()
    }

    override fun navIconBackPressed() {}

    override fun onBackPressed() {}
}