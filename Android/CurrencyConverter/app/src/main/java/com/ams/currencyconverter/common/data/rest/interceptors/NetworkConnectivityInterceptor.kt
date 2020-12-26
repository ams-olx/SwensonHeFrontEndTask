package com.ams.currencyconverter.common.data.rest.interceptors

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import com.ams.androiddevkit.utils.di.ResourceProvider
import com.ams.currencyconverter.R
import com.ams.currencyconverter.common.exceptionsAndThrowables.NoInternetConnectionException
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class NetworkConnectivityInterceptor(private val context: Context,
                                     private val resourceProvider: ResourceProvider): Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        if (!isNetworkConnectionAvailable(context))
            throw NoInternetConnectionException(resourceProvider.getString(R.string.no_internet_connection))
        return chain.proceed(request)
    }

     private fun isNetworkConnectionAvailable(context: Context): Boolean {
        var result = false
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val capabilities =
                cm.getNetworkCapabilities(cm.activeNetwork)
            if (capabilities != null) {
                if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ||
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_VPN)) {
                    result = true
                }
            }
        }
        else {
            val activeNetwork = cm.activeNetworkInfo
            if (activeNetwork != null) {
                // Connected to the internet
                if (activeNetwork.type == ConnectivityManager.TYPE_WIFI ||
                    activeNetwork.type == ConnectivityManager.TYPE_MOBILE ||
                    activeNetwork.type == ConnectivityManager.TYPE_VPN) {
                    result = true
                }
            }
        }
        return result
    }
}