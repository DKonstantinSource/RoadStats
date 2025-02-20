package com.example.roadstats.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.roadstats.data.mileage.entity.Mileage
import kotlinx.coroutines.flow.Flow

@Dao
interface MileageDao {
    @Query("SELECT * FROM mileage_table ORDER BY date DESC")
    fun getAllMileage(): Flow<List<Mileage>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertMileage(mileage: Mileage)

    @Query("SELECT * FROM mileage_table WHERE date = :date")
    suspend fun getAllMileageForDate(date: String): List<Mileage>
}