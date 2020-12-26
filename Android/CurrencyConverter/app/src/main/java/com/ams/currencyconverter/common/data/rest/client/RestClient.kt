package com.ams.currencyconverter.common.data.rest.client

import com.ams.androiddevkit.baseClasses.networking.RetrofitClient
import com.ams.currencyconverter.BuildConfig
import com.ams.currencyconverter.common.Constants.BASE_CURRENCY
import com.ams.currencyconverter.common.data.rest.configs.RestConfigs
import okhttp3.Interceptor

class RestClient(private val restConfigs: RestConfigs): RetrofitClient() {

    override fun getBaseURL() = BuildConfig.BASE_URL

    override fun getConverterFactory() = restConfigs.getJsonAdapterFactory()

    override fun getRxAdapterFactory() = restConfigs.getRxAdapterFactory()

    override fun getAdditionalInterceptors(): MutableList<Interceptor> {
        val networkConnectivityInterceptor = restConfigs.getNetworkConnectivityInterceptor()
        return mutableListOf(networkConnectivityInterceptor)
    }

    override fun getAdditionalQueryParams(): MutableMap<String, String> {
        return mutableMapOf("access_key" to BuildConfig.API_KEY, "base" to BASE_CURRENCY)
    }

    override fun isDebuggable() = BuildConfig.DEBUG
}