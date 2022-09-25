package com.orbitalsonic.generalproject.roomdb.daos

import androidx.room.*
import com.orbitalsonic.generalproject.roomdb.tables.FavouriteTable
import kotlinx.coroutines.flow.Flow

@Dao
interface GeneralProjectDao {
    
    /***
     * Favourite DAO
     */

    @Query("SELECT * FROM favourite_table ORDER BY id DESC")
    fun getAllFavouriteList(): Flow<List<FavouriteTable>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertFavourite(favouriteTable: FavouriteTable)

    @Delete
    suspend fun deleteFavourite(favouriteTable: FavouriteTable)

    @Update
    suspend fun updateFavourite(favouriteTable: FavouriteTable)

    @Query("DELETE FROM favourite_table")
    suspend fun deleteAllFavourite()
}