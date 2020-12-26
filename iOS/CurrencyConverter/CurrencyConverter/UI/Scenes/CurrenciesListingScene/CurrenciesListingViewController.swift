//
//  CurrenciesListingViewController.xib.swift
//  CurrencyConverter
//
//  Created by Ahmad Mahmoud on 13/12/2020.
//

import iOS_Bootstrap

class CurrenciesListingViewController: AppViewController<CurrenciesListingPresenter, CurrenciesListingView>,
                                       CurrenciesListingView,
                                       CurrenciesListingTableDelegate {
    
    @IBOutlet private weak var tableView: UITableView!
    @IBOutlet private weak var baseCurrencyFlagImageView: UIImageView!
    @IBOutlet private weak var baseCurrencyLabel: UILabel!
    //
    private lazy var tableViewAdapter = {
        CurrenciesListingTableAdapter(tableView: self.tableView, currenciesListingTableDelegate: self)
    }()
    
    override func initPresenter() -> CurrenciesListingPresenter {
        return resolver.resolve(args: self)
    }
    
    override func initUI() {
        self.view.backgroundColor = .blueColor
        self.baseCurrencyLabel.text = Constants.baseCurrency
    }
    
    func didGet(currenciesRatesWithFlags: [CountryInfo]) {
        self.tableViewAdapter.reloadSinglePageTable(items: currenciesRatesWithFlags)
    }
    
    func didSelect(countryInfo: CountryInfo) {
        self.navigator.openConvertCurrencyViewController(from: self, countryInfo: countryInfo)
    }
}
