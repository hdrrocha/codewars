package com.example.codewars.domain.usercase

import com.example.codewars.domain.mapper.abs.ChallengeDetailsMapper
import com.example.codewars.domain.repository.ChallengeDetailsRepository
import com.example.codewars.domain.uimodel.ChallengesDetailsUi
import com.example.codewars.domain.usercase.abs.ChallengeDetailsUseCase

class ChallengeDetailsUseCaseImp(
    private val challengeDetailsRepository: ChallengeDetailsRepository,
    private val mapper: ChallengeDetailsMapper
) : ChallengeDetailsUseCase {
    override suspend fun getChallengeDetails(id: String): ChallengesDetailsUi {
        return mapper.map(challengeDetailsRepository.getChallengeDetails(id))
    }

}