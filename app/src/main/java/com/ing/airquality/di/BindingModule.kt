package com.ing.airquality.di

import com.ing.airquality.data.AirVisualAirQualityRepository
import com.ing.airquality.domain.interactor.Schedulers
import com.ing.airquality.domain.repository.AirQualityRepository
import com.ing.airquality.ui.InteractorSchedulers
import dagger.Binds
import dagger.Module

@Module
interface BindingModule {

    @Binds
    fun bindAirQualityRepository(repository: AirVisualAirQualityRepository): AirQualityRepository

    @Binds
    fun bindSchedulers(schedulers: InteractorSchedulers): Schedulers
}