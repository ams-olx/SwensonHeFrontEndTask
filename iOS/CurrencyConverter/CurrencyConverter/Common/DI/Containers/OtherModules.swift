//
//  OtherModules.swift
//  CurrencyConverter
//
//  Created by Ahmad Mahmoud on 13/12/2020.
//

import Resolver

extension Resolver {
    static func otherModules() {
        register { Dialogs() }
        register { Navigator() }.scope(application)
        register { SVGImageLoader() }.scope(application)
        register { NSCache<NSString, UIImage>() }.scope(application)
    }
}
