package com.example.lyricsnake.model

import com.google.gson.annotations.SerializedName

data class ArtistResponse (

    @SerializedName("meta") val meta : Meta,
    @SerializedName("response") val response : ResponseArtist
)

data class ResponseArtist (

    @SerializedName("artist") val artist : Artist
)
