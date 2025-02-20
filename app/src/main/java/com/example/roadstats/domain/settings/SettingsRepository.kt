package com.example.roadstats.domain.settings

interface SettingsRepository {
    fun getTheme(): Boolean
    fun setTheme(darkTheme: Boolean)
}