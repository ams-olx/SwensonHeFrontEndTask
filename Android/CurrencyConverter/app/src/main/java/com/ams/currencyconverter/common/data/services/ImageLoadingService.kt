package com.ams.currencyconverter.common.data.services

import android.content.Context
import coil.Coil
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.request.CachePolicy
import coil.size.Precision
import coil.util.DebugLogger
import com.ams.currencyconverter.BuildConfig
import com.ams.currencyconverter.R

class ImageLoadingService(private val context: Context) {

    private fun getImageLoaderBuilder(): ImageLoader.Builder {
        return ImageLoader
            .Builder(context)
            .fallback(getFallbackPlaceHolder())
            .error(getFallbackPlaceHolder())
            .placeholder(getDefaultPlaceHolder())
            .availableMemoryPercentage(0.25)
            .precision(Precision.AUTOMATIC)
            .diskCachePolicy(CachePolicy.ENABLED)
            .memoryCachePolicy(CachePolicy.ENABLED)
            .networkCachePolicy(CachePolicy.ENABLED)
            .componentRegistry { add(SvgDecoder(context)) }
            .apply {
                if(BuildConfig.DEBUG)
                    logger(DebugLogger())
            }
    }

    private fun getFallbackPlaceHolder() = R.drawable.image_place_holder

    private fun getDefaultPlaceHolder() = R.drawable.shape_progress_animation

    fun getImageLoader() = getImageLoaderBuilder().build()

    companion object {
        fun initWith(imageLoader: ImageLoader) {
            Coil.setImageLoader(imageLoader)
        }
    }
}