//
//  ConvertCurrencyViewController.swift
//  CurrencyConverter
//
//  Created by Ahmad Mahmoud on 15/12/2020.
//

import UIKit

class ConvertCurrencyViewController: AppViewController<ConvertCurrencyPresenter, ConvertCurrencyView>,
                                     ConvertCurrencyView,
                                     NumericKeyboardDelegate {

    @IBOutlet private weak var baseCurrencyLabel: UILabel!
    @IBOutlet private weak var targetCurrencyLabel: UILabel!
    @IBOutlet private weak var targetCurrencyValueLabel: UILabel!
    @IBOutlet private weak var baseCurrencyValueLabel: UITextField!
    @IBOutlet private weak var emptyView: UIView!
    //
    private var countryInfo: CountryInfo!
    
    convenience init(countryInfo: CountryInfo) {
        self.init()
        self.countryInfo = countryInfo
    }
    
    open override func initPresenter () -> ConvertCurrencyPresenter? {
        return resolver.optional(arguments: self, countryInfo!)
    }
    
    override func initUI() {
        self.emptyView.backgroundColor = UIColor.blueColor
        self.baseCurrencyLabel.text = Constants.baseCurrency
        self.targetCurrencyLabel.text = countryInfo.currencyName
        self.targetCurrencyValueLabel.text = "0.0"
        // Remove top bar from keyboard
        self.baseCurrencyValueLabel.inputAccessoryView = UIView()
        self.baseCurrencyValueLabel.placeholder = "write_down_you_amount".localized()
        self.baseCurrencyValueLabel.inputView = NumericKeyboard(target: baseCurrencyValueLabel, delegate: self)
    }
    
    func didGetConvertedValue(value: String) {
        self.targetCurrencyValueLabel.text = value
    }
    
    func didTapConvert() {
        self.getPresenter().convertCurrency(amount: self.baseCurrencyValueLabel.text)
    }
}
