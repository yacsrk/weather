package com.ing.airquality.domain.interactor

import com.ing.airquality.domain.model.Measurement
import com.ing.airquality.domain.repository.AirQualityRepository
import io.reactivex.Single

class GetNearestMeasurement(
        private val repository: AirQualityRepository,
        private val schedulers: Schedulers
) {

    fun build(): Single<Measurement> = repository.nearestAirQuality()
            .subscribeOn(schedulers.io())
            .observeOn(schedulers.ui())

}