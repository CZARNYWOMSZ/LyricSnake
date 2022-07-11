package com.example.lyricsnake.model

import com.google.gson.annotations.SerializedName


data class ClientTimestamps (

    @SerializedName("updated_by_human_at") val updatedByHumanAt : Int,
    @SerializedName("lyrics_updated_at") val lyricsUpdated_at : Int
)
