package com.ams.currencyconverter.common.data.rest.configs

import retrofit2.CallAdapter
import retrofit2.Converter

class RetrofitAdapters(val rxAdapterFactory: CallAdapter.Factory, val jsonConverterFactory: Converter.Factory)