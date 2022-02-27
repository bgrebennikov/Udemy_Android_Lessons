package com.bgrebennikov.github.daggerexample.domain

import com.bgrebennikov.github.daggerexample.data.models.PhotosModel
import com.bgrebennikov.github.daggerexample.data.Repository
import com.bgrebennikov.github.daggerexample.data.network.ApiInstance
import javax.inject.Inject


class RepositoryImpl @Inject constructor() : Repository {

    private val apiService = ApiInstance.instance

    override suspend fun getAllPhotos(): List<PhotosModel> {
        return apiService.getAllPhotos()
    }
}