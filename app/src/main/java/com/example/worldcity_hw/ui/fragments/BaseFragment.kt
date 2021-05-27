package com.example.worldcity_hw.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.worldcity_hw.Interface
import com.example.worldcity_hw.data.DataManger
import com.example.worldcity_hw.data.model.CityData
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.utils.ColorTemplate


@Suppress("UNCHECKED_CAST", "DEPRECATION")
abstract class BaseFragment <VB: ViewBinding>: Fragment() , Interface<VB> {

    abstract override val LOG_TAG : String
    private var _binding:ViewBinding? = null
    abstract override val bindingInflater: (LayoutInflater) -> VB

    override val binding
        get() =  _binding as VB?

    private lateinit var barDataChart: BarData
    private lateinit var barDataSetChart: BarDataSet
     protected lateinit var barListChart: ArrayList<BarEntry>
    protected lateinit var cityList: ArrayList<String>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding =  bindingInflater(layoutInflater)
        return binding!!.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setUp()
        addCallbacks()
    }


    abstract override fun addCallbacks()

    abstract override fun setUp()

    override fun log(value: Any){ Log.v(LOG_TAG,value.toString()) }

    abstract fun bindCity(city: CityData)

     protected fun dataChart(countryName: String , v:View) {
        cityList = ArrayList()
        barListChart = ArrayList()
         DataManger.getCurrentCountry(countryName)[countryName.toLowerCase()]!!.takeWhile { it.population != 0 }
                 .forEachIndexed { i , it ->
                    cityList.add(it.cityName)
                    barListChart.add(BarEntry(it.population?.toFloat() ?:0f, i))
                }
        initChart(v as BarChart)
    }

    private fun initChart(barChart: BarChart) {
         barDataSetChart = BarDataSet(barListChart, DataManger.getCurrentCity().countryName)
        barDataChart = BarData(cityList,barDataSetChart)
        barChart.data = barDataChart
        barDataSetChart.setColors(ColorTemplate.PASTEL_COLORS, 240)
        barDataSetChart.valueTextSize = 15f

        barChart.animateXY(2000,2000)
        barChart.setDescription("Cities Population")

        // define zoom settings
        barChart.setVisibleXRangeMaximum(2f)
    }
}