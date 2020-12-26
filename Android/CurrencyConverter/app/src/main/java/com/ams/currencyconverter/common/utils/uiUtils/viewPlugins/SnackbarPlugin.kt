package com.ams.currencyconverter.common.utils.uiUtils.viewPlugins

import android.app.Activity
import android.content.res.Resources
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.widget.FrameLayout
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import com.ams.currencyconverter.R
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar
import kotlin.math.roundToInt

interface SnackbarPlugin {

    fun showTopSnackbar(
        activity: Activity,
        message: String,
        @ColorRes backgroundColorId: Int = R.color.red,
        @BaseTransientBottomBar.Duration duration: Int = Snackbar.LENGTH_LONG
    ) {
        val view: View = activity.findViewById(android.R.id.content)
        val snackbar = Snackbar.make(view, message, duration)
        snackbar.setBackgroundTint(ContextCompat.getColor(activity, backgroundColorId))
        snackbar.setActionTextColor(ContextCompat.getColor(activity, R.color.white))
        val snackbarView = snackbar.view
        val params = snackbarView.layoutParams as FrameLayout.LayoutParams
        params.gravity = Gravity.CENTER_HORIZONTAL or Gravity.TOP
        // Calculate toolbar height
        val typedValue = TypedValue()
        var snackbarTopMargin = 0
        val snackbarSideMargins = convertDpToPixel(activity.resources.getDimension(R.dimen._50dp)).roundToInt()
        if (activity.theme.resolveAttribute(R.attr.actionBarSize, typedValue, true))
            snackbarTopMargin = TypedValue.complexToDimensionPixelSize(typedValue.data, activity.resources.displayMetrics)
        // Set margin
        params.setMargins(snackbarSideMargins, snackbarTopMargin, snackbarSideMargins, 0)
        snackbarView.layoutParams = params
        snackbar.show()
    }

    fun shopBottomSnackbar(
        activity: Activity,
        message: String,
        anchoredView: View? = null,
        @ColorRes backgroundColorId: Int = R.color.red,
        @BaseTransientBottomBar.Duration duration: Int = Snackbar.LENGTH_LONG
    ) {
        val view: View = activity.findViewById(android.R.id.content)
        Snackbar
            .make(view, message, duration)
            .setAnchorView(anchoredView)
            .setBackgroundTint(ContextCompat.getColor(activity, backgroundColorId))
            .setActionTextColor(ContextCompat.getColor(activity, R.color.white))
            .show()
    }

    private fun convertDpToPixel(dp: Float): Float {
        val metrics: DisplayMetrics = Resources.getSystem().displayMetrics
        val px = dp * (metrics.densityDpi / 160f)
        return px.roundToInt().toFloat()
    }
}