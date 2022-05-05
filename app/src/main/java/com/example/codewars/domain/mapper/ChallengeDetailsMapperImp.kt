package com.example.codewars.domain.mapper

import com.example.codewars.data.model.ChallengesDetails
import com.example.codewars.domain.mapper.abs.ChallengeDetailsMapper
import com.example.codewars.domain.uimodel.*
import com.example.codewars.ui.utils.toDateDisplay

class ChallengeDetailsMapperImp : ChallengeDetailsMapper {
    override fun map(input: ChallengesDetails): ChallengesDetailsUi {
        return ChallengesDetailsUi(
            id = input.id,
            name = input.name,
            slug = input.slug,
            category = input.category,
            publishedAt = input.publishedAt?.toDateDisplay(),
            approveDat = input.approvedAt?.toDateDisplay(),
            languages = input.languages.joinToString {
                "${it.uppercase()}"
            },
            url = input.url,
            rank = RankUi(
                id = input.rank?.id,
                name = input.rank?.name,
                color = input.rank?.color
            ),
            createdAt = input.createdAt?.toDateDisplay(),
            createdBy = CreatedByUi(
                username = input.createdBy?.username,
                url = input.createdBy?.url
            ),
            approvedBy = ApprovedByUi(
                username = input.approvedBy?.username,
                url = input.approvedBy?.url
            ),
            description = input.description,
            totalAttempts = input.totalAttempts.toString(),
            totalCompleted = input.totalCompleted.toString(),
            totalStars = input.totalStars.toString(),
            voteScore = input.voteScore.toString(),
            tags = input.tags.joinToString {
                "${it}"
            },
            contributorsWanted = input.contributorsWanted,
            unresolved = UnresolvedUi(
                issues = input.unresolved?.issues.toString(),
                suggestions = input.unresolved?.suggestions.toString()
            )
        )
    }

}