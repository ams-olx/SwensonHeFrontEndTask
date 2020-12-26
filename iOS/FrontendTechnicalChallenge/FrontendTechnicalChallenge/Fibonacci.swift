//
//  Fibonacci.swift
//  FrontendTechnicalChallenge
//
//  Created by Ahmad Mahmoud on 11/12/2020.
//

import Foundation

struct Fibonacci {
    
    static func recursive(n: Int64) throws -> Int64 {
        if(n < 0) {
            throw Errors.IllegalArgumentException(message: "n value cannot be negative number")
        }
        else if (n < 2) {
            return n
        }
        else {
            return try! recursive(n: n - 1) + recursive(n: n - 2)
        }
    }
    
    static func iterative(n: Int64) throws -> Int64 {
        if(n < 0) {
            throw Errors.IllegalArgumentException(message: "n value cannot be negative number")
        }
        else if (n < 2) {
            return n
        }
        else {
            var minusOne: Int64 = 1
            var minusTwo: Int64 = 0
            var result: Int64 = Int64(minusOne)
            for _ in 2...n {
                result = minusOne + minusTwo
                minusTwo = minusOne
                minusOne = result
            }
            return result
        }
    }
}
