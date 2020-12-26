//
//  StringExtensions.swift
//  FrontendTechnicalChallenge
//
//  Created by Ahmad Mahmoud on 10/12/2020.
//

import Foundation

extension String {
    func isAnagramOf(string: String) -> Bool {
        return String(self.sorted()).trimmingCharacters(in: .whitespacesAndNewlines) == String(string.sorted()).trimmingCharacters(in: .whitespacesAndNewlines)
    }
}
