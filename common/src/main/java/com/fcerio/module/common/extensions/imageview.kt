package com.fcerio.module.common.extensions

import android.annotation.SuppressLint
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.appcompat.content.res.AppCompatResources
import androidx.databinding.BindingAdapter
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.bumptech.glide.signature.ObjectKey
import com.fcerio.module.common.R
import timber.log.Timber

//@SuppressLint("CheckResult")
//@BindingAdapter("avatarUrl", "imageSignature", "placeholderImage", requireAll = false)
//fun ImageView.loadAvatarUrl(
//    avatarUrl: String? = null,
//    imageSignature: Any? = null,
//    placeholderImage: Drawable? = null
//) {
//    val placeholder = placeholderImage ?: AppCompatResources.getDrawable(context, R.drawable.image_placeholder)
//    val image = GlideApp.with(this.context)
//        .load(avatarUrl)
//        .placeholder(placeholder)
//        .error(placeholder)
//        .fallback(placeholder)
//        .skipMemoryCache(false)
//        .dontAnimate()
//        .listener(object : RequestListener<Drawable> {
//            override fun onLoadFailed(
//                e: GlideException?,
//                model: Any?,
//                target: Target<Drawable>?,
//                isFirstResource: Boolean
//            ): Boolean {
//                Timber.e("onLoadFailed Error $e")
//                return false
//            }
//
//            override fun onResourceReady(
//                resource: Drawable?,
//                model: Any?,
//                target: Target<Drawable>?,
//                dataSource: DataSource?,
//                isFirstResource: Boolean
//            ): Boolean {
//                return false
//            }
//        })
//
//    if (imageSignature != null) {
//        image.signature(ObjectKey(imageSignature))
//    }
//    image.into(this)
//}