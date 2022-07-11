package com.example.lyricsnake.repository.local

import com.example.lyricsnake.repository.remote.GeniusService
import javax.inject.Inject

class ArtistRepository @Inject constructor(
    private val geniusService: GeniusService
) {
    fun getArtist (artistId: Int) = geniusService.getArtist(artistId)
}

