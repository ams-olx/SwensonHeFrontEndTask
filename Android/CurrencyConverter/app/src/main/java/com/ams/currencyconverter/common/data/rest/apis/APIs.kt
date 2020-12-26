package com.ams.currencyconverter.common.data.rest.apis

import com.ams.currencyconverter.common.data.rest.Endpoints
import com.ams.currencyconverter.common.data.models.ConvertCurrenciesResponse
import com.ams.currencyconverter.common.data.models.CountryCurrenciesAndFlag
import com.ams.currencyconverter.common.data.models.CurrenciesResponse
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface APIs {

    @GET(Endpoints.FLAGS)
    fun getCountriesFlags(): Observable<List<CountryCurrenciesAndFlag>>

    @GET(Endpoints.CURRENCIES)
    fun getCountriesCurrencies(): Observable<CurrenciesResponse>

    @GET(Endpoints.CONVERT)
    fun convertCurrency(@Query("from") from: String,
                        @Query("to") to: String,
                        @Query("amount") amount: Float): Single<ConvertCurrenciesResponse>
}