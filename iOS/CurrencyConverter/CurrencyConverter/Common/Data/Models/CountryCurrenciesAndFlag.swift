//
//  CountryCurrenciesAndFlag.swift
//  CurrencyConverter
//
//  Created by Ahmad Mahmoud on 14/12/2020.
//

struct CountryCurrenciesAndFlag: Decodable {
    
    let flag: String
    var currencies: [Currency] = []
    
    func hasCurrencyWithSymbol(symbol: String) -> Bool {
        return currencies.firstIndex(where: { $0.code == symbol }) != nil
    }
}
