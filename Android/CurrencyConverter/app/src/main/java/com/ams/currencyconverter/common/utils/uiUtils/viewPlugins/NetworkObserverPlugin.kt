package com.ams.currencyconverter.common.utils.uiUtils.viewPlugins

import androidx.lifecycle.LifecycleOwner
import com.ams.androiddevkit.utils.internetConnectionManager.ConnectivityObserver
import com.ams.androiddevkit.utils.internetConnectionManager.InternetConnectionType

interface NetworkObserverPlugin {

    fun startNetworkChangeListener(lifecycleOwner: LifecycleOwner) {
        ConnectivityObserver.startNetworkChangeListener(lifecycleOwner,
            shouldEnableConnectivityMonitoring(),
            onNetworkConnectedAction = {
                onNetworkConnected(it)
            },
            onNetworkDisconnectedAction = {
                onNetworkDisconnected()
            })
    }

    fun stopNetworkChangeListener() { ConnectivityObserver.stopNetworkChangeListener() }

    fun shouldEnableConnectivityMonitoring() = true

    fun onNetworkConnected(connectionType: InternetConnectionType)

    fun onNetworkDisconnected()
}