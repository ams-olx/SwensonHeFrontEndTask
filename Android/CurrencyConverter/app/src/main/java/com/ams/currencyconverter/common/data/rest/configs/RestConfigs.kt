package com.ams.currencyconverter.common.data.rest.configs

import com.ams.currencyconverter.common.data.rest.interceptors.NetworkConnectivityInterceptor

class RestConfigs(private val networkConnectivityInterceptor: NetworkConnectivityInterceptor,
                  private val retrofitAdapters: RetrofitAdapters
) {

    fun getNetworkConnectivityInterceptor() = networkConnectivityInterceptor

    fun getRxAdapterFactory() = retrofitAdapters.rxAdapterFactory

    fun getJsonAdapterFactory() = retrofitAdapters.jsonConverterFactory
}