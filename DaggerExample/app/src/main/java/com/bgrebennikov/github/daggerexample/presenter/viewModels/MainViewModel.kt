package com.bgrebennikov.github.daggerexample.presenter.viewModels

import android.os.CountDownTimer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bgrebennikov.github.daggerexample.data.Repository
import com.bgrebennikov.github.daggerexample.data.models.PhotosModel
import com.bgrebennikov.github.daggerexample.domain.RepositoryImpl
import com.bgrebennikov.github.daggerexample.domain.useCases.GetPhotosUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

//    private val repository = RepositoryImpl()
    private val getPhotosUseCase = GetPhotosUseCase(repository)

    val listPhotos = MutableLiveData<List<PhotosModel>>()

    init {
        loadPhotos()
    }

    private fun loadPhotos(){
        viewModelScope.launch {
            listPhotos.postValue(getPhotosUseCase())
        }
    }

    override fun onCleared() {
        super.onCleared()
    }

    companion object {
        private const val ONE_SECOND = 1000L
    }

}