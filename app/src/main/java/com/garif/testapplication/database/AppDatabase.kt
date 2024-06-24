package com.garif.testapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.garif.testapplication.database.dao.BouquetDao
import com.garif.testapplication.database.dao.BouquetFlowerDao
import com.garif.testapplication.database.model.Bouquet
import com.garif.testapplication.database.model.BouquetFlower
import com.garif.testapplication.database.model.Flower

@Database(entities = [Bouquet::class, Flower::class, BouquetFlower::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bouquetDao(): BouquetDao
    abstract fun bouquetFlowerDao(): BouquetFlowerDao

    companion object {

        private const val DATABASE_NAME = "bouquets.db"

        @Volatile
        private var instance: AppDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            buildDatabase(context).also { instance = it }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context, AppDatabase::class.java, DATABASE_NAME)
                .fallbackToDestructiveMigration()
                .build()
    }
}