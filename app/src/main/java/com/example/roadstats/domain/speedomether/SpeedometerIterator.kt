package com.example.roadstats.domain.speedomether

import com.example.roadstats.data.speedomether.SpeedometerDataSource

class SpeedometerIterator(private val speedometerDataSource: SpeedometerDataSource) : SpeedometerUseCase {
    override suspend fun getCurrentSpeed(): Float {
        return speedometerDataSource.getSpeed()
    }
}
