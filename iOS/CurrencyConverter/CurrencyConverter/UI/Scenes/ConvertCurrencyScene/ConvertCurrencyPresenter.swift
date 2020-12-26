//
//  ConvertCurrencyPresenter.swift
//  CurrencyConverter
//
//  Created by Ahmad Mahmoud on 15/12/2020.
//

import RxSwift
import iOS_Bootstrap

class ConvertCurrencyPresenter: AppPresenter<ConvertCurrencyView> {
    
    private var countryInfo: CountryInfo!
    private var currenciesListingRepo: CurrenciesListingRepo!
    // This flag is used to force the conversion to be done locally instead of the API, if an error is caused by the API.
    // In this case, this variable is set to true to save network hits that will be done by future conversions attempts.
    private var forceLocalCalculation = false
    private var convertedValue: String!

    required convenience init(viewDelegate: ConvertCurrencyView,
                              countryInfo: CountryInfo,
                              currenciesListingRepo: CurrenciesListingRepo) {
        self.init(viewDelegate: viewDelegate)
        self.countryInfo = countryInfo
        self.currenciesListingRepo = currenciesListingRepo
    }
    
    func convertCurrency(amount: String?) {
        if let stringAmount = amount, !stringAmount.isEmpty , let floatAmount = Float(stringAmount) {
            if(floatAmount > 0) {
                if(forceLocalCalculation) {
                    self.convertedValue = String(self.doLocalConversion(amount: floatAmount))
                    self.getViewDelegate().didGetConvertedValue(value: self.convertedValue)
                }
                else {
                    self.currenciesListingRepo
                        .convertCurrency(to: countryInfo.currencyName, amount: floatAmount)
                        .catch({ error in
                            if (error as? APIError != nil) {
                                self.forceLocalCalculation = true
                                // To overcome the problem cased by the free account limitations.
                                // In this conversion will be done locally.
                                return Single.just(self.doLocalConversion(amount: floatAmount))
                            }
                            else {
                                // If the error is not from the API, Then the error should be propagated to the UI.
                                return Single.error(error)
                            }
                        })
                        .applyThreadingConfig()
                        .subscribe(onSuccess: { [weak self] result in
                            self?.getViewDelegate().didGetConvertedValue(value: String(result))
                        }, onFailure: { [weak self] error in
                            self?.postError(errorMessage: error.localizedDescription)
                        })
                        .disposed(by: disposeBag)
                }
            }
            else {
                self.getViewDelegate().didGetConvertedValue(value: String(0.0))
            }
        }
        else {
            self.getViewDelegate().didGetConvertedValue(value: String(0.0))
        }
    }

    private func doLocalConversion(amount: Float) -> Float {
        return amount * countryInfo.currencyRate
    }
}
