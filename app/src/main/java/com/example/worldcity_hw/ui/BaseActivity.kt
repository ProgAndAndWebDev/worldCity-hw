package com.example.worldcity_hw.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding
import com.example.worldcity_hw.Interface


@Suppress("UNCHECKED_CAST")
abstract class BaseActivity< VB: ViewBinding> : AppCompatActivity()
    , Interface<VB> {

    abstract override val LOG_TAG : String

    private var _binding:ViewBinding? = null
    abstract override val bindingInflater: (LayoutInflater) -> VB
    override val binding
        get() =  _binding as VB?

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding =  bindingInflater(layoutInflater)
        setContentView(_binding!!.root)

        setUp()
        addCallbacks()
    }

    abstract override fun addCallbacks()

    abstract override fun setUp()

    override fun log(value: Any){
        Log.v(LOG_TAG,value.toString())
    }


}