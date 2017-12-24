package de.prose.aandp.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context

/**
 * Created by Philip on 16.12.2017.
 */
@Database(entities = arrayOf(Item::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun itemDao() : ItemDao

    companion object {

        @Volatile private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
                INSTANCE ?: synchronized(this) {
                    INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
                }

        private fun buildDatabase(context: Context) =
                Room.databaseBuilder(context, AppDatabase::class.java, "itemfinder.db").allowMainThreadQueries().build()
    }



}