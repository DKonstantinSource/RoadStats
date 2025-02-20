package com.example.roadstats.data.settings

import android.content.Context
import com.example.roadstats.Constants.Companion.THEME_PREFERENCE
import com.example.roadstats.domain.settings.SettingsInteractor
import com.example.roadstats.domain.settings.SettingsInteractorImpl
import com.example.roadstats.domain.settings.SettingsRepository
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val themePreferenceModule = module {
    factory<SettingsRepository> { SettingsRepositoryImpl(get()) }
    factory<SettingsInteractor> { SettingsInteractorImpl(get()) }
    single { androidContext().getSharedPreferences(THEME_PREFERENCE, Context.MODE_PRIVATE) }
}