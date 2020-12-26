//
//  ConvertCurrencyAPI.swift
//  CurrencyConverter
//
//  Created by Ahmad Mahmoud on 14/12/2020.
//

import iOS_Bootstrap

class ConvertCurrencyAPI: AppAPI {
    
    private let from: String
    private let to: String
    private let amount: Float
    
    var route: Route { return .get(Endpoints.convert) }
    
    init(from: String, to: String, amount: Float) {
        self.from = from
        self.to = to
        self.amount = amount
    }
}
