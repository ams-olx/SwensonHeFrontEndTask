//
//  HomeListingRepo.swift
//  CurrencyConverter
//
//  Created by Ahmad Mahmoud on 13/12/2020.
//

import RxSwift
import Resolver

class CurrenciesListingRepo: Resolving {
    
    private let countriesFlagsAPI: Observable<[CountryCurrenciesAndFlag]>
    private let countriesCurrenciesAPI: Observable<CurrenciesResponse>
    private var api: Single<ConvertCurrenciesResponse>!
    
    init(flagsAPI: Single<[CountryCurrenciesAndFlag]>, currenciesAPI: Single<CurrenciesResponse>) {
        self.countriesFlagsAPI = flagsAPI.asObservable()
        self.countriesCurrenciesAPI = currenciesAPI.asObservable()
    }
    
    func getCurrenciesRatesWithFlags() -> Single<[CountryInfo]> {
        var countries = [CountryInfo]()
        var countryInfo: CountryInfo? = nil
        return Observable.combineLatest(countriesFlagsAPI, getCurrenciesWithRatesObservable()) { (listWithFlags, currenciesWithRatesMap) -> [CountryInfo] in
            currenciesWithRatesMap.forEach { (key, value) in
                countryInfo = CountryInfo(currencyName: key, currencyRate: value)
                countryInfo!.flag = listWithFlags.filter {$0.hasCurrencyWithSymbol(symbol: key) }.first?.flag
                countries.append(countryInfo!)
            }
            return countries.sorted { $0.currencyName < $1.currencyName }
        }.asSingle()
    }
    
    func convertCurrency(to: String, amount: Float) -> Single<Float> {
        let from = Constants.baseCurrency
        api = resolver.optional(arg0: from, arg1: to, arg2: amount)
        return api.flatMap { response in
            if (!response.success) {
                return Single.error(APIError(success: false, error: response.error!))
            }
            else {
                return Single.just(response.result!)
            }
        }
    }
    
    func getCurrenciesWithRatesObservable() -> Observable<[String : Float]> {
        return self.countriesCurrenciesAPI.asObservable().flatMap { result -> Observable<[String : Float]> in
            if (!result.success) {
                return Observable.error(APIError(success: false, error: result.error!))
            }
            else {
                return Observable.just(result.rates!)
            }
        }
    }
}
