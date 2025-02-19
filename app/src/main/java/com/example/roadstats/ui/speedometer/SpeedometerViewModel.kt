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

    private var totalMileage: Float = 0f

    fun startSpeedTracking() {
        viewModelScope.launch {
            while (true) {
                val currentSpeed = speedometerUseCase.getCurrentSpeed().roundToInt()
                _speed.postValue(currentSpeed)
                val distance = currentSpeed * (850f / 3_600_000f)
                totalMileage += distance

                _mileage.postValue(totalMileage.roundToOneDecimal())

                delay(850)
            }
        }
    }

    private fun Float.roundToOneDecimal(): Float = (this * 10).roundToInt() / 10f
}