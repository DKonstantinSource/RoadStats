package com.example.roadstats.domain.mileage

import com.example.roadstats.data.mileage.entity.Mileage
import com.example.roadstats.data.mileage.MileageRepository
import kotlinx.coroutines.flow.Flow

class GetMileageUseCase(private val repository: MileageRepository) {
    operator fun invoke(): Flow<List<Mileage>> = repository.getAllMileage()
}