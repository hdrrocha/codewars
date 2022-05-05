package com.example.codewars.domain.usercase.abs

import com.example.codewars.domain.uimodel.ChallengesDetailsUi

interface ChallengeDetailsUseCase {
    suspend fun getChallengeDetails(id: String): ChallengesDetailsUi
}