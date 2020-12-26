package com.ams.currencyconverter.common.baseClasses.mvvm

import com.ams.androiddevkit.baseClasses.designPatterns.mvvm.BaseViewModel
import com.ams.currencyconverter.common.AppViewState
import com.ams.currencyconverter.common.data.rest.RequestExecuter
import com.ams.currencyconverter.common.di.KoinComponentResolver
import com.ams.currencyconverter.common.utils.AppViewStateController
import org.koin.core.inject
import org.koin.core.parameter.parametersOf

@Suppress("MemberVisibilityCanBePrivate")
open class AppViewModel: BaseViewModel<AppViewState>() {

    protected val requestExecuter: RequestExecuter by KoinComponentResolver.inject {
        parametersOf(viewStateController)
    }

    protected val viewStateController by lazy { AppViewStateController(viewState) }

    override fun onCleared() {
        super.onCleared()
        this.requestExecuter.dispose()
    }
}