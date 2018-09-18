package com.ing.airquality.data.api

import com.ing.airquality.data.api.model.AirQualityResponse
import com.ing.airquality.data.api.model.Response
import io.reactivex.Single
import retrofit2.http.GET

interface AirVisualApi {

    @GET("/v2/nearest_city?key=$API_KEY")
    fun airQuality(): Single<Response<AirQualityResponse>>

    companion object {
        private const val API_KEY = "ZW5XXe9CcTrDQnQZG"
        const val BASE_URL = "https://api.airvisual.com"
    }
}