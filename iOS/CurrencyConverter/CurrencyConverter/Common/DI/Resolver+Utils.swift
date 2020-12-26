//
//  Resolver+Utils.swift
//  CurrencyConverter
//
//  Created by Ahmad Mahmoud on 13/12/2020.
//

import RxSwift
import Resolver
import Alamofire
import iOS_Bootstrap

extension Resolver {
    
    static func getRxAPI<T: Decodable, API: AlamofireAPI>(api: API) -> Single<T> {
        return resolve(RxAlamofireClientProtocol.self).request(api: api)
    }
    
    static func getRxAPI<API: AlamofireAPI>(api: API) -> Single<Any> {
        return resolve(RxAlamofireClientProtocol.self).request(api: api)
    }
    
    static func getDataRxAPI<API: AlamofireAPI>(api: API) -> Single<Data> {
        return resolve(RxAlamofireClientProtocol.self).requesData(api: api)
    }
    
    static func getRxAPI<API: AlamofireAPI>(api: API) -> Completable {
        let restClient = Resolver.resolve(RxAlamofireClientProtocol.self)
        return restClient.request(api: api)
    }
}
