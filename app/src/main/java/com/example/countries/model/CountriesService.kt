package com.example.countries.model

import com.example.countries.Country
import com.example.countries.di.DaggerApiComponent
import io.reactivex.Single
import javax.inject.Inject

class CountriesService {

    @Inject
    lateinit var api : CountriesAPI

    init {
        DaggerApiComponent.create().inject(this)
    }

    fun getCountries() : Single<List<Country>> {

        return api.getCountries();
    }

}