package com.example.countries.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.countries.Country
import com.example.countries.R
import kotlinx.android.synthetic.main.country_list_item.view.*

class CountryListAdapter(var countries: ArrayList<Country>) : RecyclerView.Adapter<CountryListAdapter.CountryViewHolder>() {

    fun updateCountries(newCountries : List<Country>)
    {
        countries.clear()
        countries.addAll(newCountries)
        notifyDataSetChanged()
    }

    class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val countryName = itemView.name
        private val countryFlag = itemView.countryflag
        private val capital = itemView.capital
        fun bind(country : Country)
        {
            countryName.text = country.countryname
            capital.text = country.capital

            Glide.with(itemView.context).load(country.flag).into(countryFlag)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CountryViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.country_list_item,parent,false)
    )

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.bind(countries.get(position))
    }

    override fun getItemCount(): Int {
        return countries.size
    }

}