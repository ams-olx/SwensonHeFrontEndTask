package com.ams.currencyconverter.common.data.models

data class CurrenciesResponse(val success: Boolean,
                              val error: Map<String, Any>?,
                              val base: String?,
                              val date: String?,
                              val rates: Map<String, Float>?)

