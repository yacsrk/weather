package com.ing.airquality.domain.model

import java.util.*

data class Measurement(
        val airQuality: Int?,
        val weatherIconUrl: String,
        val currentTemperature: Int,
        val city: String,
        val measurementDate: Date
)