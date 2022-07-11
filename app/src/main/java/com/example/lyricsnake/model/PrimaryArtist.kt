package com.example.lyricsnake.model

import com.google.gson.annotations.SerializedName


data class PrimaryArtist (

    @SerializedName("api_path") val api_path : String,
    @SerializedName("header_image_url") val headerImageUrl : String,
    @SerializedName("id") val id : Int,
    @SerializedName("image_url") val imageUrl : String,
    @SerializedName("is_meme_verified") val isMemeVerified : Boolean,
    @SerializedName("is_verified") val isVerified : Boolean,
    @SerializedName("name") val name : String,
    @SerializedName("url") val url : String,
    @SerializedName("iq") val iq : Int
)
