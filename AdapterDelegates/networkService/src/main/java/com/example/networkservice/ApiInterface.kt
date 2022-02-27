package com.example.networkservice

import com.example.networkservice.data.PostsDataResponse
import retrofit2.http.GET

interface ApiInterface {

    @GET("/posts")
    suspend fun getPosts() : List<PostsDataResponse>

}