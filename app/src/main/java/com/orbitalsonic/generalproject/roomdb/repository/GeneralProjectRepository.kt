package com.orbitalsonic.generalproject.roomdb.repository

import androidx.annotation.WorkerThread
import com.orbitalsonic.generalproject.roomdb.daos.GeneralProjectDao
import com.orbitalsonic.generalproject.roomdb.tables.FavouriteTable
import kotlinx.coroutines.flow.Flow

class GeneralProjectRepository(private val generalProjectDao: GeneralProjectDao) {


    /***
     * favourite_table methods
     */

    val allFavouriteList: Flow<List<FavouriteTable>> = generalProjectDao.getAllFavouriteList()

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insertFavourite(favouriteTable: FavouriteTable) {
        generalProjectDao.insertFavourite(favouriteTable)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun deleteFavourite(favouriteTable: FavouriteTable) {
        generalProjectDao.deleteFavourite(favouriteTable)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun updateFavourite(favouriteTable: FavouriteTable) {
        generalProjectDao.updateFavourite(favouriteTable)
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun deleteAllFavouriteList() {
        generalProjectDao.deleteAllFavourite()
    }

}