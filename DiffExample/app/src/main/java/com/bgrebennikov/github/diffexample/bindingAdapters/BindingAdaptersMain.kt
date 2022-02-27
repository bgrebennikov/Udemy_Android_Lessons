package com.bgrebennikov.github.diffexample.bindingAdapters

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("age")
fun setName(textView: TextView, age: Int){
    textView.text = age.toString()
}

@BindingAdapter("isEmployer")
fun setIsEmployer(textView: TextView, isEmployer: Boolean){
    textView.text = if(isEmployer) "Employer" else "Not employer"
}