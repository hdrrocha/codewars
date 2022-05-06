package com.example.codewars.data.model

import com.example.codewars.helper.BaseUnitTest
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.Test

class CreatedByTest : BaseUnitTest() {
    @Test
    fun constructor() = runBlocking {
        val model = CreatedBy(
            "username",
            "url"
        )

        Truth.assertThat(model.username).isEqualTo("username")
        Truth.assertThat(model.url).isEqualTo("url")
    }
}