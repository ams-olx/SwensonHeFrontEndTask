package com.ams.currencyconverter.common.exceptionsAndThrowables

@Suppress("unused")
data class APIError(val success: Boolean, val error: Map<String, Any>): Throwable() {

    fun getErrorCode(): Int = error["code"] as Int

    fun getErrorMessage(): String = error["info"] as String
}