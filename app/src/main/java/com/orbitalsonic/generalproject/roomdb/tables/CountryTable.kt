package com.orbitalsonic.generalproject.roomdb.tables

import android.os.Parcelable
import androidx.annotation.Keep
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
@Entity(tableName = "country_table")
data class CountryTable(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    @ColumnInfo(name = "countryName") var countryName: String,
    @ColumnInfo(name = "countryCode") var countryCode: String,
    @ColumnInfo(name = "countryFlag") var countryFlag: String,
    @ColumnInfo(name = "city") var city: City
) : Parcelable
