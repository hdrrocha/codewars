package com.example.codewars.data.model

import com.google.gson.annotations.SerializedName

data class ChallengesDetails(

    @SerializedName("id") var id: String?,
    @SerializedName("name") var name: String?,
    @SerializedName("slug") var slug: String?,
    @SerializedName("category") var category: String?,
    @SerializedName("publishedAt") var publishedAt: String?,
    @SerializedName("approvedAt") var approvedAt: String?,
    @SerializedName("languages") var languages: ArrayList<String>,
    @SerializedName("url") var url: String?,
    @SerializedName("rank") var rank: Rank? ,
    @SerializedName("createdAt") var createdAt: String?,
    @SerializedName("createdBy") var createdBy: CreatedBy?,
    @SerializedName("approvedBy") var approvedBy: ApprovedBy? ,
    @SerializedName("description") var description: String?,
    @SerializedName("totalAttempts") var totalAttempts: Int?,
    @SerializedName("totalCompleted") var totalCompleted: Int?,
    @SerializedName("totalStars") var totalStars: Int?,
    @SerializedName("voteScore") var voteScore: Int?,
    @SerializedName("tags") var tags: ArrayList<String>,
    @SerializedName("contributorsWanted") var contributorsWanted: Boolean?,
    @SerializedName("unresolved") var unresolved: Unresolved?
)