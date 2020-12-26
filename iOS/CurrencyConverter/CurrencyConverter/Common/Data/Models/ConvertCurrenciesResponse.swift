//
//  ConvertCurrenciesResponse.swift
//  CurrencyConverter
//
//  Created by Ahmad Mahmoud on 13/12/2020.
//

struct ConvertCurrenciesResponse: Decodable {
    let success: Bool
    var result: Float? = nil
    var error: FixerAPIErrorDetails? = nil
}
