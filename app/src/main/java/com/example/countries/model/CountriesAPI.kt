package com.example.countries.model

import com.example.countries.Country
import io.reactivex.Single
import retrofit2.http.GET

interface CountriesAPI {

    @GET("codehive-info/dummydata/main/countriesV2/countriesV2.json")
    fun getCountries() : Single<List<Country>>

}