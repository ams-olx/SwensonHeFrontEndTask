package com.ams.currencyconverter.common.data.models

data class ConvertCurrenciesResponse(val success: Boolean,
                                     val error: Map<String, Any>?,
                                     val result: Float?)