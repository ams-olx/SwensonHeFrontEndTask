//
//  FixerAPIErrorDetails.swift
//  CurrencyConverter
//
//  Created by Ahmad Mahmoud on 14/12/2020.
//

struct FixerAPIErrorDetails: Decodable {
    let type: String
    let info: String
    let code: Int
}
