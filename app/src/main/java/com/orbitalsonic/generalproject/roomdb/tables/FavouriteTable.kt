package com.orbitalsonic.generalproject.roomdb.tables

import android.os.Parcelable
import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
@Entity(tableName = "favourite_table")
data class FavouriteTable(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    @ColumnInfo(name = "countryName") var fromLanguageName: String,
    @ColumnInfo(name = "countryCode") var toLanguageName: String,
    @ColumnInfo(name = "countryFlag") var fromLanguageCode: String,
    @ColumnInfo(name = "city") var city: City
): Parcelable
