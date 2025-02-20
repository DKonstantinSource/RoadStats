package com.example.roadstats.di

import com.example.roadstats.ui.mileage.MileageViewModel
import com.example.roadstats.ui.notifications.SettingsViewModel
import com.example.roadstats.ui.speedometer.SpeedometerViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dataModule = module {
    viewModel { SpeedometerViewModel(get(), get()) }
    viewModel {SettingsViewModel(get())}
    viewModel { MileageViewModel(get()) }
}