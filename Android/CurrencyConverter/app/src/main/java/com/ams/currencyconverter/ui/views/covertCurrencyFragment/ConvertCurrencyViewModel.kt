package com.ams.currencyconverter.ui.views.covertCurrencyFragment

import com.ams.currencyconverter.common.baseClasses.mvvm.AppViewModel
import com.ams.currencyconverter.common.exceptionsAndThrowables.APIError
import com.ams.currencyconverter.ui.views.common.Repo
import io.reactivex.rxjava3.core.Single

class ConvertCurrencyViewModel(private val repo: Repo): AppViewModel() {

    private var conversionRate: Float = 0F
    // This flag is used to force the conversion to be done locally instead of the API, if an error is caused by the API.
    // In this case, this variable is set to true to save network hits that will be done by future conversions attempts.
    private var forceLocalCalculation = false
    private lateinit var chosenCurrencySymbol: String

    fun setChosenCurrencyInfo(currency: String, conversionRate: Float) {
        this.chosenCurrencySymbol = currency
        this.conversionRate = conversionRate
    }

    fun convertCurrency(amount: String?) {
        amount?.let {
            if(it.isNotEmpty()) {
                if(it.toDouble() > 0) {
                    if(forceLocalCalculation) {
                        this.viewStateController.postResult(this.doLocalConversion(amount.toFloat()))
                    }
                    else {
                        val executable = repo.convertCurrency(chosenCurrencySymbol,  it.toFloat()).onErrorResumeNext { throwable ->
                            if (throwable is APIError) {
                                this.forceLocalCalculation = true
                                // To overcome the problem cased by the free account limitations.
                                // In this conversion will be done locally.
                                Single.just(this.doLocalConversion(amount.toFloat()))
                            }
                            else {
                                // If the error is not from the API, Then the error should be propagated to the UI.
                                Single.error(throwable)
                            }
                        }
                        this.requestExecuter.execute(executable)
                    }
                }
                else {
                    this.viewStateController.postResult(0F)
                }
            }
            else {
                this.viewStateController.postResult(0F)
            }
        } ?: run {
            this.viewStateController.postResult(0F)
        }
    }

    private fun doLocalConversion(amount: Float) = amount * conversionRate
}