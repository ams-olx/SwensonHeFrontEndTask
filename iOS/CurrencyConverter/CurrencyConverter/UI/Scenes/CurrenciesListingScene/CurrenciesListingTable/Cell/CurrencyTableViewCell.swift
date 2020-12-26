//
//  CurrencyTableViewCell.swift
//  CurrencyConverter
//
//  Created by Ahmad Mahmoud on 13/12/2020.
//

import iOS_Bootstrap

class CurrencyTableViewCell: BaseGenericTableViewCell<CountryInfo> {
    
    @IBOutlet private weak var flagImageView: UIImageView!
    @IBOutlet private weak var currencyNameLable: UILabel!
    @IBOutlet private weak var currencyRateLablel: UILabel!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        self.selectionStyle = .none
    }
    
    override func initCellFrom(cellModel: CountryInfo) {
        self.flagImageView.loadSVGfrom(url: cellModel.flag)
        self.currencyNameLable.text = cellModel.currencyName
        self.currencyRateLablel.text = String(cellModel.currencyRate)
    }
}
