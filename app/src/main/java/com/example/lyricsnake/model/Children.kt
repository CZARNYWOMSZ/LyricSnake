package com.example.lyricsnake.model

import com.google.gson.annotations.SerializedName


data class Children (

    @SerializedName("tag") val tag : String,
    @SerializedName("children") val children : List<String>
)
