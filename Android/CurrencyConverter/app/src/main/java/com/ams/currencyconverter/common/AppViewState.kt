package com.ams.currencyconverter.common

sealed class AppViewState {
    object Online: AppViewState()
    object Offline: AppViewState()
    object InitialState: AppViewState()
    object ShowLoading: AppViewState()
    object HideLoading: AppViewState()
    object ReloadFromScratch: AppViewState()
    object EmptyList: AppViewState()
    object NoMoreItemsToLoad: AppViewState()
    object CompletedWithEmptyResult: AppViewState()
    class RenderResult<T>(val obj: T): AppViewState()
    class RenderThrowable(val throwable: Throwable): AppViewState()
    class RenderState<E: Enum<E>>(val state: E): AppViewState()
}