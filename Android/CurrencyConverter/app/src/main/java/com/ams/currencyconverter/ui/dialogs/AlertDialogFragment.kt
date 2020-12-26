package com.ams.currencyconverter.ui.dialogs

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity
import com.ams.currencyconverter.R
import kotlinx.android.synthetic.main.dialog_fragment_alert.*

class AlertDialogFragment: DialogFragment(R.layout.dialog_fragment_alert) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        arguments?.apply {
            message_text_view.text = this.getString(DIALOG_MESSAGE)
            var drawableId = R.drawable.error
            if(this.getBoolean(IS_SUCCESS)) {
                drawableId = R.drawable.success
                cancel_button.isVisible = false
                vertical_line.isVisible = false
            }
            ContextCompat.getDrawable(requireContext(), drawableId)?.let {
                icon_image_view.setImageDrawable(it)
            }
            getString(DIALOG_TITLE)?.let { title_text_view.text = it }
            getString(OK_BUTTON_TITLE)?.let { ok_button.text = it } ?: run {  ok_button.text = getString(R.string.ok)}
            getString(CANCEL_BUTTON_TITLE)?.let { cancel_button.text = it } ?: run {  cancel_button.text = getString(R.string.ok)}
        }
        ok_button.setOnClickListener {
            // ToDo:- To Change this action if needed
        }
        cancel_button.setOnClickListener { this.dismiss() }
    }

    companion object {

        private const val IS_SUCCESS = "IS_SUCCESS"
        private const val DIALOG_TITLE = "DIALOG_TITLE"
        private const val DIALOG_MESSAGE = "DIALOG_MESSAGE"
        private const val OK_BUTTON_TITLE = "OK_BUTTON_TITLE"
        private const val CANCEL_BUTTON_TITLE = "CANCEL_BUTTON_TITLE"

        private fun instance(title: String? = "",
                             message: String,
                             okButtonTitle: String? = null,
                             cancelButtonTitle: String? = null,
                             isSuccess: Boolean) = AlertDialogFragment().apply {
            arguments = Bundle().apply {
                putBoolean(IS_SUCCESS, isSuccess)
                putString(DIALOG_TITLE, title)
                putString(DIALOG_MESSAGE, message)
                if(okButtonTitle != null) putString(OK_BUTTON_TITLE, okButtonTitle)
                if(cancelButtonTitle != null) putString(CANCEL_BUTTON_TITLE, cancelButtonTitle)
            }
        }

        @Suppress("unused")
        fun showSuccess(activity: FragmentActivity, message: String) {
           instance(message = message, isSuccess = true).show(activity.supportFragmentManager, null)
        }

        fun showError(activity: FragmentActivity, message: String) {
            instance(message = message, isSuccess = false).show(activity.supportFragmentManager, null)
        }
    }
}