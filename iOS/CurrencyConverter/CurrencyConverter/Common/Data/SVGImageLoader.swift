//
//  SVGImageLoader.swift
//  CurrencyConverter
//
//  Created by Ahmad Mahmoud on 14/12/2020.
//

import RxSwift
import iOS_Bootstrap
import SVGKit
import Resolver

public final class SVGImageLoader: Resolving {
    
    public func loadFrom(svgImageURL: String) -> Single<UIImage?> {
        let imageCache: NSCache<NSString, UIImage> = resolver.resolve()
        return Single.create { single in
            let url = URL(string: svgImageURL)
            let nsStringURL = (url?.absoluteString)! as NSString
            if let cachedImage = imageCache.object(forKey: nsStringURL) {
                single(.success(cachedImage))
            }
            else {
                let svgImage: SVGKImage = SVGKImage(contentsOf: url)
                let image: UIImage = svgImage.uiImage
                imageCache.setObject(image, forKey: nsStringURL)
                single(.success(image))
            }
            return Disposables.create()
        }
        .subscribe(on: RxSchedulers.imageLoading)
        .observe(on: RxSchedulers.main)
    }
}
