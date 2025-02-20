package com.example.roadstats

import android.app.Application
import com.example.roadstats.data.mileage.di.dbModule
import com.example.roadstats.data.settings.themePreferenceModule
import com.example.roadstats.data.speedomether.di.speedometerModule
import com.example.roadstats.di.dataModule
import com.example.roadstats.domain.settings.SettingsInteractor
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    private val settingsInteractor: SettingsInteractor by inject()
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(dataModule, speedometerModule, themePreferenceModule, dbModule)
        }
        settingsInteractor.setTheme(settingsInteractor.getTheme())
    }
}
