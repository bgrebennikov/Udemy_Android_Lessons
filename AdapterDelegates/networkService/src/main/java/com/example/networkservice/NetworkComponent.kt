package com.example.networkservice

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

interface NetworkComponent {

    companion object {
        private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

        fun createApi() : ApiInterface {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApiInterface::class.java)
        }

    }

}