package com.example.codewars.data.model

import com.google.gson.annotations.SerializedName

data class ApprovedBy(
    @SerializedName("username") var username: String? = null,
    @SerializedName("url") var url: String? = null

)