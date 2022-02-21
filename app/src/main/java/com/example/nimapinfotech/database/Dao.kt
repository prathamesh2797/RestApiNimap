package com.example.nimapinfotech.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.nimapinfotech.models.Data
import com.example.nimapinfotech.models.DataList
import com.example.nimapinfotech.models.Record

@Dao
interface Dao {

    @Insert
    suspend fun addData(data: List<Record>)


    @Query("SELECT * FROM databaserecord")
    fun getData(): List<Record>
}