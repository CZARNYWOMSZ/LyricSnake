package com.example.lyricsnake.model

import com.google.gson.annotations.SerializedName


data class IqByAction (

    @SerializedName("accept") val accept : Action,
    @SerializedName("reject") val reject : Action,
    @SerializedName("delete") val delete : Action
)
