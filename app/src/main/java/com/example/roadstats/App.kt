package com.example.roadstats

import android.app.Application
import com.example.roadstats.data.speedomether.di.speedometerModule
import com.example.roadstats.di.dataModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(dataModule, speedometerModule)
        }

    }
}
