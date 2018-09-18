package com.ing.airquality.di

import com.ing.airquality.data.api.AirVisualApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ApplicationModule {

    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()
            .baseUrl(AirVisualApi.BASE_URL)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    fun provideAirVisualApi(retrofit: Retrofit): AirVisualApi = retrofit.create(AirVisualApi::class.java)

}