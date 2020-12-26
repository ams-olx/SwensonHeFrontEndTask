//package com.ams.currencyconverter.common.utils.uiUtils.dialogs
//
//import android.app.DatePickerDialog
//import android.app.TimePickerDialog
//import androidx.annotation.StringRes
//
//class AppDialogs: IDialogs {
//
//    private lateinit var networkLoaderDialogFragment: NetworkLoaderDialogFragment
//
//    override fun showLoading() {
//        if(!::networkLoaderDialogFragment.isInitialized)
//            networkLoaderDialogFragment = NetworkLoaderDialogFragment()
//        networkLoaderDialogFragment.show(getCurrentActivity().supportFragmentManager, null)
//    }
//
//    override fun hideLoading() {
//        if(::networkLoaderDialogFragment.isInitialized)
//            networkLoaderDialogFragment.dismiss()
//    }
//
//    override fun showError(message: String) {
//        this.hideLoading()
//        this.getErrorDialog(message).show(getCurrentActivity().supportFragmentManager)
//    }
//
//    override fun showError(@StringRes message: Int) {
//        showError(getCurrentActivity().getString(message))
//    }
//
//    override fun showSuccess(message: String) {
//        this.getSuccessDialog(message)
//            .show(getCurrentActivity().supportFragmentManager)
//    }
//
//    override fun showSuccess(@StringRes message: Int) {
//        showSuccess(getCurrentActivity().getString(message))
//    }
//
//    private fun getSuccessDialog(message: String): AlertDialogFragment {
//        return getDialog(message = message, isSuccess = true)
//    }
//
//    private fun getErrorDialog(message: String): AlertDialogFragment {
//        return getDialog(message = message, isSuccess = false)
//    }
//
//    private fun getDialog(message: String, isSuccess: Boolean): AlertDialogFragment {
//        return AlertDialogFragment.instance(message = message, isSuccess = isSuccess)
//    }
//
//    private fun getDialog(title: String,
//                          message: String,
//                          okButtonTitle: String? = null,
//                          cancelButtonTitle: String? = null,
//                          isSuccess: Boolean): AlertDialogFragment {
//        return AlertDialogFragment.instance(title, message, okButtonTitle, cancelButtonTitle, isSuccess)
//    }
//
//    private fun getCurrentActivity() = KhdmaApp.instance.getCurrentActivity()!!
//}