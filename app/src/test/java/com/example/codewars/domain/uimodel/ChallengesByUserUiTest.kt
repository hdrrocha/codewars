package com.example.codewars.domain.uimodel

import com.example.codewars.helper.BaseUnitTest
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.Test

class ChallengesByUserUiTest : BaseUnitTest() {
    @Test
    fun constructor() = runBlocking {
        val model = ChallengesByUserUi(emptyList())

        Truth.assertThat(model.data).isEmpty()

    }
}