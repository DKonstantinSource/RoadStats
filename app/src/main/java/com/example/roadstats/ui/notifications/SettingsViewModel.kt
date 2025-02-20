package com.example.roadstats.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.roadstats.domain.settings.SettingsInteractor

class SettingsViewModel(private val settingsInteractor: SettingsInteractor) : ViewModel() {

    private val state = MutableLiveData<Boolean>()

    val themePreference: LiveData<Boolean> get() = state

    init {
        state.value = settingsInteractor.getTheme()
    }

    fun setTheme(isChecked: Boolean) {
        settingsInteractor.setTheme(isChecked)
        state.value = isChecked
    }
}