package com.orbitalsonic.generalproject.ui.fragments.country

import com.orbitalsonic.generalproject.R
import com.orbitalsonic.generalproject.databinding.FragmentCountryBinding
import com.orbitalsonic.generalproject.helpers.adapters.recyclerView.AdapterCountry
import com.orbitalsonic.generalproject.helpers.dataProvider.DPCountry
import com.orbitalsonic.generalproject.helpers.interfaces.OnCountryItemClickListener
import com.orbitalsonic.generalproject.helpers.interfaces.SonicBackPressedCallback
import com.orbitalsonic.generalproject.roomdb.tables.CountryTable
import com.orbitalsonic.generalproject.ui.fragments.base.BaseFragment

class FragmentCountry : BaseFragment<FragmentCountryBinding>(R.layout.fragment_country) {

    private lateinit var adapterCountry: AdapterCountry
    private val dpCountry by lazy { DPCountry() }

    override fun onViewCreatedOneTime() {
        initRecyclerView()
        setUI()
    }

    override fun onViewCreatedEverytime() {
        registerBackPressDispatcher()
    }

    private fun initRecyclerView() {
        adapterCountry = AdapterCountry(object : OnCountryItemClickListener {
            override fun onCountryClick(countryTable: CountryTable) {
                diComponent.generalProjectViewModel.insertCountry(countryTable)
                popFrom(R.id.fragmentCountry)
            }
        })
        binding.rvOriginalListCountry.adapter = adapterCountry
    }

    private fun setUI() = adapterCountry.submitList(dpCountry.countryTableList)

    private fun registerBackPressDispatcher() {
        sonicBackPress(object :SonicBackPressedCallback{
            override fun onSonicBackPressed() {
                popFrom(R.id.fragmentCountry)
            }

        })
    }
}