package com.bgrebennikov.github.daggerexample.domain.useCases

import com.bgrebennikov.github.daggerexample.data.Repository
import com.bgrebennikov.github.daggerexample.data.models.PhotosModel

class GetPhotosUseCase(
    private val repository: Repository
) {

    suspend operator fun invoke() : List<PhotosModel>{
        return repository.getAllPhotos()
    }

}