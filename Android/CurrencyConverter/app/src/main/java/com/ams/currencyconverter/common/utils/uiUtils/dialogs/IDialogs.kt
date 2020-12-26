package com.ams.currencyconverter.common.utils.uiUtils.dialogs

import androidx.annotation.StringRes

interface IDialogs {
    fun showLoading()
    fun hideLoading()
    fun showError(message: String)
    fun showError(@StringRes message: Int)
    fun showSuccess(message: String)
    fun showSuccess(@StringRes message: Int)
}