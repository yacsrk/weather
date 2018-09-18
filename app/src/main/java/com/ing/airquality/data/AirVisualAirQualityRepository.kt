package com.ing.airquality.data

import com.ing.airquality.data.api.AirVisualApi
import com.ing.airquality.domain.model.Measurement
import com.ing.airquality.domain.repository.AirQualityRepository
import io.reactivex.Single

class AirVisualAirQualityRepository(
        private val airVisualApi: AirVisualApi
) : AirQualityRepository {

    override fun nearestAirQuality(): Single<Measurement> {
        return airVisualApi.airQuality().map {
            Measurement(
                    it.data.measurement.airQuality?.aqi ?: 0,
                    "https://airvisual.com/images/${it.data.measurement.weather.icon}.png",
                    it.data.measurement.weather.temperature,
                    it.data.city,
                    it.data.measurement.weather.timestamp
            )
        }
    }

}