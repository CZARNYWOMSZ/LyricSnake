package com.example.lyricsnake.repository.local

import com.example.lyricsnake.repository.remote.GeniusService
import javax.inject.Inject

class SongRepository @Inject constructor(
    private val geniusService: GeniusService
) {
    fun getSongs (artistId: Int) = geniusService.getSongs(artistId)
}