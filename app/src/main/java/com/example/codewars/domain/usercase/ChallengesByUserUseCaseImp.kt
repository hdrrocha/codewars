package com.example.codewars.domain.usercase

import com.example.codewars.domain.mapper.abs.ChallengesByUserMapper
import com.example.codewars.domain.repository.ChallengesByUserRepository
import com.example.codewars.domain.usercase.abs.ChallengesByUserUseCase
import kotlinx.coroutines.flow.map

class ChallengesByUserUseCaseImp(
    private val challengesByUserRepository: ChallengesByUserRepository,
    private val mapper: ChallengesByUserMapper
) : ChallengesByUserUseCase {
    override fun fetchChallengesbyUser() =
        challengesByUserRepository.fetchChallengesByUser().map { mapper.map(it) }

}
