package com.example.codewars.data.repository

import com.example.codewars.data.api.CodeWarsApi
import com.example.codewars.data.model.ChallengesDetails
import com.example.codewars.domain.repository.ChallengeDetailsRepository

class ChallengeDetailsRepositoryImp(private val api: CodeWarsApi) :
    ChallengeDetailsRepository {
    override suspend fun getChallengeDetails(id: String): ChallengesDetails {
        return api.getChallengeDetails(id)
    }

}