package com.example.diexample.util

import android.content.Context
import javax.inject.Inject

class AndroidResourceProvider @Inject constructor(
    private val context : Context
) : ResourceProvider {
    override fun getString(id: Int): String = context.resources.getString(id)

}