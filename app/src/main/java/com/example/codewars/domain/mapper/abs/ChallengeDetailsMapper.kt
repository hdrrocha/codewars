package com.example.codewars.domain.mapper.abs

import com.example.codewars.data.model.ChallengesDetails
import com.example.codewars.domain.uimodel.ChallengesDetailsUi

interface ChallengeDetailsMapper {
    fun map(input: ChallengesDetails): ChallengesDetailsUi
}