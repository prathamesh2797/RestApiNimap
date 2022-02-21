package com.example.nimapinfotech.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.nimapinfotech.models.Record

@Database(entities = [Record::class], version = 1)
abstract class DataDatabase: RoomDatabase() {

    abstract fun getData(): Dao

    companion object{
        @Volatile
        private var INSTANCE: DataDatabase? = null

        fun getDatabase(context: Context): DataDatabase {
            return INSTANCE ?: synchronized(this){

                val instance = Room.databaseBuilder(context.applicationContext,
                    DataDatabase::class.java,"data_database")
                    .build()

                INSTANCE = instance

                instance
            }

        }
    }
}