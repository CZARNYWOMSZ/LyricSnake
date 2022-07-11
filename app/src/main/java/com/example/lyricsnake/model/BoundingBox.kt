package com.example.lyricsnake.model

import com.google.gson.annotations.SerializedName

data class BoundingBox (

    @SerializedName("width") val width : Int,
    @SerializedName("height") val height : Int
)
