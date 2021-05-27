package com.example.worldcity_hw.util

import com.example.worldcity_hw.data.model.CityData


class CsvParserCity {

    fun parse(line: String): CityData {
       val tokens =  line.split(",")
       return CityData(
               id =tokens[Constants.ColumnIndex.ID].toInt() ,
               cityName =tokens[Constants.ColumnIndex.CITY],
               latitude =tokens[Constants.ColumnIndex.LATITUDE].toDouble(),
               longitude =tokens[Constants.ColumnIndex.LONGITUDE].toDouble(),
               ios2 = tokens[Constants.ColumnIndex.IOS2],
               ios3 =tokens[Constants.ColumnIndex.IOS3],
               countryName =tokens[Constants.ColumnIndex.COUNTRY],
               population =  tokens[Constants.ColumnIndex.POPULATION].toIntOrNull()
       )
    }

}