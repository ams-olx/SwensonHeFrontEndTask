//
//  CountriesCurrenciesAPI.swift
//  CurrencyConverter
//
//  Created by Ahmad Mahmoud on 14/12/2020.
//

import iOS_Bootstrap

class CountriesCurrenciesAPI: AppAPI {
    var route: Route { return .get(Endpoints.currencies) }
}
