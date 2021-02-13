package com.example.countries.di

import com.example.countries.model.CountriesAPI
import com.example.countries.model.CountriesService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class ApiModule {

    private val base_url = "https://raw.githubusercontent.com/"

    @Provides
    fun provideCountriesAPI() : CountriesAPI
    {
       return  Retrofit.Builder()
            .baseUrl(base_url)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(CountriesAPI::class.java)
    }

    @Provides
    fun provideCountriesService() : CountriesService
    {
      return  CountriesService()
    }
}