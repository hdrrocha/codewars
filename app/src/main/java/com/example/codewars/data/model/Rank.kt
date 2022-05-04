package com.example.codewars.data.model

import com.google.gson.annotations.SerializedName

data class Rank(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("color") var color: String? = null

)