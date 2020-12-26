//
//  AppPresenter.swift
//  CurrencyConverter
//
//  Created by Ahmad Mahmoud on 13/12/2020.
//


import Resolver
import iOS_Bootstrap

class AppPresenter<V>: BasePresenter<V> {
    
    func postError(errorMessage: String) {
        if let viewDelegate = self.getViewDelegate() as? AppViewDelegate {
            viewDelegate.hideLoading()
            viewDelegate.didGetError(errorMessage: errorMessage)
        }
    }
}
