package com.ams.currencyconverter.ui.views.fragmentHostActivity

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.ams.androiddevkit.baseClasses.designPatterns.mvvm.BaseMVVMActivity
import com.ams.androiddevkit.utils.extensions.tryCast
import com.ams.currencyconverter.ui.views.covertCurrencyFragment.ConvertCurrencyFragment
import com.ams.currencyconverter.R
import com.ams.currencyconverter.common.AppViewState
import com.ams.currencyconverter.common.utils.uiUtils.viewPlugins.ViewStatesPlugin
import com.ams.currencyconverter.ui.dialogs.AlertDialogFragment
import com.ams.currencyconverter.ui.views.currenciesListingFragment.CurrenciesListingFragment
import com.ams.currencyconverter.ui.views.splashFragment.SplashFragment
import kotlinx.android.synthetic.main.activity_fragment_host.*

class FragmentHostActivity: BaseMVVMActivity<SharedViewModel, AppViewState>(SharedViewModel::class), ViewStatesPlugin {

    override fun getViewId() = R.layout.activity_fragment_host

    override fun initUI() {
        this.openFragment(SplashFragment::class.java)
    }

    override fun bindViews() {}

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 2) finish() else super.onBackPressed()
    }

    override fun onShowLoading() {}

    override fun onRenderThrowableState(throwable: Throwable) {
        AlertDialogFragment.showError(this, throwable.message ?: throwable.toString())
    }

    override fun onViewStateChanged(state: AppViewState) {
        super.onViewStateChanged(state)
    }

    override fun onRenderState(state: Any) {
        state.tryCast<FragmentHostActivityActions> {
            when (this) {
                FragmentHostActivityActions.RENDER_CURRENCIES_LISTING -> openFragment(
                    CurrenciesListingFragment::class.java
                )
                FragmentHostActivityActions.RENDER_CURRENCY_CONVERTER -> openFragment(
                    ConvertCurrencyFragment::class.java
                )
            }
        }
    }

    private fun <F : Fragment> openFragment(fragmentClass: Class<F>, args: Bundle? = null) {
        val fragmentTAG = fragmentClass.simpleName
        val transaction = this.supportFragmentManager.beginTransaction()
        transaction.replace(fragment_container_view.id, fragmentClass, args, fragmentTAG)
        transaction.addToBackStack(fragmentTAG)
        transaction.commit()
    }
}

