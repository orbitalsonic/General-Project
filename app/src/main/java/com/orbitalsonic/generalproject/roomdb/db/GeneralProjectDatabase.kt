package com.orbitalsonic.generalproject.roomdb.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import com.orbitalsonic.generalproject.roomdb.convertors.Convertors
import com.orbitalsonic.generalproject.roomdb.daos.GeneralProjectDao
import com.orbitalsonic.generalproject.roomdb.tables.City
import com.orbitalsonic.generalproject.roomdb.tables.CountryTable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(
    entities = [CountryTable::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(Convertors::class)
abstract class GeneralProjectDatabase : RoomDatabase() {

    abstract fun generalProjectDao(): GeneralProjectDao

    companion object {

        @Volatile
        private var INSTANCE: GeneralProjectDatabase? = null
        fun getDatabase(context: Context, scope: CoroutineScope): GeneralProjectDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    GeneralProjectDatabase::class.java,
                    "general_project_databases"
                ).addCallback(GeneralProjectDatabaseCallback(scope, context))
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }

    private class GeneralProjectDatabaseCallback(private val scope: CoroutineScope, context: Context) : Callback() {

        private val mContext = context

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    // By-Default items on database creation
                    with(database.generalProjectDao()) {
                        deleteAllCountry()
                        insertCountry(CountryTable(countryName = "India", countryCode = "06", countryFlag = "flag_india", city = City(cityName = "Islamabad", cityPostalCode = "51310")))
                        insertCountry(CountryTable(countryName = "Italy", countryCode = "07", countryFlag = "flag_italy", city = City(cityName = "Islamabad", cityPostalCode = "51310")))
                        insertCountry(CountryTable(countryName = "Japan", countryCode = "08", countryFlag = "flag_japan", city = City(cityName = "Islamabad", cityPostalCode = "51310")))
                        insertCountry(CountryTable(countryName = "Malaysia", countryCode = "09", countryFlag = "flag_malaysia", city = City(cityName = "Islamabad", cityPostalCode = "51310")))
                    }
                }
            }
        }
    }
}