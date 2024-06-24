package com.garif.testapplication.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "flowers")
data class Flower(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "flower_id")
    val flowerId: Int,
    val name: String,
    var stock: Int,
)
