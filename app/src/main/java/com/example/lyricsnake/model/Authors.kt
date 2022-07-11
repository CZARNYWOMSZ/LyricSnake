package com.example.lyricsnake.model

import com.google.gson.annotations.SerializedName


data class Authors (

//    @SerializedName("attribution") val attribution : Int,
    @SerializedName("pinned_role") val pinnedRole : String,
    @SerializedName("user") val user : User
)
