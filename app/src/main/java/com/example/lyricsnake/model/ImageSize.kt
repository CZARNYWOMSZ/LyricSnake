package com.example.lyricsnake.model

import com.google.gson.annotations.SerializedName


data class ImageSize (

    @SerializedName("url") val url : String,
    @SerializedName("bounding_box") val boundingBox : BoundingBox
)
