package com.example.worldcity_hw.data

import com.example.worldcity_hw.data.model.CityData

object DataManger {
    private val cityList = mutableListOf<CityData>()
    private var cityIndex = 0
    var counterCitiesInCountry = 0

    fun addCity(city: CityData) { cityList.add(city) }

    fun getCurrentCountry(country:String): Map<String, MutableList<CityData>>  = cityList.let {
            var listOfObjCity =  mutableListOf<CityData>()
            it.forEach { it.takeIf { it.countryName == country }?.let { listOfObjCity.add(it) } }.also { counterCitiesInCountry=listOfObjCity.size }
            it.associateBy(keySelector = { country.toLowerCase()  }, valueTransform = { listOfObjCity }) }

    fun getCurrentCity() : CityData = cityList[cityIndex]

    fun getSearchCity(country: String): List<CityData> =
            cityList.filter { it.countryName.toLowerCase() == country }

    fun getNextCity(): CityData {
        cityIndex++
        if(cityIndex == cityList.size ){
            cityIndex = 0
        }
        return cityList[cityIndex]
    }
    fun getPreviuosCity(): CityData {
        cityIndex--
        if(cityIndex == -1){
            cityIndex = cityList.size-1
        }
        return cityList[cityIndex]
    }
}