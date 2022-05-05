package com.example.codewars.data.api

import com.example.codewars.data.model.ChallengesDetails
import com.example.codewars.data.model.ChallengesByUser
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CodeWarsApi {
    @GET("users/g964/code-challenges/completed")
    suspend fun fetchChallengesByUser(
        @Query("limit") limit: Int = 100,
        @Query("offset") offset: Int = 200
    ): ChallengesByUser

    @GET("code-challenges/{id}")
    suspend fun getChallengeDetails(
        @Path("id") id: String
    ): ChallengesDetails
}