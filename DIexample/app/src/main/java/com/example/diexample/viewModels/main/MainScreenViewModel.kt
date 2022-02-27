package com.example.diexample.viewModels.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.core_network.api.di.NetworkComponent
import com.example.diexample.R
import com.example.diexample.models.base.ListItem
import com.example.diexample.models.game.*
import com.example.diexample.util.ResourceProvider
import com.example.diexample.viewModels.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainScreenViewModel @Inject constructor(
    private val resources: ResourceProvider
) : BaseViewModel() {

    private val api = NetworkComponent.createApi()

    private val _data = MutableLiveData<List<ListItem>>()
    val data: LiveData<List<ListItem>> = _data

    init {

        viewModelScope.launch(Dispatchers.IO) {
            _data.postValue(getLoaders())
            _data.postValue(getItems())
        }

    }

    private fun getLoaders(): List<ListItem> {
        return listOf(
            GamesHorizontalItem(
                title = resources.getString(R.string.most_anticipated),
                games = IntRange(1, 2).map { ProgressWideItem }
            ),

            GamesHorizontalItem(
                title = resources.getString(R.string.latest_releases),
                games = IntRange(1, 3).map { ProgressThinItem }
            ),

            GamesHorizontalItem(
                title = resources.getString(R.string.most_rated_in_2022),
                games = IntRange(1, 2).map { ProgressWideItem }
            )
        )
    }

    private suspend fun getItems(): List<ListItem> {
        val mostAnticipatedResponse = api.games(
            mapOf(
                "dates" to "2022-01-24,2022-01-24",
                "ordering" to "-added"
            )
        )

        val latestReleasesResponse = api.games(
            mapOf(
                "dates" to "2022-01-01,2022-01-24",
            )
        )

        val mostRatedResponse = api.games(
            mapOf(
                "dates" to "2021-10-01,2022-01-24",
                "ordering" to "-rated"
            )
        )

        val anticipatedItems = mostAnticipatedResponse.results.map {
            GameWideItem(
                id = it.id,
                title = it.name,
                image = it.image
            )
        }


        val latestItems = latestReleasesResponse.results.map {
            GameThinItem(
                id = it.id,
                title = it.name,
                image = it.image
            )
        }

        val mostRatedItems = mostRatedResponse.results.map {
            GameWideItem(
                id = it.id,
                title = it.name,
                image = it.image
            )
        }



        return listOf(
            GamesHorizontalItem(
                title =  resources.getString(R.string.most_anticipated),
                games = anticipatedItems
            ),
            GamesHorizontalItem(
                title = resources.getString(R.string.latest_releases),
                games = latestItems
            ),
            GamesHorizontalItem(
                title = resources.getString(R.string.most_rated_in_2022),
                games = mostRatedItems
            ),
        )


    }


}