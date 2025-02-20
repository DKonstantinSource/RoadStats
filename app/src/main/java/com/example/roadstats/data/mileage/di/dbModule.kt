package com.example.roadstats.data.mileage.di

import com.example.roadstats.data.mileage.MileageRepository
import com.example.roadstats.db.MileageDatabase
import com.example.roadstats.domain.mileage.GetMileageUseCase
import com.example.roadstats.domain.mileage.SaveMileageUseCase
import org.koin.dsl.module

val dbModule = module{
    single { MileageRepository(get()) }

    single { MileageDatabase.create(get()) }
    single { get<MileageDatabase>().mileageDao() }

    factory { GetMileageUseCase(get()) }
    factory { SaveMileageUseCase(get()) }
}