package com.example.core_network.api

import com.example.core_network.model.base.PagedResponse
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface RawgApi {

    @GET("/api/games")
    suspend fun games(
        @QueryMap params : Map<String, String>
    ) : PagedResponse

}