package com.tokioschool.travellingkotlinmvvm.core.extension


import android.graphics.drawable.Drawable
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.tokioschool.travellingkotlinmvvm.core.base.glide.GlideApp

@BindingAdapter("loadImage","placeHolder")
fun AppCompatImageView.loadImage(profileImage: String?,placeHolder: Drawable?) {
    profileImage?.let {
        GlideApp.with(this)
            .load(profileImage)
            .defaultOptions(placeHolder)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(this)
    }
}