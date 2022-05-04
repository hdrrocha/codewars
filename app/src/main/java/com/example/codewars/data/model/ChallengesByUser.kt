package com.example.codewars.data.model

import com.google.gson.annotations.SerializedName

data class ChallengesByUser(
    @SerializedName("totalPages") var totalPages: Int? = null,
    @SerializedName("totalItems") var totalItems: Int? = null,
    @SerializedName("data") var data: List<Challenges> = arrayListOf()
)