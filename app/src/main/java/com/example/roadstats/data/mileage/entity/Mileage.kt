package com.example.roadstats.data.mileage.entity


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "mileage_table")
data class Mileage(
    @PrimaryKey val date: String,
    val distance: Float
)