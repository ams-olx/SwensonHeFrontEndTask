//
//  AdditionalQueryParams.swift
//  CurrencyConverter
//
//  Created by Ahmad Mahmoud on 14/12/2020.
//

import iOS_Bootstrap

class AdditionalQueryParams: RequestIntercepterProtocol {
    
    func getUpdatedURLRequest(_ urlRequest: URLRequest, for session: Session) -> URLRequest {
        let url = urlRequest.url
        var request = urlRequest
        if let urlString = url?.absoluteString {
            if (urlString.contains("fixer.io")) {
                var urlComponents = URLComponents(url: url!, resolvingAgainstBaseURL: false)
                let dict = ["access_key" : "9447e7d84ef9e86c0cbdbaaa7e2dde09", "base" : Constants.baseCurrency]
                let queryItems = dict.map { return URLQueryItem(name: "\($0)", value: "\($1)") }
                urlComponents?.queryItems = queryItems
                request.url = urlComponents?.url
            }
        }
        return request
    }
}
