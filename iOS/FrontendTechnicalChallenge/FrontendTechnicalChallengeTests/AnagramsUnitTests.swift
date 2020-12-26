//
//  AnagramsUnitTests.swift.swift
//  FrontendTechnicalChallengeTests
//
//  Created by Ahmad Mahmoud on 10/12/2020.
//

import XCTest
@testable import FrontendTechnicalChallenge

class AnagramsUnitTests: XCTestCase {
    
    func testListOfWordsAreTrue() {
        ["bad\n  credit", "bad credit", "bed car it d"].forEach({ string in
            assert("debit card".isAnagramOf(string: string))
        })
       }

    func testSingleWordIsTrue() {
        assert("nine thumps".isAnagramOf(string: "punishment"))
    }

    func testSingleWordIsFalse() {
        // punishment has extra S char.
        assert(!"nine thumps".isAnagramOf(string: "punishments"))
    }
}
