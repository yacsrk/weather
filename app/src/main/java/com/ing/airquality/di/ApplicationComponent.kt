package com.ing.airquality.di

import com.ing.airquality.ui.measurement.di.MeasurementComponent
import dagger.Component

@Component(modules = [ApplicationModule::class, BindingModule::class])
interface ApplicationComponent {
    fun airQualityComponent(): MeasurementComponent.Builder
}