//
//  AlamofireLoader.swift
//  CurrencyConverter
//
//  Created by Ahmad Mahmoud on 14/12/2020.
//

import iOS_Bootstrap

class AlamofireLoader: LoadingIndicatorService {
    
    func showLoader() {
        EZLoadingActivity.show("loading".localized(), disableUI: true)
    }
    
    func hideLoader() {
        EZLoadingActivity.hide()
    }
}
