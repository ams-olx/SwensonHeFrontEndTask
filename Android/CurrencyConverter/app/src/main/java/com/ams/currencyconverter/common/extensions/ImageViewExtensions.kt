package com.ams.currencyconverter.common.extensions

import android.widget.ImageView
import androidx.annotation.DimenRes
import androidx.annotation.DrawableRes
import androidx.annotation.RawRes
import androidx.core.content.ContextCompat
import coil.*
import coil.size.ViewSizeResolver
import coil.transform.RoundedCornersTransformation
import com.ams.currencyconverter.R

fun ImageView.loadFrom(url: String?, withRoundedCorners: Boolean = false,
                       @DimenRes cornerRadiusRes: Int = R.dimen._5dp,
                       @DrawableRes errorImage: Int? = null,
                       @DrawableRes fallBackImage: Int? = null,
                       @DrawableRes placeholderImage: Int? = null) {
    url?.let {
        this.load(uri = it) {
            if(errorImage != null)
                error(errorImage)
            if(fallBackImage != null)
                fallback(fallBackImage)
            if(placeholderImage != null)
                placeholder(placeholderImage)
            size(ViewSizeResolver(this@loadFrom))
            if(withRoundedCorners) {
                val cornerRadius = context.resources.getDimension(cornerRadiusRes)
                val roundedCornersImageTransformation = RoundedCornersTransformation(cornerRadius)
                transformations(roundedCornersImageTransformation)
            }
        }
    } ?: run {
        if(fallBackImage != null)
            this.setImageDrawable(ContextCompat.getDrawable(context, fallBackImage))
        else
            this.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.image_place_holder))
    }
}

fun ImageView.loadFrom(@RawRes drawableResId: Int) {
    this.load(drawableResId)
}