package com.example.roadstats.ui.speedometer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.roadstats.domain.mileage.SaveMileageUseCase
import com.example.roadstats.domain.speedometer.SpeedometerUseCase
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

class SpeedometerViewModel(
    private val speedometerUseCase: SpeedometerUseCase,
    private val saveMileageUseCase: SaveMileageUseCase
) : ViewModel() {

    private val _speed = MutableLiveData<Int>()
    val speed: LiveData<Int> get() = _speed

    private val _mileage = MutableLiveData<Float>()
    val mileage: LiveData<Float> get() = _mileage

    private var totalMileage: Float = 0f
    private var isTracking = false

    fun startSpeedTracking() {
        if (isTracking) return
        isTracking = true

        viewModelScope.launch {
            while (isTracking) {
                val currentSpeed = speedometerUseCase.getCurrentSpeed().roundToInt()
                _speed.postValue(currentSpeed)

                if (currentSpeed >= 0.5) {
                    val distance = currentSpeed * (850f / 3_600_000f)
                    totalMileage += distance
                    _mileage.postValue(totalMileage.roundToOneDecimal())
                }

                delay(850)
            }
        }
    }

    fun saveDailyMileage() {
        viewModelScope.launch {
            try {
                if (totalMileage > 0) {
                    saveMileageUseCase(totalMileage)
                    totalMileage = 0f
                    _mileage.postValue(totalMileage)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun Float.roundToOneDecimal(): Float = (this * 10).roundToInt() / 10f
}
