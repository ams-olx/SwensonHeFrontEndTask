//
//  RepositoriesModules.swift
//  CurrencyConverter
//
//  Created by Ahmad Mahmoud on 13/12/2020.
//

import Resolver

extension Resolver {
    static func repositoriesModules() {
        register { CurrenciesListingRepo(flagsAPI: resolve(), currenciesAPI: resolve()) }.scope(application)
    }
}
