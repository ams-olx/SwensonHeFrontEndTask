//
//  WorldCountriesAPI.swift
//  CurrencyConverter
//
//  Created by Ahmad Mahmoud on 13/12/2020.
//

import iOS_Bootstrap

class WorldCountriesAPI: AppAPI {
    var route: Route { return .get(Endpoints.flags) }
}
