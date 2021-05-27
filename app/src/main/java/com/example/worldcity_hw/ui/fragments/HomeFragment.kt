package com.example.worldcity_hw.ui.fragments


import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import com.example.worldcity_hw.R
import com.example.worldcity_hw.data.DataManger
import com.example.worldcity_hw.data.model.CityData
import com.example.worldcity_hw.databinding.FragmentHomeBinding
import com.example.worldcity_hw.util.CsvParserCity
import java.io.BufferedReader
import java.io.InputStreamReader


class HomeFragment : BaseFragment<FragmentHomeBinding>(){

    override val LOG_TAG: String  = "HOME_FRAGMENT"
    override val bindingInflater: (LayoutInflater) -> FragmentHomeBinding
            = FragmentHomeBinding::inflate

    val searchFragment = SearchFragment()

    override fun addCallbacks() {
        binding?.apply {
            iconSearch.setOnClickListener{ loadFragment(searchFragment) }

            iconNext.setOnClickListener{ bindCity(DataManger.getNextCity()) }
            iconPrevious.setOnClickListener{ bindCity(DataManger.getPreviuosCity()) }
        }
    }

    override fun setUp() { parseFile() }

    private fun loadFragment(fragment: Fragment) {
        (activity)!!.supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, fragment)
                .addToBackStack(null)
                .commit()
    }

    private fun parseFile(){
        val inputStream = (activity)!!.assets.open("worldcities.csv")
        val buffer = BufferedReader(InputStreamReader(inputStream))
        val parser = CsvParserCity()
        buffer.forEachLine {
            val currentCity = parser.parse((it))
            DataManger.addCity(currentCity)
        }
        bindCity(DataManger.getCurrentCity())
    }

    override fun bindCity(city: CityData){
        binding?.apply {
            textCountry.text = city.cityName
            textId.text = city.id.toString()
            textPopulation.text = city.population.toString()
            textIos2.text = city.ios2
            textIos3.text = city.ios3
        }

       dataChart(city.countryName, binding!!.anyChartViewHome)
    }




}

