package com.ams.currencyconverter.common.data.rest

import com.ams.androiddevkit.baseClasses.networking.error.BaseIErrors
import com.ams.androiddevkit.utils.extensions.disposeIfNot
import com.ams.androiddevkit.utils.extensions.execute
import com.ams.currencyconverter.common.AppViewState
import com.ams.currencyconverter.common.utils.AppViewStateController
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable

class RequestExecuter(private val viewStateController: AppViewStateController,
                      private val appErrorHandler: AppErrorHandler,
                      private val compositeDisposable: CompositeDisposable) {

    fun <T> execute(single: Single<T>, errorAction: () -> Unit? = {}) {
        execute(single, true, errorAction)
    }

    @Suppress("MemberVisibilityCanBePrivate")
    fun <T> execute(single: Single<T>, withLoader: Boolean, errorAction: () -> Unit? = {}) {
        if(withLoader) viewStateController.postViewState(AppViewState.ShowLoading)
        single
                .execute(compositeDisposable, success = {
                    viewStateController.postResult(it)
                }, error = {
                    handleNetworkError(it)
                    errorAction()
                }, doFinally = {
                    if(withLoader) viewStateController.postViewState(AppViewState.HideLoading)
                })
    }

    fun dispose() {
        compositeDisposable.disposeIfNot()
    }

    private fun handleNetworkError(throwable: Throwable) {
        appErrorHandler.processError(throwable, object: BaseIErrors {

            override fun onShowUnknownError(throwable: Throwable) {
                viewStateController.postThrowable(throwable)
            }

            override fun onShowNetworkError(throwable: Throwable) {
                viewStateController.postThrowable(throwable)
            }

            override fun onShowNonNetworkError(throwable: Throwable) {
                viewStateController.postThrowable(throwable)
            }

            override fun onShowError(errorMessage: String) {
                viewStateController.postThrowable(Throwable(errorMessage))
            }
        })
    }
}