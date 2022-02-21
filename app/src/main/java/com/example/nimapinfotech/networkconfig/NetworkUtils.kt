package com.example.nimapinfotech.networkconfig

import android.content.Context
import android.net.ConnectivityManager
import android.os.Build
import android.util.Log
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.content.ContextCompat.getSystemService







class NetworkUtils {
    companion object{
        fun checkInternetConnection(context: Context): Boolean {
            val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager?
            // test for connection
            return if (cm!!.activeNetworkInfo != null && cm.activeNetworkInfo!!.isAvailable
                && cm.activeNetworkInfo!!.isConnected
            ) {
                true
            } else {
                Log.v("Internet Connectivity", "Internet Connection Not Present")
                false
            }
        }
    }
}