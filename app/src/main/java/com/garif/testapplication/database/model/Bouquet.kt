package com.garif.testapplication.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bouquets")
data class Bouquet(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "bouquet_id")
    val bouquetId: Int,
    val name: String,
)
