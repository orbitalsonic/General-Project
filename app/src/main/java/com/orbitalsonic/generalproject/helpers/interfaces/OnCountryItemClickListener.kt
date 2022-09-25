package com.orbitalsonic.generalproject.helpers.interfaces

import com.orbitalsonic.generalproject.roomdb.tables.CountryTable

interface OnCountryItemClickListener {
    fun onCountryClick(countryTable: CountryTable)
}