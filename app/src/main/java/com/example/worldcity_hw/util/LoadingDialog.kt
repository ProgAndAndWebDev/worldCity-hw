package com.example.worldcity_hw.util

import android.app.Activity
import android.app.AlertDialog
import com.example.worldcity_hw.R

class LoadingDialog(private val mActivity: Activity) {

    private lateinit var isdialog: AlertDialog
    fun startLoading() {
        /**set View*/
        val infalter = mActivity.layoutInflater
        val dialogView = infalter.inflate(R.layout.loading_item, null)
        AlertDialog.Builder(mActivity).apply {
            setView(dialogView)
            setCancelable(false)
            isdialog = create()
        }
        isdialog.show()
    }

    fun isDismiss() {
        isdialog.dismiss()
    }

}