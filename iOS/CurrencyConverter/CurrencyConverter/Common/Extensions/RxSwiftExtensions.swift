//
//  RxSwiftExtensions.swift
//  CurrencyConverter
//
//  Created by Ahmad Mahmoud on 13/12/2020.
//

import RxSwift
import iOS_Bootstrap

extension PrimitiveSequence {
    func applyThreadingConfig() -> PrimitiveSequence {
        return self
            .subscribe(on: RxSchedulers.backgroundConcurrentScheduler)
            .observe(on: RxSchedulers.main)
    }
}
