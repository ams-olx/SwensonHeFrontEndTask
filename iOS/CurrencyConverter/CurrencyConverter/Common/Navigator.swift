//
//  Navigator.swift
//  CurrencyConverter
//
//  Created by Ahmad Mahmoud on 13/12/2020.
//

import UIKit

class Navigator {
        
    private lazy var window: UIWindow = {
        let appDelegate = UIApplication.shared.delegate as! AppDelegate
        return appDelegate.window!
    }()
    
    func startInitialViewController() {
        let mainViewController = CurrenciesListingViewController()
        UIView.transition(
            with: window,
            duration: 0.3,
            options: .transitionFlipFromLeft,
            animations: {
                self.window.rootViewController = mainViewController
                self.window.makeKeyAndVisible()
        }, completion: nil)
    }
    
    func openConvertCurrencyViewController(from viewController: UIViewController, countryInfo: CountryInfo)  {
        let destinationViewController = ConvertCurrencyViewController(countryInfo: countryInfo)
        viewController.present(destinationViewController, animated: true, completion: nil)
    }
}
