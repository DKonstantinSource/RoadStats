package com.example.roadstats.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roadstats.data.mileage.entity.Mileage

@Database(entities = [Mileage::class], version = 2, exportSchema = false)
abstract class MileageDatabase : RoomDatabase() {
    abstract fun mileageDao(): MileageDao

    companion object {


        fun create(context: Context): MileageDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                MileageDatabase::class.java,
                "mileage_database"
            )
                .build()
        }
    }
}