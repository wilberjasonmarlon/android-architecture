package com.carlyadam.arquitecture.data

import android.content.Context
import android.net.ConnectivityManager
import com.carlyadam.arquitecture.R
import com.carlyadam.arquitecture.data.model.DataInterceptor
import okhttp3.Interceptor
import okhttp3.Response

class NetworkConnectionInterceptor(
    context: Context
) : Interceptor {

    private val applicationContext = context.applicationContext

    override fun intercept(chain: Interceptor.Chain): Response {
        if (!checkConnection())
            DataInterceptor(
                connection = applicationContext.resources.getString(
                    R.string.no_connection
                )
            )
        return chain.proceed(chain.request())
    }

    private fun checkConnection(): Boolean {
        val connectivityManager =
            applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        connectivityManager.activeNetworkInfo.also {
            return it != null && it.isConnected
        }
    }

}