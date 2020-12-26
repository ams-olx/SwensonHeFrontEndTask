//
//  UIImageViewExtensions.swift
//  CurrencyConverter
//
//  Created by Ahmad Mahmoud on 14/12/2020.
//

import UIKit
import RxSwift
import Resolver

extension UIImageView: Resolving {
    func loadSVGfrom(url: String?) {
        // The third condition to overcome this issue
        // https://github.com/SVGKit/SVGKit/issues/582
        if(url != nil && url?.contains(".svg") == true && url?.contains("shn.svg") == false) {
            let svgImageLoader: SVGImageLoader = resolver.resolve()
            _ = svgImageLoader.loadFrom(svgImageURL: url!)
                .do(onSuccess: { img in self.image = img },
                    onError: { error in self.image = #imageLiteral(resourceName: "image_not_found") },
                    onSubscribe: {}, onSubscribed: {}, onDispose: {})
                .applyThreadingConfig()
                .subscribe()
        }
        else {
            self.image = #imageLiteral(resourceName: "image_place_holder")
        }
    }
}
