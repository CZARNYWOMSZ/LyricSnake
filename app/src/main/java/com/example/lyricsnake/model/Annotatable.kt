package com.example.lyricsnake.model

import com.google.gson.annotations.SerializedName


data class Annotatable (

    @SerializedName("api_path") val apiPath : String,
    @SerializedName("client_timestamps") val clientTimestamps : ClientTimestamps,
    @SerializedName("context") val context : String,
    @SerializedName("id") val id : Int,
    @SerializedName("image_url") val imageUrl : String,
    @SerializedName("link_title") val linkTitle : String,
    @SerializedName("title") val title : String,
    @SerializedName("type") val type : String,
    @SerializedName("url") val url : String
)