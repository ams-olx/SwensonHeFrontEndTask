package com.ams.currencyconverter.common.data.models

data class CountryCurrenciesAndFlag(val flag: String?, val currencies: List<Currency>) {
    fun hasCurrencyWithSymbol(symbol: String): Boolean {
        return currencies.find { it.code == symbol }?.let { true } ?: false
    }
}

