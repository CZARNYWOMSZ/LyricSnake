package com.example.lyricsnake.model

import com.google.gson.annotations.SerializedName


data class Annotations (

    @SerializedName("api_path") val apiPath : String,
//    @SerializedName("body") val body : Body,
    @SerializedName("comment_count") val commentCount : Int,
    @SerializedName("community") val community : Boolean,
    @SerializedName("custom_preview") val customPreview : String,
    @SerializedName("has_voters") val hasVoters : Boolean,
    @SerializedName("id") val id : Int,
    @SerializedName("pinned") val pinned : Boolean,
    @SerializedName("share_url") val shareUrl : String,
    @SerializedName("source") val source : String,
    @SerializedName("state") val state : String,
    @SerializedName("url") val url : String,
    @SerializedName("verified") val verified : Boolean,
    @SerializedName("votes_total") val votesTotal : Int,
    @SerializedName("current_user_metadata") val currentUserMetadata : CurrentUserMetadata,
//    @SerializedName("authors") val authors : List<Authors>,
    @SerializedName("cosigned_by") val cosignedBy : List<String>,
    @SerializedName("rejection_comment") val rejectionComment : String,
    @SerializedName("verified_by") val verifiedBy : String
)
