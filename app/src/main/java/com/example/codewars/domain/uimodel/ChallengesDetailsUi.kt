package com.example.codewars.domain.uimodel

data class ChallengesDetailsUi(
    var id: String?,
    var name: String?,
    var slug: String?,
    var category: String?,
    var publishedAt: String?,
    var approveDat: String?,
    var languages: String?,
    var url: String?,
    var rank: RankUi?,
    var createdAt: String?,
    var createdBy: CreatedByUi?,
    var approvedBy: ApprovedByUi?,
    var description: String?,
    var totalAttempts: String?,
    var totalCompleted: String?,
    var totalStars: String?,
    var voteScore: String?,
    var tags: String?,
    var contributorsWanted: Boolean?,
    var unresolved: UnresolvedUi?
)