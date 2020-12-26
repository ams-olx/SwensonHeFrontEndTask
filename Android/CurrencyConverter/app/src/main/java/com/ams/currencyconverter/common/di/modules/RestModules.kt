package com.ams.currencyconverter.common.di.modules

import com.ams.androiddevkit.baseClasses.networking.retrofitErrorHandler.RxErrorHandlingCallAdapterFactory
import com.ams.androiddevkit.utils.services.serialization.SerializationService
import com.ams.currencyconverter.common.data.rest.apis.APIs
import com.ams.currencyconverter.common.data.rest.client.RestClient
import com.ams.currencyconverter.common.data.rest.configs.RestConfigs
import com.ams.currencyconverter.common.data.rest.configs.RetrofitAdapters
import com.ams.currencyconverter.common.data.rest.interceptors.NetworkConnectivityInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.dsl.module

val restClientConfigsModule: Module = module {
    single { RestClient(restConfigs = get()) }
    factory { RetrofitAdapters(rxAdapterFactory = get(), jsonConverterFactory = get()) }
    factory { RxErrorHandlingCallAdapterFactory.create() }
    factory { get<SerializationService>().getRetrofitJsonConverterFactory() }
    factory { RestConfigs(networkConnectivityInterceptor = get(), retrofitAdapters = get()) }
}

val okHttpInterceptorsModules: Module = module {
    factory { NetworkConnectivityInterceptor(androidContext(), resourceProvider = get()) }
}

val restAPIsModules: Module = module {
    factory { get<RestClient>().getRetrofitClient(APIs::class.java) }
}