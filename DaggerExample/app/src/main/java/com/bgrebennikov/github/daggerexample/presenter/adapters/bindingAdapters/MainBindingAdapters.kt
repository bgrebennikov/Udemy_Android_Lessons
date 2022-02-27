package com.bgrebennikov.github.daggerexample.presenter.adapters.bindingAdapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders

@BindingAdapter("loadFromUrl")
fun loadFromUrl(imageView: ImageView, source: String) {
    val url = GlideUrl(
        source, LazyHeaders.Builder()
            .addHeader(
                "User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.164 Safari/537.36 RuxitSynthetic/1.0 v7591284196495702343 t6192843113956353301 ath2653ab72 altpriv cvcv=2 smf=0 svfu=1"
            )
            .build()
    )
    Glide
        .with(imageView.context)
        .load(url)
        .centerCrop()
        .into(imageView)
}