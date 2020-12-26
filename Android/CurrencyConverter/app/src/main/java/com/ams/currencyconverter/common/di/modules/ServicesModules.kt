package com.ams.currencyconverter.common.di.modules

import com.ams.androiddevkit.utils.services.gsonService.GsonService
import com.ams.androiddevkit.utils.services.gsonService.GsonServiceImpl
import com.ams.androiddevkit.utils.services.logging.LoggingService
import com.ams.androiddevkit.utils.services.logging.LoggingServiceImpl
import com.ams.androiddevkit.utils.services.rxSchedulersService.RxSchedulersService
import com.ams.androiddevkit.utils.services.rxSchedulersService.RxSchedulersServiceImpl
import com.ams.androiddevkit.utils.services.serialization.GsonSerializationService
import com.ams.androiddevkit.utils.services.serialization.SerializationService
import com.ams.androiddevkit.utils.services.session.SessionService
import com.ams.androiddevkit.utils.services.session.SessionServiceImpl
import com.ams.currencyconverter.common.data.services.ImageLoadingService
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module

val servicesModules: Module = module {
    factory { SessionServiceImpl(sharedPrefService = get(), loggingService = get(), serializationService = get()) }.bind(SessionService::class)
    factory { GsonServiceImpl() }.bind(GsonService::class)
    single { ImageLoadingService(androidContext()).getImageLoader() }
    single { RxSchedulersServiceImpl() }.bind(RxSchedulersService::class)
    single { GsonSerializationService(gsonService = get()) }.bind(SerializationService::class)
    single { LoggingServiceImpl() }.bind(LoggingService::class)
}