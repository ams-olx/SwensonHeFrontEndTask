package com.ams.currencyconverter.ui.views.common

import com.ams.currencyconverter.common.Constants
import com.ams.currencyconverter.common.exceptionsAndThrowables.APIError
import com.ams.currencyconverter.common.data.models.CountryInfo
import com.ams.currencyconverter.common.data.rest.apis.APIs
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

class Repo(private val apIs: APIs) {

    fun getCurrenciesRatesWithFlags(): Single<List<CountryInfo>> {
        val countries = mutableListOf<CountryInfo>()
        var countryInfo: CountryInfo
        val observable = Observable.combineLatest(getCurrenciesWithFlagsObservable(), getCurrenciesWithRatesObservable(), { listWithFlags, currenciesWithRatesMap ->
            currenciesWithRatesMap?.forEach { (key, value) ->
                countryInfo = CountryInfo(key, value)
                countryInfo.flag = listWithFlags.find { it.hasCurrencyWithSymbol(key) }?.flag
                countries.add(countryInfo)
            }
            countries.toList().sortedBy { it.currencyName }
        })
        return Single.fromObservable(observable)
    }

    fun convertCurrency(to: String, amount: Float): Single<Float> = apIs.convertCurrency(from = Constants.BASE_CURRENCY, to, amount).flatMap {
        if (!it.success) { Single.error(APIError(success = false, it.error!!)) } else Single.just(it.result)
    }

    private fun getCurrenciesWithFlagsObservable() = apIs.getCountriesFlags()

    private fun getCurrenciesWithRatesObservable() = apIs.getCountriesCurrencies().flatMap {
        if (!it.success) { Observable.error(APIError(success = false, it.error!!)) } else Observable.just(it.rates)
    }
}