package com.example.lyricsnake.model

import com.google.gson.annotations.SerializedName


data class Primary (

    @SerializedName("multiplier") val multiplier : Int,
    @SerializedName("base") val base : Int,
    @SerializedName("applicable") val applicable : Boolean
)
