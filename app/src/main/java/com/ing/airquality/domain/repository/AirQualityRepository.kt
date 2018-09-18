package com.ing.airquality.domain.repository

import com.ing.airquality.domain.model.Measurement
import io.reactivex.Single

interface AirQualityRepository {

    fun nearestAirQuality(): Single<Measurement>

}