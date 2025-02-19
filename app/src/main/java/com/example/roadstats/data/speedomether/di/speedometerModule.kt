package com.example.roadstats.data.speedomether.di

import com.example.roadstats.data.speedomether.SpeedometerDataSource
import com.example.roadstats.data.speedomether.SpeedometerImpl
import com.example.roadstats.domain.speedomether.SpeedometerIterator
import com.example.roadstats.domain.speedomether.SpeedometerUseCase
import org.koin.dsl.module

val speedometerModule = module {

    single<SpeedometerDataSource> { SpeedometerImpl(get ()) }
    factory<SpeedometerUseCase> { SpeedometerIterator(get()) }
}