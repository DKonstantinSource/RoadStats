package com.example.roadstats.ui.speedometer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roadstats.domain.speedomether.SpeedometerUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

class SpeedometerViewModel(private val speedometerUseCase: SpeedometerUseCase) : ViewModel() {


    private val _speed = MutableLiveData<Int>()
    val speed: LiveData<Int> get() = _speed

    private val _mileage = MutableLiveData<Float>()
    val mileage: LiveData<Float> get() = _mileage

    fun startSpeedTracking() {
        viewModelScope.launch {
            while (true) {
                val currentSpeed = speedometerUseCase.getCurrentSpeed()
                _speed.postValue(currentSpeed.roundToInt())
                delay(850)
            }
        }
    }
}