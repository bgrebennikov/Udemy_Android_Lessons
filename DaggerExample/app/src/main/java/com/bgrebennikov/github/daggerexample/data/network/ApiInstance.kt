package com.bgrebennikov.github.daggerexample.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class ApiInstance @Inject constructor() {


    companion object {
        private const val BASE_URL = "https://jsonplaceholder.typicode.com/"

        val instance = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }

}