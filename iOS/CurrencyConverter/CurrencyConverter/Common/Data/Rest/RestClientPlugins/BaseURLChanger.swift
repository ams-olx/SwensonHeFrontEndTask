//
//  BaseURLChanger.swift
//  CurrencyConverter
//
//  Created by Ahmad Mahmoud on 14/12/2020.
//

import iOS_Bootstrap

class BaseURLChanger: RequestIntercepterProtocol {
    
    func getUpdatedURLRequest(_ urlRequest: URLRequest, for session: Session) -> URLRequest {
        let url = urlRequest.url
        var request = urlRequest
        if let urlString = url?.absoluteString {
            if (urlString.contains(Endpoints.flags)) {
                let newURL = "https://restcountries.eu/rest/v2/" + Endpoints.flags
                request.url = newURL.toURL()
            }
        }
        return request
    }
}


