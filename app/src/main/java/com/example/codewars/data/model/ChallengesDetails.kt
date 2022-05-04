package com.example.codewars.data.model

import com.google.gson.annotations.SerializedName

data class ChallengesDetails(

    @SerializedName("id") var id: String? = null,
    @SerializedName("name") var name: String? = null,
    @SerializedName("slug") var slug: String? = null,
    @SerializedName("category") var category: String? = null,
    @SerializedName("publishedAt") var publishedAt: String? = null,
    @SerializedName("approvedAt") var approvedAt: String? = null,
    @SerializedName("languages") var languages: ArrayList<String> = arrayListOf(),
    @SerializedName("url") var url: String? = null,
    @SerializedName("rank") var rank: Rank? = Rank(),
    @SerializedName("createdAt") var createdAt: String? = null,
    @SerializedName("createdBy") var createdBy: CreatedBy? = CreatedBy(),
    @SerializedName("approvedBy") var approvedBy: ApprovedBy? = ApprovedBy(),
    @SerializedName("description") var description: String? = null,
    @SerializedName("totalAttempts") var totalAttempts: Int? = null,
    @SerializedName("totalCompleted") var totalCompleted: Int? = null,
    @SerializedName("totalStars") var totalStars: Int? = null,
    @SerializedName("voteScore") var voteScore: Int? = null,
    @SerializedName("tags") var tags: ArrayList<String> = arrayListOf(),
    @SerializedName("contributorsWanted") var contributorsWanted: Boolean? = null,
    @SerializedName("unresolved") var unresolved: Unresolved? = Unresolved()
)