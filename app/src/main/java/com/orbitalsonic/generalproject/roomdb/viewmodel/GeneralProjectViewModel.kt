package com.orbitalsonic.generalproject.roomdb.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.orbitalsonic.generalproject.roomdb.repository.GeneralProjectRepository
import com.orbitalsonic.generalproject.roomdb.tables.FavouriteTable
import kotlinx.coroutines.launch

class GeneralProjectViewModel(private val repository: GeneralProjectRepository) : ViewModel() {

    /***
     * Favourite ViewModel Methods
     */

    val allFavouriteList: LiveData<List<FavouriteTable>> = repository.allFavouriteList.asLiveData()

    fun insertFavourite(favouriteTable: FavouriteTable) = viewModelScope.launch {
        repository.insertFavourite(favouriteTable)
    }

    fun deleteFavourite(favouriteTable: FavouriteTable) = viewModelScope.launch {
        repository.deleteFavourite(favouriteTable)
    }

    fun updateFavourite(favouriteTable: FavouriteTable) = viewModelScope.launch {
        repository.updateFavourite(favouriteTable)
    }

    fun deleteAllFavourite() = viewModelScope.launch {
        repository.deleteAllFavouriteList()
    }

}