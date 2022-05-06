package com.example.codewars.data.model

import com.example.codewars.helper.BaseUnitTest
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.Test

class ChallengesByUserTest : BaseUnitTest() {
    @Test
    fun constructor() = runBlocking {
        val model = ChallengesByUser(1, 1, emptyList())

        Truth.assertThat(model.totalPages).isEqualTo(1)
        Truth.assertThat(model.totalItems).isEqualTo(1)
        Truth.assertThat(model.data).isEmpty()


    }
}