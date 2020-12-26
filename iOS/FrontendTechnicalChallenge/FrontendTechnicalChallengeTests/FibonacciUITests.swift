//
//  FibonacciUITests.swift
//  FrontendTechnicalChallengeUITests
//
//  Created by Ahmad Mahmoud on 11/12/2020.
//

import XCTest
@testable import FrontendTechnicalChallenge

class FibonacciUITests: XCTestCase {
    
    func testRecursiveMethod() {
        assert(try! Fibonacci.recursive(n: 0) == 0)
        assert(try! Fibonacci.recursive(n: 1) == 1)
        assert(try! Fibonacci.recursive(n: 9) == 34)
    }
    
    func testRecursiveMethodWithNegativeNumber() {
        XCTAssertThrowsError(try Fibonacci.recursive(n: -1), "Should have thrown IllegalArgumentException")
    }
    
    func testIterativeMethod() throws {
        assert(try! Fibonacci.iterative(n: 0) == 0)
        assert(try! Fibonacci.iterative(n: 1) == 1)
        assert(try! Fibonacci.iterative(n: 9) == 34)
    }
    
    func testIterativeMethodWithNegativeNumber() {
        XCTAssertThrowsError(try Fibonacci.iterative(n: -1), "Should have thrown IllegalArgumentException")
    }
    
    // Note: the measure function takes about 67 seconds to evaluate result with 50 as an input
    // And the time increases if th input increased
    func test_MeasurePerformance() {
        assert(measure(method: Fibonacci.recursive, n: 40) > measure(method: Fibonacci.iterative, n: 40))
    }
    
    private func measure(method: (_ n: Int64) throws -> Int64, n: Int64) -> Int64 {
        let start = Date()
        let result = try! method(n)
        let finish = Date()
        let timeElapsed = finish.timeIntervalSince(start).millisecond
        print("\nFibonacci($n) = \(result) Time elapsed: \(timeElapsed) ms")
        return Int64(timeElapsed)
    }
}
