package com.example.roadstats.domain.speedometer

interface SpeedometerUseCase {
    suspend fun getCurrentSpeed(): Float
}
