package com.example.worldcity_hw.data.model

data class CityData(
        val id: Int,
        val cityName: String,
        val latitude: Double,
        val longitude: Double,
        val ios2: String,
        val ios3: String,
        val countryName: String,
        val population: Int?,
)
