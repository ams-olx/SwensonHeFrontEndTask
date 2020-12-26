package com.ams.currencyconverter.common.data.rest

import com.ams.androiddevkit.baseClasses.networking.error.BaseErrorHandler
import com.ams.androiddevkit.baseClasses.networking.error.BaseIErrors
import com.ams.androiddevkit.baseClasses.networking.retrofitErrorHandler.RetrofitException
import com.ams.currencyconverter.common.exceptionsAndThrowables.APIError

class AppErrorHandler: BaseErrorHandler<BaseIErrors, APIError>(APIError::class.java) {

    override fun onHttpError(exception: RetrofitException, statusCode: Int?, errorModel: APIError, iErrors: BaseIErrors) {
        iErrors.onShowError(errorModel.getErrorMessage())
    }
}