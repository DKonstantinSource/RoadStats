package com.example.roadstats.domain.mileage

import com.example.roadstats.data.mileage.MileageRepository

class SaveMileageUseCase(private val repository: MileageRepository) {
    suspend operator fun invoke(distance: Float) {
        repository.insertMileage(distance)
    }
}
