package com.ams.currencyconverter.common.di.modules

import com.ams.currencyconverter.ui.views.covertCurrencyFragment.ConvertCurrencyFragment
import com.ams.currencyconverter.ui.views.currenciesListingFragment.CurrenciesListingFragment
import com.ams.currencyconverter.ui.views.splashFragment.SplashFragment
import org.koin.androidx.fragment.dsl.fragment
import org.koin.core.module.Module
import org.koin.dsl.module

val fragmentModules: Module = module {
    fragment { SplashFragment() }
    fragment { CurrenciesListingFragment() }
    fragment { ConvertCurrencyFragment() }
}