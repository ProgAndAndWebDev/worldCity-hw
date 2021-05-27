package com.example.worldcity_hw.ui

import android.os.Handler
import android.view.LayoutInflater
import com.example.worldcity_hw.R
import com.example.worldcity_hw.databinding.ActivityHomeBinding
import com.example.worldcity_hw.ui.fragments.HomeFragment
import com.example.worldcity_hw.util.LoadingDialog

@Suppress("DEPRECATION")
class HomeActivity : BaseActivity<ActivityHomeBinding>() {

    override val LOG_TAG: String
        get() = "Home_Activity"
    override val bindingInflater: (LayoutInflater) -> ActivityHomeBinding
            = ActivityHomeBinding::inflate

    override fun addCallbacks() {   }

    override fun setUp() {
        reloading()
        initSubView()
    }

    private fun reloading() {
        val loading = LoadingDialog(this)
        loading.startLoading()
        Handler().postDelayed({ loading.isDismiss() }, 3000)
    }
    private fun initSubView(){
          val homeFragment = HomeFragment()
          supportFragmentManager.beginTransaction()
                  .add(R.id.fragment_container,homeFragment)
                  .commit()
    }


}