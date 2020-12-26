package com.ams.currencyconverter.common.utils.uiUtils.viewPlugins

import com.ams.currencyconverter.common.AppViewState
import com.ams.currencyconverter.ui.dialogs.NetworkLoaderDialogFragment

interface ViewStatesPlugin {

    fun onShowLoading()

    fun onHideLoading() {
        NetworkLoaderDialogFragment.dismiss()
    }

    fun onInitialState() {}

    fun onRenderState(state: Any) {}

    fun onRenderStateWithResult(obj: Any?) {}

    fun onRenderThrowableState(throwable: Throwable)

    fun onViewStateChanged(state: AppViewState) {
        when(state) {
            is AppViewState.InitialState -> onInitialState()
            is AppViewState.ShowLoading -> onShowLoading()
            is AppViewState.HideLoading -> onHideLoading()
            is AppViewState.RenderThrowable -> onRenderThrowableState(state.throwable)
            is AppViewState.RenderState<*> -> onRenderState(state.state)
            is AppViewState.RenderResult<*> -> onRenderStateWithResult(state.obj)
            else -> Throwable("Unknown state")
        }
    }
}