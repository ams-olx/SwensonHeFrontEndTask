package com.ams.currencyconverter.common.exceptionsAndThrowables

import java.io.IOException

class NoInternetConnectionException(override val message: String): IOException()