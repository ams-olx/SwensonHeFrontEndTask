//
//  CurrenciesResponse.swift
//  CurrencyConverter
//
//  Created by Ahmad Mahmoud on 14/12/2020.
//

struct CurrenciesResponse: Decodable {
    let success: Bool
    var error: FixerAPIErrorDetails?
    var base: String?
    var date: String?
    var rates: [String : Float]?
}

