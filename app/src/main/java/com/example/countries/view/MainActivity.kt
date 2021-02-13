package com.example.countries.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.countries.R
import com.example.countries.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: ListViewModel
    private val countryListAdapter = CountryListAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(ListViewModel::class.java)
        viewModel.refresh()
        countriesList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = countryListAdapter
        }

        swipe_refreshlayout.setOnRefreshListener {
            swipe_refreshlayout.isRefreshing =false
            viewModel.refresh()
        }

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.countries.observe(this, Observer { countriesLists ->
            countriesLists?.let {
                countriesList.visibility = View.VISIBLE
                countryListAdapter.updateCountries(it)
                loading_view.visibility = View.GONE
                list_error.visibility = View.GONE
            }


        })

        viewModel.countryLoadError.observe(this, Observer { isError ->
            isError?.let {
                list_error.visibility =
                    if(it)
                        View.VISIBLE
                    else
                        View.GONE

                loading_view.visibility = View.GONE
            }
        })

        viewModel.loading.observe(this, Observer { isLoading ->
            isLoading?.let {
                loading_view.visibility
                if(it)
                     View.VISIBLE
                else
                     View.GONE

            }
        })
    }
}