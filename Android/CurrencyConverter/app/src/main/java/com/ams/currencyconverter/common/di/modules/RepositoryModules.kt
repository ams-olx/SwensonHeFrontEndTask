package com.ams.currencyconverter.common.di.modules

import com.ams.currencyconverter.ui.views.common.Repo
import org.koin.core.module.Module
import org.koin.dsl.module

val repositoryModules: Module = module {
    single { Repo(apIs = get()) }
}