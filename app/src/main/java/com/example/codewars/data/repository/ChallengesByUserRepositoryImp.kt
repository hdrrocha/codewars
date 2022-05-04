package com.example.codewars.data.repository

import androidx.paging.Pager
import com.example.codewars.data.model.Challenges
import com.example.codewars.domain.repository.ChallengesByUserRepository

class ChallengesByUserRepositoryImp(private val pager: Pager<Int, Challenges>) :
    ChallengesByUserRepository {
    companion object {
        const val DEFAULT_LIST_SIZE = 15
    }

    override fun fetchChallengesByUser() = pager.flow
}