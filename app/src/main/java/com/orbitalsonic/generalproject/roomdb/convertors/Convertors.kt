package com.orbitalsonic.generalproject.roomdb.convertors

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.orbitalsonic.generalproject.roomdb.tables.City

class Convertors {

    @TypeConverter
    fun fromCity(city: City): String {
        return Gson().toJson(city)
    }

    @TypeConverter
    fun toCity(json: String): City {
        return Gson().fromJson(json, City::class.java)
    }
}