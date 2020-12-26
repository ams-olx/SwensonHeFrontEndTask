package com.ams.currencyconverter.ui.views.currenciesListingFragment.recyclerView

import android.view.ViewGroup
import com.ams.androiddevkit.baseClasses.recyclerView.BaseSimpleRecyclerViewAdapter
import com.ams.currencyconverter.common.data.models.CountryInfo

class CurrenciesRatesAdapter(private val clickAction: (item: CountryInfo) -> Unit)
    : BaseSimpleRecyclerViewAdapter<CountryInfo, CurrenciesRatesViewHolder>(listOf()) {
    override fun getNewViewHolder(parent: ViewGroup, viewType: Int) = CurrenciesRatesViewHolder(parent, clickAction)
}