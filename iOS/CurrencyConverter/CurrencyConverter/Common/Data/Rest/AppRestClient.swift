//
//  AppRestClient.swift
//  CurrencyConverter
//
//  Created by Ahmad Mahmoud on 13/12/2020.
//

import RxSwift
import iOS_Bootstrap

class AppRestClient: RxAlamofireRestClient {
    
    override func getBaseURL() -> String {
        return "http://data.fixer.io/api/"
    }
    
    override func getAdditionalRequestIntercepters() -> [RequestIntercepterProtocol] {
        return [BaseURLChanger(), AdditionalQueryParams()]
    }
    
    override func shouldEnableLoadingIndicator() -> Bool {
        return false
    }
}
