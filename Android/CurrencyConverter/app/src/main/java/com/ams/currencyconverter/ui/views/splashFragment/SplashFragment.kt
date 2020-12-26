package com.ams.currencyconverter.ui.views.splashFragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.ams.currencyconverter.R
import com.ams.currencyconverter.ui.views.fragmentHostActivity.SharedViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class SplashFragment: Fragment(R.layout.fragment_splash) {

    private val sharedViewModel: SharedViewModel by sharedViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        GlobalScope.launch {
            delay(2000)
            sharedViewModel.renderCurrenciesListingView()
        }
    }
}