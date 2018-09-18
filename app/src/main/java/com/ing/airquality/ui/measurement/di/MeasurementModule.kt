package com.ing.airquality.ui.measurement.di

import com.ing.airquality.domain.interactor.GetNearestMeasurement
import com.ing.airquality.ui.measurement.MeasurementViewModel
import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import java.text.SimpleDateFormat
import java.util.*

@Module
class MeasurementModule {
    @Provides
    fun airQualityViewModel(getNearestMeasurement: GetNearestMeasurement): MeasurementViewModel {
        return MeasurementViewModel(getNearestMeasurement)
    }

    @Provides
    fun providePicasso(): Picasso = Picasso.get()

    @Provides
    fun dateFormat(): SimpleDateFormat = SimpleDateFormat("dd/MM/yyyy HH:mm", Locale.getDefault())
}