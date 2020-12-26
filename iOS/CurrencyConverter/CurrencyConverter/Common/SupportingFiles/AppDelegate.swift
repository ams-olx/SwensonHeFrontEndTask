//
//  AppDelegate.swift
//  CurrencyConverter
//
//  Created by Ahmad Mahmoud on 13/12/2020.
//

import UIKit
import Resolver
import iOS_Bootstrap

class AppDelegate: UIResponder, UIApplicationDelegate {

    var window: UIWindow?
    private var defaultConfigs: DefaultConfigurations?

    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?) -> Bool {
        self.window = UIWindow(frame: UIScreen.main.bounds)
        self.initEssentialAppConfigurations()
        self.startInitialViewController()
        return true
    }
    
    private func initEssentialAppConfigurations() {
        let navigationBarTextStyle = [NSAttributedString.Key(rawValue: NSAttributedString.Key.foregroundColor.rawValue): UIColor.white]
        defaultConfigs = DefaultConfigurations()
            .enableIQKeyboard()
            .iqKeyboardCanGoBack()
            .iqKeyboardCanGoNext()
            .setNavigationBarTextApperance(textApperance: navigationBarTextStyle)
            .setNavigationBarBackButtonColor(backButtonColor: UIColor.white)
    }
    
    private func startInitialViewController() {
        let navigator: Navigator = Resolver.resolve()
        navigator.startInitialViewController()
    }
}

