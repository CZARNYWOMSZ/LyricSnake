package com.example.lyricsnake.model

import com.google.gson.annotations.SerializedName


data class Dom (

    @SerializedName("tag") val tag : String,
    @SerializedName("children") val children : List<Children>
)
