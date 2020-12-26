package com.ams.currencyconverter.ui.views.currenciesListingFragment

import com.ams.androiddevkit.utils.extensions.tryCastListOf
import com.ams.currencyconverter.R
import com.ams.currencyconverter.common.Constants
import com.ams.currencyconverter.common.baseClasses.mvvm.AppFragment
import com.ams.currencyconverter.common.data.models.CountryInfo
import com.ams.currencyconverter.common.extensions.setDivider
import com.ams.currencyconverter.ui.views.currenciesListingFragment.recyclerView.CurrenciesRatesAdapter
import com.ams.currencyconverter.ui.views.fragmentHostActivity.SharedViewModel
import kotlinx.android.synthetic.main.fragment_currencies_listing.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class CurrenciesListingFragment: AppFragment<CurrenciesListingViewModel>(CurrenciesListingViewModel::class) {

    private lateinit var recyclerViewAdapter: CurrenciesRatesAdapter
    private val sharedViewModel: SharedViewModel by sharedViewModel()

    override fun getViewId() = R.layout.fragment_currencies_listing

    override fun initUI() {
        recyclerViewAdapter = CurrenciesRatesAdapter {
            sharedViewModel.renderCurrencyConverterView(it)
        }
        recycler_view.apply {
            adapter = recyclerViewAdapter
            setDivider(R.drawable.recycler_view_divider)
        }
        base_currency_image_view.text = Constants.BASE_CURRENCY
    }

    override fun onRenderStateWithResult(obj: Any?) {
        obj.tryCastListOf<CountryInfo> {
            recyclerViewAdapter.apply {
                clear()
                addAll(this@tryCastListOf)
            }
        }
    }
}