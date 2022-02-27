package com.bgrebennikov.github.daggerexample.data

import com.bgrebennikov.github.daggerexample.data.models.PhotosModel

interface Repository {

    suspend fun getAllPhotos(): List<PhotosModel>

}