package com.example.lyricsnake.repository.remote

import com.example.lyricsnake.model.ArtistResponse
import com.example.lyricsnake.model.ArtistSongsResponse
import com.example.lyricsnake.model.SearchResponse
import com.example.lyricsnake.model.SongsResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GeniusService {

    @GET("/artists/{artistId}/songs")
    fun getSongs (@Path("artistId")artistId: Int): Single<ArtistSongsResponse>

    @GET("/artists/{artistId}")
    fun getArtist (@Path("artistId") artistId: Int): Single<ArtistResponse>

    @GET("/search")
    fun search (@Query("q") query: String): Single<SearchResponse>
}