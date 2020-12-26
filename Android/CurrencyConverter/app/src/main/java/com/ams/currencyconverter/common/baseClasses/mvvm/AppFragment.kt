package com.ams.currencyconverter.common.baseClasses.mvvm

import com.ams.androiddevkit.baseClasses.designPatterns.mvvm.BaseMVVMFragment
import com.ams.androiddevkit.utils.internetConnectionManager.InternetConnectionType
import com.ams.currencyconverter.R
import com.ams.currencyconverter.common.AppViewState
import com.ams.currencyconverter.common.utils.uiUtils.viewPlugins.ViewStatesPlugin
import com.ams.currencyconverter.common.utils.uiUtils.viewPlugins.NetworkObserverPlugin
import com.ams.currencyconverter.common.utils.uiUtils.viewPlugins.SnackbarPlugin
import com.ams.currencyconverter.ui.dialogs.AlertDialogFragment
import com.ams.currencyconverter.ui.dialogs.NetworkLoaderDialogFragment
import kotlin.reflect.KClass

@Suppress("unused")
abstract class AppFragment<ViewModel : AppViewModel>(klazz: KClass<ViewModel>) :
    BaseMVVMFragment<ViewModel, AppViewState>(klazz), ViewStatesPlugin, SnackbarPlugin, NetworkObserverPlugin {

    override fun bindViews() {}

    override fun onResume() {
        super.onResume()
        this.onFragmentVisible()
    }

    override fun onShowLoading() {
        NetworkLoaderDialogFragment.show(requireActivity())
    }

    protected open fun onFragmentVisible() {
        this.startNetworkChangeListener(this)
    }

    override fun onStop() {
        super.onStop()
        NetworkLoaderDialogFragment.dismiss()
        this.stopNetworkChangeListener()
    }

    override fun onNetworkConnected(connectionType: InternetConnectionType) {
        showTopSnackbar(
            requireActivity(),
            getString(R.string.internet_connected),
            backgroundColorId = R.color.snackbar_green
        )
    }

    override fun onNetworkDisconnected() {
        showTopSnackbar(requireActivity(), getString(R.string.no_internet_connection))
    }

    override fun shouldEnableConnectivityMonitoring() = false

    override fun onRenderThrowableState(throwable: Throwable) {
        AlertDialogFragment.showError(requireActivity(), throwable.message ?: throwable.toString())
    }

    protected open fun onBackPressed() {
        requireActivity().onBackPressed()
    }
}