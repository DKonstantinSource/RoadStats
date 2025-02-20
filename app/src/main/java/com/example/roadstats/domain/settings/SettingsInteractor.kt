package com.example.roadstats.domain.settings

interface SettingsInteractor {
    fun getTheme(): Boolean
    fun setTheme(darkTheme: Boolean)
}