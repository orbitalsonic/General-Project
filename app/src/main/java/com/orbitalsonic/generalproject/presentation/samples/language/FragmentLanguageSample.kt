package com.orbitalsonic.generalproject.presentation.samples.language

import android.app.Application
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.Lifecycle
import com.orbitalsonic.generalproject.R
import com.orbitalsonic.generalproject.databinding.FragmentLanguageSampleBinding
import com.orbitalsonic.generalproject.helpers.locale.applyLanguage
import com.orbitalsonic.generalproject.presentation.base.fragments.BaseFragment
import com.orbitalsonic.generalproject.presentation.samples.language.adapters.AdapterLanguage
import com.orbitalsonic.generalproject.presentation.samples.language.interfaces.OnLanguageItemClickListener
import com.orbitalsonic.generalproject.presentation.samples.language.models.LanguageItem
import com.orbitalsonic.generalproject.presentation.samples.language.repository.LanguageRepository
import com.orbitalsonic.generalproject.storage.preferences.SharedPrefManager
import com.orbitalsonic.generalproject.storage.provider.DpLanguages

class FragmentLanguageSample :
    BaseFragment<FragmentLanguageSampleBinding>(FragmentLanguageSampleBinding::inflate),
    OnLanguageItemClickListener {

    private val adapterLanguage by lazy { AdapterLanguage(this) }
    private val dpLanguages by lazy { DpLanguages() }

    private var languageItem: LanguageItem? = null


    private val sharedPrefManager by lazy { SharedPrefManager(requireActivity().getSharedPreferences(
        "app_preferences",
        Application.MODE_PRIVATE)) }

    override fun onViewCreated() {
        initRecyclerView()
        setupListener()
        setupMenu()
    }

    private fun setupListener() {
        binding.etSearchText.apply {
            doAfterTextChanged {
                if (isAdded) {
                    searchLanguage(it.toString())
                }
            }
        }
    }

    private fun setupMenu() {
        val menuHost: MenuHost = requireActivity()

        menuHost.addMenuProvider(object : MenuProvider {
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.menu_language, menu)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return when (menuItem.itemId) {
                    R.id.action_apply -> {
                        onApplyClick()
                        true
                    }
                    else -> false
                }
            }
        }, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    private fun initRecyclerView() {
        binding.languageRecyclerview.adapter = adapterLanguage
        fillList()
    }

    private fun fillList() {
        val list = dpLanguages.getLanguagesList(sharedPrefManager.appLanguageCode)
        adapterLanguage.submitList(list)
    }

    private fun onApplyClick() {
        languageItem?.let {
            if (sharedPrefManager.appLanguageCode != it.languageCode){
                sharedPrefManager.appLanguageCode = it.languageCode
                applyLanguage(it.languageCode)
            }
        }
    }

    override fun onItemClick(languageItem: LanguageItem) {
        this.languageItem = languageItem
        val newList = dpLanguages.getLanguagesList(languageItem.languageCode)
        adapterLanguage.submitList(newList)
    }

    private fun searchLanguage(query: String){
        LanguageRepository.searchLanguage(query,sharedPrefManager.appLanguageCode){
            try {
                if (it.isEmpty()){
                    binding.tvNothingFound.visibility = View.VISIBLE
                }else{
                    binding.tvNothingFound.visibility = View.GONE
                }
                adapterLanguage.submitList(it)
            }catch (ex:Exception){
                ex.printStackTrace()
            }
        }
    }
}