package com.ams.currencyconverter.common.di.modules

import com.ams.androiddevkit.utils.di.ResourceProvider
import com.ams.currencyconverter.common.data.rest.AppErrorHandler
import com.ams.currencyconverter.common.data.rest.RequestExecuter
import com.ams.currencyconverter.common.utils.AppViewStateController
import io.reactivex.rxjava3.disposables.CompositeDisposable
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

val otherModules: Module = module {
    factory { CompositeDisposable() }
    factory { (viewStateController: AppViewStateController) ->
        RequestExecuter(viewStateController = viewStateController, appErrorHandler = get(), compositeDisposable = get())
    }
    single { AppErrorHandler() }
    single { ResourceProvider(androidContext()) }
}