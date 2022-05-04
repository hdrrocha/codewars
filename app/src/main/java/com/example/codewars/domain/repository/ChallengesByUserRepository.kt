package com.example.codewars.domain.repository

import androidx.paging.PagingData
import com.example.codewars.data.model.Challenges
import kotlinx.coroutines.flow.Flow

interface ChallengesByUserRepository {
    fun fetchChallengesByUser(): Flow<PagingData<Challenges>>
}