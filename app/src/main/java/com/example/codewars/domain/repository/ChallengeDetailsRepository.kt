package com.example.codewars.domain.repository

import com.example.codewars.data.model.ChallengesDetails

interface ChallengeDetailsRepository {
    suspend fun getChallengeDetails(id: String): ChallengesDetails
}