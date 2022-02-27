package com.example.adapterdelegates.viewmodels.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.adapterdelegates.ui.adapters.models.data.PostsDataModel
import com.example.adapterdelegates.ui.adapters.models.types.ListItem
import com.example.adapterdelegates.viewmodels.BaseViewModel
import com.example.networkservice.NetworkComponent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel() : BaseViewModel() {

    val postsData = MutableLiveData<List<ListItem>>()
    private val api = NetworkComponent.createApi()

    init {
        viewModelScope.launch(Dispatchers.IO) {
            postsData.postValue(getPosts())
        }
    }

    private suspend fun getPosts() : List<ListItem>{

        Log.i("message", "getPosts")

        return api.getPosts().map {
            PostsDataModel(
                id = it.id,
                title = it.title,
                body = it.body,
                userId = it.userId
            )
        }


    }


}