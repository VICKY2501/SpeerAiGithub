package com.example.speerai.utils

import android.widget.ImageView
import com.squareup.picasso.Picasso

object BindingAdapter {
    @JvmStatic
    @androidx.databinding.BindingAdapter("imageurl")
    fun imageurl(view: ImageView, url:String?)
    {
        url?.let{
            Picasso.get().load(url).into(view);
        }
    }
}