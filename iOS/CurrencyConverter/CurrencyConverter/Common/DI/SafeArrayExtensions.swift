//
//  SafeArrayExtensions.swift
//  CurrencyConverter
//
//  Created by Ahmad Mahmoud on 13/12/2020.
//

extension Collection where Indices.Iterator.Element == Index {
    subscript (exist index: Index) -> Iterator.Element? {
        return indices.contains(index) ? self[index] : nil
    }
}
