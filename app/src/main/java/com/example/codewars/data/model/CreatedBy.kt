package com.example.codewars.data.model

import com.google.gson.annotations.SerializedName

data class CreatedBy(
    @SerializedName("username") var username: String? = null,
    @SerializedName("url") var url: String? = null
)