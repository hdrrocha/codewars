package com.example.codewars.domain.mapper.abs

import androidx.paging.PagingData
import com.example.codewars.data.model.Challenges
import com.example.codewars.domain.uimodel.ChallengesUi

interface ChallengesByUserMapper {
    fun map(input: PagingData<Challenges>): PagingData<ChallengesUi>
}