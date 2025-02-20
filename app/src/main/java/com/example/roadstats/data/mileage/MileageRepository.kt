package com.example.roadstats.data.mileage

import com.example.roadstats.Constants.Companion.INSERT_DATE_FORMAT
import com.example.roadstats.data.mileage.entity.Mileage
import com.example.roadstats.db.MileageDao
import kotlinx.coroutines.flow.Flow
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MileageRepository(private val mileageDao: MileageDao) {
    fun getAllMileage(): Flow<List<Mileage>> = mileageDao.getAllMileage()

    suspend fun insertMileage(distance: Float) {
        val currentDate = SimpleDateFormat(INSERT_DATE_FORMAT, Locale.getDefault()).format(Date())


        val existingMileages = mileageDao.getAllMileageForDate(currentDate)


        if (existingMileages.isNotEmpty()) {
            val totalDistance = existingMileages.fold(0f) { acc, mileage -> acc + mileage.distance } + distance
            val mileage = Mileage(date = currentDate, distance = totalDistance)
            mileageDao.insertMileage(mileage)
        } else {
            val mileage = Mileage(date = currentDate, distance = distance)
            mileageDao.insertMileage(mileage)
        }
    }
}