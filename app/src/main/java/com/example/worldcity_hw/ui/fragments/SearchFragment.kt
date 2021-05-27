package com.example.worldcity_hw.ui.fragments


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import com.example.worldcity_hw.data.DataManger
import com.example.worldcity_hw.data.model.CityData
import com.example.worldcity_hw.databinding.FragmentSearchBinding

class SearchFragment : BaseFragment<FragmentSearchBinding>(){
    override val LOG_TAG: String  = "SEARCH_FRAGMENT"
    override val bindingInflater: (LayoutInflater) -> FragmentSearchBinding
            = FragmentSearchBinding::inflate

    override fun addCallbacks() {
          binding!!.apply {
              btnSearch.setOnClickListener{
                  bindCity(DataManger.getSearchCity("china")!![0])
              }
          }
    }

    override fun setUp() {}

        @SuppressLint("SetTextI18n")
        override fun bindCity(country: CityData) {
            binding!!.apply {
                textInfo.text =
                        "Id:- ${country.id} " +
                                "\nCounter Cities:- ${DataManger.counterCitiesInCountry} " +
                                " \nPopulation:- ${country.population.toString()}" +
                                "\nIos2:- ${country.ios2} \nIos3:-${country.ios3}"

                dataChart(country.countryName, binding!!.anyChartViewSearch)
                layoutChart.visibility = View.VISIBLE
            }
        }


}