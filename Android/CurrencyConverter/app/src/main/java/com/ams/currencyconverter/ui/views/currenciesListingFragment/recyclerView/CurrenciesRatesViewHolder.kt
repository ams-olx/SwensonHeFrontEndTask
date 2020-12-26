package com.ams.currencyconverter.ui.views.currenciesListingFragment.recyclerView

import android.view.ViewGroup
import com.ams.androiddevkit.baseClasses.recyclerView.viewholder.BaseSimpleViewHolder
import com.ams.currencyconverter.R
import com.ams.currencyconverter.common.data.models.CountryInfo
import com.ams.currencyconverter.common.extensions.loadFrom
import kotlinx.android.synthetic.main.layout_currency_recycler_view_item.view.*

class CurrenciesRatesViewHolder(viewGroup: ViewGroup, private val clickAction: (item: CountryInfo) -> Unit): BaseSimpleViewHolder<CountryInfo>(viewGroup, R.layout.layout_currency_recycler_view_item) {

    override fun bind(item: CountryInfo, index: Int) {
        itemView.apply {
            flag_image_view.loadFrom(item.flag)
            country_symbol_text_view.text = item.currencyName
            currency_rate_text_view.text = item.currencyRate.toString()
        }.setOnClickListener { clickAction.invoke(item) }
    }
}