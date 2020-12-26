//
//  CountryInfo.swift
//  CurrencyConverter
//
//  Created by Ahmad Mahmoud on 13/12/2020.
//

struct CountryInfo: Decodable, Equatable {
    let currencyName: String
    let currencyRate: Float
    var flag: String? = nil
}
