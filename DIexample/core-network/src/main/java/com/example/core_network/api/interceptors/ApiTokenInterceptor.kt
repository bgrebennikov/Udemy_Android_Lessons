package com.example.core_network.api.interceptors

import okhttp3.Interceptor
import okhttp3.Response

class ApiTokenInterceptor(private val apiToken : String) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val url = original.url.newBuilder()
            .addQueryParameter("key", apiToken)
            .build()
        return chain.proceed(
            original.newBuilder().url(url).build()
        )
    }
}