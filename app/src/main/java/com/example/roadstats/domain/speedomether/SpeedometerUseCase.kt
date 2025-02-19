package com.example.roadstats.domain.speedomether

interface SpeedometerUseCase {
    suspend fun getCurrentSpeed(): Float
}
