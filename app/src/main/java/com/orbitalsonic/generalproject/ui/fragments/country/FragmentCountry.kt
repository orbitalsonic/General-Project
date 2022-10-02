package com.orbitalsonic.generalproject.ui.fragments.country

import com.orbitalsonic.generalproject.R
import com.orbitalsonic.generalproject.databinding.FragmentCountryBinding
import com.orbitalsonic.generalproject.helpers.adapters.recyclerView.AdapterCountry
import com.orbitalsonic.generalproject.helpers.dataProvider.DPCountry
import com.orbitalsonic.generalproject.helpers.interfaces.OnCountryItemClickListener
import com.orbitalsonic.generalproject.roomdb.tables.CountryTable
import com.orbitalsonic.generalproject.ui.fragments.base.BaseFragment

class FragmentCountry : BaseFragment<FragmentCountryBinding>(R.layout.fragment_country) {

    private lateinit var adapterCountry: AdapterCountry
    private val dpCountry by lazy { DPCountry() }

    override fun onViewCreatedOneTime() {
        initRecyclerView()
        fillList()
    }

    override fun onViewCreatedEverytime() {

    }

    private fun initRecyclerView() {
        adapterCountry = AdapterCountry(object : OnCountryItemClickListener {
            override fun onCountryClick(countryTable: CountryTable) {
                diComponent.generalProjectViewModel.insertCountry(countryTable)
                onBackPressed()
            }
        })
        binding.rvOriginalListCountry.adapter = adapterCountry
    }

    private fun fillList() = adapterCountry.submitList(dpCountry.countryTableList)

    override fun onBackPressed() {
        popFrom(R.id.fragmentCountry)
    }

}