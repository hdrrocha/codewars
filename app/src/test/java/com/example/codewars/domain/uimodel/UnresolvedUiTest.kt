package com.example.codewars.domain.uimodel

import com.example.codewars.helper.BaseUnitTest
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.Test

class UnresolvedUiTest : BaseUnitTest() {
    @Test
    fun constructor() = runBlocking {
        val model = UnresolvedUi(
            "1",
            "1"
        )

        Truth.assertThat(model.issues).isEqualTo("1")
        Truth.assertThat(model.suggestions).isEqualTo("1")
    }
}