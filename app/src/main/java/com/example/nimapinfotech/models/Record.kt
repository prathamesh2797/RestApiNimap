package com.example.nimapinfotech.models

import android.graphics.Bitmap
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "databaserecord")
data class Record(
    @PrimaryKey(autoGenerate = true)
    val dataId: Int,
    val Id: Int,
    val collectedValue: Int,
    val endDate: String,
    val mainImageURL: String,
    val shortDescription: String,
    val startDate: String,
    val title: String,
    val totalValue: Int,
)