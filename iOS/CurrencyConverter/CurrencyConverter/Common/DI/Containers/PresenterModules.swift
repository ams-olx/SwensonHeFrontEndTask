//
//  PresenterModules.swift
//  CurrencyConverter
//
//  Created by Ahmad Mahmoud on 13/12/2020.
//

import Resolver

extension Resolver {
    static func presenterModules() {
        register { (resolver, args) -> CurrenciesListingPresenter in
            let viewDelegate: CurrenciesListingView = resolver.arg(from: args!)!
            return CurrenciesListingPresenter(viewDelegate: viewDelegate, currenciesListingRepo: resolve())
        }
        register { (resolver, args) -> ConvertCurrencyPresenter in
            let viewDelegate: ConvertCurrencyView = resolver.arg0(from: args!)!
            let countryInfo: CountryInfo = resolver.arg1(from: args!)!
            return ConvertCurrencyPresenter(viewDelegate: viewDelegate, countryInfo: countryInfo, currenciesListingRepo: resolve())
        }
    }
}
