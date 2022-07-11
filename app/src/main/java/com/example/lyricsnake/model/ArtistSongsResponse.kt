package com.example.lyricsnake.model

import com.google.gson.annotations.SerializedName

data class ArtistSongsResponse (

    @SerializedName("meta") val meta : Meta,
    @SerializedName("response") val response : ResponseArtistSongs
)

data class ResponseArtistSongs (

    @SerializedName("songs") val songs : List<Songs>,
    @SerializedName("next_page") val nextPage : Int
)

data class Songs (

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
    @SerializedName("stats") val stats : StatsArtistSongs,
    @SerializedName("title") val title : String,
    @SerializedName("title_with_featured") val titleWithFeatured : String,
    @SerializedName("url") val url : String,
    @SerializedName("primary_artist") val primaryArtist : PrimaryArtist
)

data class StatsArtistSongs (

    @SerializedName("unreviewed_annotations") val unreviewedAnnotations : Int,
    @SerializedName("hot") val hot : Boolean,
    @SerializedName("pageviews") val pageViews : Int
)


