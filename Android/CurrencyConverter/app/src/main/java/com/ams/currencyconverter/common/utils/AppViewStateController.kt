package com.ams.currencyconverter.common.utils

import com.ams.androiddevkit.utils.liveDataUtils.SingleLiveEvent
import com.ams.currencyconverter.common.AppViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AppViewStateController(private val viewState: SingleLiveEvent<AppViewState>) {

    fun postViewState(state: AppViewState) {
        GlobalScope.launch(Dispatchers.Main) {
            viewState.value = state
        }
    }

    fun <T>postResult(obj: T) {
        postViewState(AppViewState.RenderResult(obj))
    }

    fun <E: Enum<E>>postRenderingState(renderedState: E) {
        postViewState(AppViewState.RenderState(renderedState))
    }

    fun postThrowable(throwable: Throwable) {
        postViewState(AppViewState.RenderThrowable(throwable))
    }
}