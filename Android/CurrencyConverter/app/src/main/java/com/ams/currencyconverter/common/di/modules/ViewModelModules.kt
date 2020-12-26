package com.ams.currencyconverter.common.di.modules

import com.ams.currencyconverter.ui.views.covertCurrencyFragment.ConvertCurrencyViewModel
import com.ams.currencyconverter.ui.views.fragmentHostActivity.SharedViewModel
import com.ams.currencyconverter.ui.views.currenciesListingFragment.CurrenciesListingViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val viewModelModules: Module = module {
    viewModel { SharedViewModel() }
    viewModel { CurrenciesListingViewModel(repo = get()) }
    viewModel { ConvertCurrencyViewModel(repo = get()) }
}