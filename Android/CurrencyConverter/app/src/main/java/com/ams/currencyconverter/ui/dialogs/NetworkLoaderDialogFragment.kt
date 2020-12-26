package com.ams.currencyconverter.ui.dialogs

import android.os.Bundle
import android.view.View
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentActivity
import com.ams.currencyconverter.R
import kotlinx.android.synthetic.main.fragment_network_loader_dialog.*

class NetworkLoaderDialogFragment: DialogFragment(R.layout.fragment_network_loader_dialog) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loading_indicator_image_view.setBackgroundColor(0)
    }

    companion object {

        private lateinit var networkLoaderDialogFragment: NetworkLoaderDialogFragment

        fun show(activity: FragmentActivity) {
            if(!::networkLoaderDialogFragment.isInitialized)
                networkLoaderDialogFragment = NetworkLoaderDialogFragment()
            networkLoaderDialogFragment.show(activity.supportFragmentManager, null)
        }

        fun dismiss() {
            if(::networkLoaderDialogFragment.isInitialized)
                networkLoaderDialogFragment.dismiss()
        }
    }
}
