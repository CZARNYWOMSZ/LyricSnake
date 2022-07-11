package com.example.lyricsnake.model

import com.google.gson.annotations.SerializedName

data class CurrentUserMetadata (

    @SerializedName("permissions") val permissions : List<String>,
    @SerializedName("excluded_permissions") val excludedPermissions : List<String>,
    @SerializedName("interactions") val interactions : Interactions,
    @SerializedName("iq_by_action") val iqByAction : IqByAction
)
