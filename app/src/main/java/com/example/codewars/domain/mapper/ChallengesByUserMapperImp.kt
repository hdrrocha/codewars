package com.example.codewars.domain.mapper

import androidx.paging.PagingData
import androidx.paging.map
import com.example.codewars.data.model.Challenges
import com.example.codewars.domain.mapper.abs.ChallengesByUserMapper
import com.example.codewars.domain.uimodel.ChallengesUi
import com.example.codewars.ui.utils.toDateDisplay

class ChallengesByUserMapperImp : ChallengesByUserMapper {

    override fun map(input: PagingData<Challenges>) = input.map { challenges ->
        ChallengesUi(
            id = challenges.id,
            name = challenges.name?.uppercase(),
            slug = challenges.slug,
            completedLanguages = challenges.completedLanguages.joinToString {
                "${it.uppercase()}"
            },
            completeDate = challenges.completedAt?.toDateDisplay()
        )
    }

}