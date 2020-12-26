//
//  AppDelegate+Injection.swift
//  CurrencyConverter
//
//  Created by Ahmad Mahmoud on 13/12/2020.
//

import Resolver

extension Resolver: ResolverRegistering {
    
    static func setResolverDefaultScope() {
        Resolver.defaultScope = Resolver.unique
    }
    
    public static func registerAllServices() {
        setResolverDefaultScope()
        presenterModules()
        restClientModule()
        restAPIsModules()
        repositoriesModules()
        otherModules()
    }
}
