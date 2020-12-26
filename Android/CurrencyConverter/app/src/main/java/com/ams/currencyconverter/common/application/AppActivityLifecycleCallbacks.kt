package com.ams.currencyconverter.common.application

import android.annotation.SuppressLint
import android.app.Activity
import android.app.Application
import android.content.pm.ActivityInfo
import android.os.Bundle

class AppActivityLifecycleCallbacks: Application.ActivityLifecycleCallbacks {

    var currentActivity: Activity? = null

    override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {}

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
        // Force all activities to run in portrait mode only
        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        currentActivity = activity
    }

    override fun onActivityStarted(activity: Activity?) {
        currentActivity = activity
    }

    override fun onActivityResumed(activity: Activity?) {
        currentActivity = activity
    }

    override fun onActivityPaused(activity: Activity?) {
        currentActivity = activity
    }

    // Returns the previous activity and not the current one
    override fun onActivityStopped(activity: Activity?) {}

    // Returns the previous activity and not the current one
    override fun onActivityDestroyed(activity: Activity?) {}
}