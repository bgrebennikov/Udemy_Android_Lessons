package com.example.networkservice.data

import com.google.gson.annotations.SerializedName

data class PostsDataResponse(
    @SerializedName("id") val id : Long,
    @SerializedName("userId") val userId : Long,
    @SerializedName("title") val title : String,
    @SerializedName("body") val body : String
)
