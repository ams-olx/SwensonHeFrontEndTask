//
//  CurrenciesListingTableAdapter.swift
//  CurrencyConverter
//
//  Created by Ahmad Mahmoud on 13/12/2020.
//

import iOS_Bootstrap

class CurrenciesListingTableAdapter: BaseTableViewAdapter<UITableView, CountryInfo> {
    
    private var currenciesListingTableDelegate: CurrenciesListingTableDelegate!
    
    convenience init(tableView: UITableView,
                     currenciesListingTableDelegate: CurrenciesListingTableDelegate) {
        self.init(tableView: tableView, xibCell: CurrencyTableViewCell.self)
        self.currenciesListingTableDelegate = currenciesListingTableDelegate
    }
    
    override func tableView(_ tableView: UITableView,
                            cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        return initCell(cell: CurrencyTableViewCell.self, indexPath: indexPath)
    }
    
    override func tableView(_ tableView: UITableView, heightForRowAt indexPath: IndexPath) -> CGFloat {
        return 75
    }
    
    override func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
        currenciesListingTableDelegate.didSelect(countryInfo: dataSource[indexPath.row])
    }
}
