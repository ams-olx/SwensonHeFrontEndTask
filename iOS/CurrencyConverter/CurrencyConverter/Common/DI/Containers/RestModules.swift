//
//  RestModules.swift
//  CurrencyConverter
//
//  Created by Ahmad Mahmoud on 13/12/2020.
//

import RxSwift
import Resolver
import iOS_Bootstrap

extension Resolver {

    static func restClientModule() {
        register { (AppRestClient() as RxAlamofireClientProtocol) }.scope(application)
    }
    
    static func restAPIsModules() {
        register(Single<[CountryCurrenciesAndFlag]>.self) { getRxAPI(api: WorldCountriesAPI()) }
        register(Single<CurrenciesResponse>.self) { getRxAPI(api: CountriesCurrenciesAPI()) }
        register { (resolver, args) -> Single<ConvertCurrenciesResponse> in
            let from: String! = resolver.arg0(from: args!)
            let to: String! = resolver.arg1(from: args!)
            let amount: Float! = resolver.arg2(from: args!)
            return getRxAPI(api: ConvertCurrencyAPI(from: from, to: to, amount: amount))
        }
    }
}

