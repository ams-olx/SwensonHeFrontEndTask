package com.ams.currencyconverter.common.application

import androidx.appcompat.app.AppCompatActivity
import com.ams.androiddevkit.baseClasses.application.BaseApplication
import com.ams.androiddevkit.utils.internetConnectionManager.ConnectivityObserver
import com.ams.androiddevkit.utils.services.logging.LoggingService
import com.ams.currencyconverter.BuildConfig
import com.ams.currencyconverter.common.data.services.ImageLoadingService
import com.ams.currencyconverter.common.di.modules.*
import io.reactivex.rxjava3.exceptions.UndeliverableException
import io.reactivex.rxjava3.plugins.RxJavaPlugins
import org.koin.android.ext.android.get
import org.koin.core.logger.Level
import org.koin.core.module.Module

class Application: BaseApplication() {

    private val activityLifecycleCallbacks = AppActivityLifecycleCallbacks()

    override fun getCurrentActivity() = activityLifecycleCallbacks.currentActivity as AppCompatActivity?

    override fun onCreate() {
        super.onCreate()
        this.initKoin(this)
        ConnectivityObserver.start(this)
        ImageLoadingService.initWith(imageLoader = get())
        this.registerActivityLifecycleCallbacks(activityLifecycleCallbacks)
        this.initRxErrorHandler()
    }

    override fun getKoinLoggingLevel() = if (BuildConfig.DEBUG) Level.ERROR else Level.NONE

    override fun getKoinModules(): List<Module> {
        return listOf(
            fragmentModules,
            viewModelModules,
            repositoryModules,
            restClientConfigsModule,
            okHttpInterceptorsModules,
            restAPIsModules,
            servicesModules,
            otherModules
        )
    }

    private fun initRxErrorHandler() {
        val loggingService = get<LoggingService>()
        // Ref: https://stackoverflow.com/a/52633194/6927433
        RxJavaPlugins.setErrorHandler {
            loggingService.e("KhdmaApp RxError", it.toString())
            if( it is UndeliverableException) {
                loggingService.e("KhdmaApp RxUndeliverableException", it.toString())
                return@setErrorHandler
            }
        }
    }
}