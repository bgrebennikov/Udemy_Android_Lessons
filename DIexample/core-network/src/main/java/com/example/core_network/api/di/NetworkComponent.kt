package com.example.core_network.api.di

import com.example.core_network.BuildConfig
import com.example.core_network.api.RawgApi
import com.example.core_network.api.interceptors.ApiTokenInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface NetworkComponent {
    companion object {

        private const val BASE_URL = "https://api.rawg.io/"
        private const val ApiToken = "310f5f2b243f44639ad001c995dc9c84"

        fun createApi(): RawgApi =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(
                    OkHttpClient.Builder()
                        .addInterceptor(
                            HttpLoggingInterceptor()
                                .apply {
                                    level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                                    else HttpLoggingInterceptor.Level.NONE
                                }
                        )
                        .addInterceptor(ApiTokenInterceptor(ApiToken))
                        .build()
                )
                .build()
                .create(RawgApi::class.java)

    }
}