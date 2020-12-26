package com.ams.currencyconverter.ui.views.fragmentHostActivity

import com.ams.currencyconverter.common.baseClasses.mvvm.AppViewModel
import com.ams.currencyconverter.common.data.models.CountryInfo

class SharedViewModel: AppViewModel() {

    private lateinit var countryInfo: CountryInfo

    fun renderCurrenciesListingView() {
        this.viewStateController.postRenderingState(FragmentHostActivityActions.RENDER_CURRENCIES_LISTING)
    }

    fun renderCurrencyConverterView(countryInfo: CountryInfo) {
        this.countryInfo = countryInfo
        this.viewStateController.postRenderingState(FragmentHostActivityActions.RENDER_CURRENCY_CONVERTER)
    }

    fun getChosenCurrencyInfo() = countryInfo
}