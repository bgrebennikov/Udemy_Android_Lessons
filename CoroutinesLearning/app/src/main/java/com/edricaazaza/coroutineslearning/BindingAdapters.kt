package com.edricaazaza.coroutineslearning

import android.widget.TextView
import androidx.databinding.BindingAdapter


@BindingAdapter("temperature")
fun bindTemperature(textView: TextView, tmpValue: Int){
    textView.text = String.format(
        textView.context.getString(R.string.temperature_value),
        tmpValue
    )
}