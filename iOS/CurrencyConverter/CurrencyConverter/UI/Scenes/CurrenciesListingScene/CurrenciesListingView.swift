//
//  CurrenciesListingView.swift
//  CurrencyConverter
//
//  Created by Ahmad Mahmoud on 13/12/2020.
//

import iOS_Bootstrap

protocol CurrenciesListingView: AppViewDelegate {
    func didGet(currenciesRatesWithFlags: [CountryInfo])
}
