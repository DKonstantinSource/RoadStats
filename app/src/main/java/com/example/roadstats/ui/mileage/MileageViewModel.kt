package com.example.roadstats.ui.mileage

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.roadstats.domain.mileage.GetMileageUseCase
import com.example.roadstats.ui.mileage.modelUi.MileageUiModel
import kotlinx.coroutines.flow.map

class MileageViewModel(
    getMileageUseCase: GetMileageUseCase,
) : ViewModel() {

    val allMileage: LiveData<List<MileageUiModel>> = getMileageUseCase()
        .map { list ->
            list.map { mileage ->
                MileageUiModel(
                    date = mileage.date,
                    distance = "${mileage.distance} км"
                )
            }
        }.asLiveData()

}
