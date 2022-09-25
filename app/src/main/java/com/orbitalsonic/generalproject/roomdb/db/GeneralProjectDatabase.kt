package com.orbitalsonic.generalproject.roomdb.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.orbitalsonic.generalproject.roomdb.daos.GeneralProjectDao
import com.orbitalsonic.generalproject.roomdb.tables.FavouriteTable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(
    entities = [FavouriteTable::class],
    version = 1,
    exportSchema = false
)
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

    private class GeneralProjectDatabaseCallback(
        private val scope: CoroutineScope, context: Context
    ) : Callback() {

        private val mContext = context

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    // Delete all content here.
                }
            }
        }
    }

}