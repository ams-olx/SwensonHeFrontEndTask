//
//  APIError.swift
//  CurrencyConverter
//
//  Created by Ahmad Mahmoud on 14/12/2020.
//

struct APIError: Error {
    
    let success: Bool
    let error: FixerAPIErrorDetails
    
    init(success: Bool, error: FixerAPIErrorDetails) {
        self.success = success
        self.error = error
    }
    
    func getErrorCode() -> Int {
        return error.code
    }

    func getErrorMessage() -> String {
        return error.info
    }
}
