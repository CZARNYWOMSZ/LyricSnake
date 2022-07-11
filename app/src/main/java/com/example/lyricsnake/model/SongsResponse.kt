package com.example.lyricsnake.model

import com.google.gson.annotations.SerializedName

data class SongsResponse (

    @SerializedName("meta") val meta : Meta,
    @SerializedName("response") val response : ResponseSongs
)

data class ResponseSongs (

    @SerializedName("song") val song : Song
)

data class Song (

    @SerializedName("annotation_count") val annotationCount : Int,
    @SerializedName("api_path") val apiPath : String,
    @SerializedName("apple_music_id") val appleMusicId : Int,
    @SerializedName("apple_music_player_url") val appleMusicPlayerUrl : String,
    @SerializedName("artist_names") val artistNames : String,
    @SerializedName("description") val description : Description,
    @SerializedName("embed_content") val embedContent : String,
    @SerializedName("featured_video") val featuredVideo : Boolean,
    @SerializedName("full_title") val fullTitle : String,
    @SerializedName("header_image_thumbnail_url") val headerImageThumbnailUrl : String,
    @SerializedName("header_image_url") val headerImageUrl : String,
    @SerializedName("id") val id : Int,
    @SerializedName("lyrics_owner_id") val lyricsOwnerId : Int,
    @SerializedName("lyrics_placeholder_reason") val lyricsPlaceholderReason : String,
    @SerializedName("lyrics_state") val lyricsState : String,
    @SerializedName("path") val path : String,
    @SerializedName("pyongs_count") val pyongsCount : Int,
    @SerializedName("recording_location") val recordingLocation : String,
    @SerializedName("release_date") val releaseDate : String,
    @SerializedName("release_date_for_display") val releaseDateForDisplay : String,
    @SerializedName("song_art_image_thumbnail_url") val songArtImageThumbnailUrl : String,
    @SerializedName("song_art_image_url") val songArtImageUrl : String,
    @SerializedName("stats") val stats : StatsSongs,
    @SerializedName("title") val title : String,
    @SerializedName("title_with_featured") val titleWithFeatured : String,
    @SerializedName("url") val url : String,
    @SerializedName("current_user_metadata") val currentUserMetadata : CurrentUserMetadata,
    @SerializedName("album") val album : Album,
    @SerializedName("custom_performances") val customPerformances : List<CustomPerformances>,
    @SerializedName("description_annotation") val descriptionAnnotation : DescriptionAnnotation,
    @SerializedName("featured_artists") val featuredArtists : List<String>,
    @SerializedName("lyrics_marked_complete_by") val lyricsMarkedCompleteBy : String,
    @SerializedName("media") val media : List<Media>,
    @SerializedName("primary_artist") val primaryArtist : PrimaryArtist,
    @SerializedName("producer_artists") val producerArtists : List<ProducerArtists>,
    @SerializedName("song_relationships") val songRelationships : List<SongRelationships>,
    @SerializedName("verified_annotations_by") val verifiedAnnotationsBy : List<String>,
    @SerializedName("verified_contributors") val verifiedContributors : List<String>,
    @SerializedName("verified_lyrics_by") val verifiedLyricsBy : List<String>,
    @SerializedName("writer_artists") val writerArtists : List<WriterArtists>
)

data class StatsSongs (

    @SerializedName("accepted_annotations") val acceptedAnnotations : Int,
    @SerializedName("contributors") val contributors : Int,
    @SerializedName("iq_earners") val iqEarners : Int,
    @SerializedName("transcribers") val transcribers : Int,
    @SerializedName("unreviewed_annotations") val unreviewedAnnotations : Int,
    @SerializedName("verified_annotations") val verifiedAnnotations : Int,
    @SerializedName("hot") val hot : Boolean,
    @SerializedName("pageviews") val pageviews : Int
)

data class Album (

    @SerializedName("api_path") val apiPath : String,
    @SerializedName("cover_art_url") val coverArtUrl : String,
    @SerializedName("full_title") val fullTitle : String,
    @SerializedName("id") val id : Int,
    @SerializedName("name") val name : String,
    @SerializedName("url") val url : String,
    @SerializedName("artist") val artist : Artist
)

data class CustomPerformances (

    @SerializedName("label") val label : String,
    @SerializedName("artists") val artists : List<Artists>
)

data class Artists (

    @SerializedName("api_path") val apiPath : String,
    @SerializedName("header_image_url") val headerImageUrl : String,
    @SerializedName("id") val id : Int,
    @SerializedName("image_url") val imageUrl : String,
    @SerializedName("is_meme_verified") val isMemeVerified : Boolean,
    @SerializedName("is_verified") val is_verified : Boolean,
    @SerializedName("name") val name : String,
    @SerializedName("url") val url : String
)

data class Media (

    @SerializedName("provider") val provider : String,
    @SerializedName("start") val start : Int,
    @SerializedName("type") val type : String,
    @SerializedName("url") val url : String
)

data class ProducerArtists (

    @SerializedName("api_path") val apiPath : String,
    @SerializedName("header_image_url") val headerImageUrl : String,
    @SerializedName("id") val id : Int,
    @SerializedName("image_url") val imageUrl : String,
    @SerializedName("is_meme_verified") val isMemeVerified : Boolean,
    @SerializedName("is_verified") val isVerified : Boolean,
    @SerializedName("name") val name : String,
    @SerializedName("url") val url : String
)

data class SongRelationships (

    @SerializedName("relationship_type") val relationshipType : String,
    @SerializedName("type") val type : String,
    @SerializedName("songs") val songs : List<String>
)

data class WriterArtists (

    @SerializedName("api_path") val apiPath : String,
    @SerializedName("header_image_url") val headerImageUrl : String,
    @SerializedName("id") val id : Int,
    @SerializedName("image_url") val imageUrl : String,
    @SerializedName("is_meme_verified") val isMemeVerified : Boolean,
    @SerializedName("is_verified") val isVerified : Boolean,
    @SerializedName("name") val name : String,
    @SerializedName("url") val url : String
)
