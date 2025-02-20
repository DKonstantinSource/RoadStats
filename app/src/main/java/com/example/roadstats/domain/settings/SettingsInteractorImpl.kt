package com.example.roadstats.domain.settings

class SettingsInteractorImpl(private val settingsRepository: SettingsRepository) :
    SettingsInteractor {
    @Override
    override fun getTheme(): Boolean {
        return settingsRepository.getTheme()
    }

    @Override
    override fun setTheme(darkTheme: Boolean) {
        settingsRepository.setTheme(darkTheme)
    }
}