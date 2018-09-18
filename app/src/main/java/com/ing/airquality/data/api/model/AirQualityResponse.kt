package com.ing.airquality.data.api.model

import com.google.gson.annotations.SerializedName
import java.util.*

data class Response<T>(
        val status: String,
        val data: T
)

data class AirQualityResponse(
        @SerializedName("city") val city: String,
        @SerializedName("state") val state: String,
        @SerializedName("country") val country: String,
        @SerializedName("location") val location: Location,
        @SerializedName("current") val measurement: Measurement
)

data class Location(
        @SerializedName("type") val type: String,
        @SerializedName("coordinates") val coordinates: List<Double>
)

data class Measurement(
        @SerializedName("weather") val weather: Weather,
        @SerializedName("pollution") val airQuality: AirQuality?
)

data class Weather(
        @SerializedName("ts") val timestamp: Date,
        @SerializedName("tp") val temperature: Int,
        @SerializedName("hu") val humidity: Int,
        @SerializedName("ic") val icon: String
)


data class AirQuality(
        @SerializedName("ts") val timestamp: Date,
        @SerializedName("aqius") val aqi: Int?,
        @SerializedName("tp") val temperature: Int,
        @SerializedName("tp_min") val temperatureMin: Int,
        @SerializedName("ic") val icon: String
)