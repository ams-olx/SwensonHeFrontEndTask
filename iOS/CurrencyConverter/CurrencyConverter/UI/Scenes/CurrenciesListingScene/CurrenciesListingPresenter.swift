//
//  CurrenciesListingPresenter.swift
//  CurrencyConverter
//
//  Created by Ahmad Mahmoud on 13/12/2020.
//

import iOS_Bootstrap

class CurrenciesListingPresenter: AppPresenter<CurrenciesListingView> {
    
    private var currenciesListingRepo: CurrenciesListingRepo!
    
    required convenience init(viewDelegate: CurrenciesListingView, currenciesListingRepo: CurrenciesListingRepo) {
        self.init(viewDelegate: viewDelegate)
        self.currenciesListingRepo = currenciesListingRepo
    }
    
    override func viewControllerDidLoad() {
        self.fetchCurrenciesRatesWithFlags()
    }
    
    private func fetchCurrenciesRatesWithFlags() {
        self.getViewDelegate().showLoading()
        self.currenciesListingRepo
            .getCurrenciesRatesWithFlags()
            .applyThreadingConfig()
            .subscribe(onSuccess: { [weak self] currenciesRatesWithFlags in
                self?.getViewDelegate().didGet(currenciesRatesWithFlags: currenciesRatesWithFlags)
            }, onFailure: { [weak self] error in
                self?.postError(errorMessage: error.localizedDescription)
            })
            .disposed(by: disposeBag)
    }
}
