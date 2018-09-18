package com.ing.airquality.ui.measurement.di

import com.ing.airquality.ui.measurement.MeasurementFragment
import com.ing.airquality.ui.measurement.MeasurementViewModel
import dagger.Subcomponent

@Subcomponent(modules = [MeasurementModule::class])
interface MeasurementComponent {

    fun inject(measurementFragment: MeasurementFragment)
    fun viewModel(): MeasurementViewModel

    @Subcomponent.Builder
    interface Builder {
        fun build(): MeasurementComponent
    }
}