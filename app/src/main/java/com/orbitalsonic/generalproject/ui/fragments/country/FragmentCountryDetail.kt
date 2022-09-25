package com.orbitalsonic.generalproject.ui.fragments.country

import androidx.navigation.fragment.navArgs
import com.orbitalsonic.generalproject.R
import com.orbitalsonic.generalproject.databinding.FragmentCountryDetailBinding
import com.orbitalsonic.generalproject.helpers.interfaces.SonicBackPressedCallback
import com.orbitalsonic.generalproject.ui.fragments.base.BaseFragment

class FragmentCountryDetail : BaseFragment<FragmentCountryDetailBinding>(R.layout.fragment_country_detail) {

    private val args: FragmentCountryDetailArgs by navArgs()

    override fun onViewCreatedOneTime() {
        setUI()
    }

    override fun onViewCreatedEverytime() {
        registerBackPressDispatcher()
    }

    private fun setUI() {
        binding.tvResultsCountryDetail.text = args.countryTable.toString()
    }

    private fun registerBackPressDispatcher() {
        sonicBackPress(object : SonicBackPressedCallback {
            override fun onSonicBackPressed() {
                popFrom(R.id.fragmentCountryDetail)
            }

        })
    }

}