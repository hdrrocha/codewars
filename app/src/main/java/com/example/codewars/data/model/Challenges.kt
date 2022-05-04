package com.example.codewars.data.model

import com.google.gson.annotations.SerializedName

data class Challenges(
    @SerializedName("id") var id: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("slug") var slug: String? = null,
    @SerializedName("completedLanguages") var completedLanguages: ArrayList<String> = arrayListOf(),
    @SerializedName("completedAt") var completedAt: String? = null

)