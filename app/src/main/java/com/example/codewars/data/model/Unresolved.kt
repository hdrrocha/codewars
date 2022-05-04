package com.example.codewars.data.model

import com.google.gson.annotations.SerializedName

data class Unresolved(
    @SerializedName("issues") var issues: Int? = null,
    @SerializedName("suggestions") var suggestions: Int? = null

)