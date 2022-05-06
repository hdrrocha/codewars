package com.example.codewars.data.model

import com.example.codewars.helper.BaseUnitTest
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.Test

class UnresolvedTest : BaseUnitTest() {
    @Test
    fun constructor() = runBlocking {
        val model = Unresolved(
            1,
            1
        )

        Truth.assertThat(model.issues).isEqualTo(1)
        Truth.assertThat(model.suggestions).isEqualTo(1)
    }
}