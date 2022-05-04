package com.example.codewars.domain.usercase.abs

import androidx.paging.PagingData
import com.example.codewars.data.model.Challenges
import com.example.codewars.domain.uimodel.ChallengesUi
import kotlinx.coroutines.flow.Flow

interface ChallengesByUserUseCase {
    fun fetchChallengesbyUser(): Flow<PagingData<ChallengesUi>>
}
