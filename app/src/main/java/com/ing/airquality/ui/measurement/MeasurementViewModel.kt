package com.ing.airquality.ui.measurement

import android.arch.lifecycle.ViewModel
import com.ing.airquality.domain.interactor.GetNearestMeasurement
import com.ing.airquality.ui.LiveDataDelegate
import io.reactivex.disposables.Disposable

class MeasurementViewModel(
        getNearestMeasurement: GetNearestMeasurement
) : ViewModel() {

    val measurementLiveData = LiveDataDelegate<LoadingState>(InitialState())
    private var airQuality by measurementLiveData
    private var disposable: Disposable? = null

    init {
        loadMeasurement(getNearestMeasurement)
    }

    private fun loadMeasurement(getNearestMeasurement: GetNearestMeasurement) {
        this.airQuality = Loading()
        disposable = getNearestMeasurement.build()
                .subscribe { airQuality, error ->
                    if (error == null) {
                        this.airQuality = Loaded(airQuality)
                    } else {
                        this.airQuality = Error(error)
                    }
                }
    }

    override fun onCleared() {
        super.onCleared()
        disposable?.dispose()
    }

}
