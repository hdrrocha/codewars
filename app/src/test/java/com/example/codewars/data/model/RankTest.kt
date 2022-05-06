package com.example.codewars.data.model

import com.example.codewars.helper.BaseUnitTest
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.Test

class RankTest : BaseUnitTest() {
    @Test
    fun constructor() = runBlocking {
        val model = Rank(
            1,
            "name",
            "color"
        )

        Truth.assertThat(model.id).isEqualTo(1)
        Truth.assertThat(model.name).isEqualTo("name")
        Truth.assertThat(model.color).isEqualTo("color")
    }
}