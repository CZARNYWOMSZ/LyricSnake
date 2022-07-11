package com.example.lyricsnake.model

import com.google.gson.annotations.SerializedName

data class Avatar (

    @SerializedName("tiny") val tiny : ImageSize,
    @SerializedName("thumb") val thumb : ImageSize,
    @SerializedName("small") val small : ImageSize,
    @SerializedName("medium") val medium : ImageSize
)