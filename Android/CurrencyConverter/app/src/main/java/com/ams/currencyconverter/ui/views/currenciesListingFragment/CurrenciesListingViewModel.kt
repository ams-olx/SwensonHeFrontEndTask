package com.ams.currencyconverter.ui.views.currenciesListingFragment

import androidx.lifecycle.LifecycleOwner
import com.ams.currencyconverter.common.baseClasses.mvvm.AppViewModel
import com.ams.currencyconverter.common.data.models.CountryInfo
import com.ams.currencyconverter.ui.views.common.Repo

class CurrenciesListingViewModel(private val repo: Repo): AppViewModel() {

    private lateinit var listOfCountriesWithInfo: List<CountryInfo>

    override fun onResume(owner: LifecycleOwner) {
        super.onResume(owner)
        if(::listOfCountriesWithInfo.isInitialized) {
            this.viewStateController.postResult(listOfCountriesWithInfo)
        }
        else {
            this.requestExecuter.execute(repo.getCurrenciesRatesWithFlags().doOnSuccess {
                listOfCountriesWithInfo = it
            })
        }
    }
}