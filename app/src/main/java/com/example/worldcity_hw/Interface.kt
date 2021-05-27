package com.example.worldcity_hw

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

interface Interface< VB: ViewBinding>  {
     val LOG_TAG : String

    private var _binding: ViewBinding?
        get() = null
        set(value) { }
    val bindingInflater: (LayoutInflater) -> VB

    val binding
        get() =  _binding as VB?

    fun onCreate(savedInstanceState: Bundle?)

    fun addCallbacks()

    fun setUp()

    fun log(value: Any){
        Log.v(LOG_TAG,value.toString())
    }


}