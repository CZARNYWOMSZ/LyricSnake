package com.example.lyricsnake.model

import com.google.gson.annotations.SerializedName

data class SearchResponse (

    @SerializedName("meta") val meta : Meta,
    @SerializedName("response") val response : ResponseSearch
)

data class ResponseSearch (

    @SerializedName("hits") val hits : List<Hits>
)

data class Hits (

    @SerializedName("highlights") val highlights : List<String>,
    @SerializedName("index") val index : String,
    @SerializedName("type") val type : String,
    @SerializedName("result") val result : Result
)

data class Result (

    @SerializedName("annotation_count") val annotationCount : Int,
    @SerializedName("api_path") val apiPath : String,
    @SerializedName("artist_names") val artistNames : String,
    @SerializedName("full_title") val fullTitle : String,
    @SerializedName("header_image_thumbnail_url") val headerImageThumbnailUrl : String,
    @SerializedName("header_image_url") val headerImageUrl : String,
    @SerializedName("id") val id : Int,
    @SerializedName("lyrics_owner_id") val lyricsOwnerId : Int,
    @SerializedName("lyrics_state") val lyricsState : String,
    @SerializedName("path") val path : String,
    @SerializedName("pyongs_count") val pyongsCount : Int,
    @SerializedName("song_art_image_thumbnail_url") val songArtImageThumbnailUrl : String,
    @SerializedName("song_art_image_url") val songArtImageUrl : String,
    @SerializedName("stats") val stats : StatsSearch,
    @SerializedName("title") val title : String,
    @SerializedName("title_with_featured") val titleWithFeatured : String,
    @SerializedName("url") val url : String,
    @SerializedName("primary_artist") val primaryArtist : PrimaryArtist
)

data class StatsSearch (

    @SerializedName("unreviewed_annotations") val unreviewedAnnotations : Int,
    @SerializedName("hot") val hot : Boolean,
    @SerializedName("pageviews") val pageviews : Int
)
