package com.example.core_network.model

import com.google.gson.annotations.SerializedName

data class GameDto(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String,
    @SerializedName("background_image") val image: String
)