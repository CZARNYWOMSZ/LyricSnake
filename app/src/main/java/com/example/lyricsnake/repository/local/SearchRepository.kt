package com.example.lyricsnake.repository.local

import com.example.lyricsnake.repository.remote.GeniusService
import javax.inject.Inject

class SearchRepository @Inject constructor(
    private val geniusService: GeniusService
) {
    fun search (query: String) = geniusService.search(query)
}