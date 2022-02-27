package com.bgrebennikov.github.daggerexample.data.network

import com.bgrebennikov.github.daggerexample.data.models.PhotosModel
import retrofit2.http.GET

interface ApiService {

    @GET("photos")
    suspend fun getAllPhotos() : List<PhotosModel>

}