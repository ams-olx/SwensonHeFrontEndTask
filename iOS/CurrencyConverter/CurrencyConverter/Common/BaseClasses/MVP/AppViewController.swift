//
//  AppViewController.swift
//  CurrencyConverter
//
//  Created by Ahmad Mahmoud on 13/12/2020.
//

import Resolver
import iOS_Bootstrap

class AppViewController<P, V>: BaseViewController<P, V>, Resolving where P: BasePresenter<V> {
    
    @LazyInjected var dialogs: Dialogs
    @LazyInjected var navigator: Navigator

    override func initUI() {}
    
    override func localizeStrings() {}
    
    override func viewWillAppear(_ animated: Bool) {
        super.viewWillAppear(animated)
    }
        
    func networkConnectionMonitoringEnabled() -> Bool { return true }
    
    override func didGetError(errorMessage: String) {
        showError(errorMessage: errorMessage)
    }
    
    override func didGetWarning(warningMessage: String) {
        showWarning(warningMessage: warningMessage)
    }
    
    override func showLoading() {
        dialogs.showLoading(viewController: self)
    }
    
    override func hideLoading() {
        dialogs.hideDialog()
    }
}
