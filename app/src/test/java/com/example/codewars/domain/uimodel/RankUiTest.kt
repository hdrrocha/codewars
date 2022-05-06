package com.example.codewars.domain.uimodel

import com.example.codewars.helper.BaseUnitTest
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.Test

class RankUiTest : BaseUnitTest() {
    @Test
    fun constructor() = runBlocking {
        val model = RankUi(
            1,
            "name",
            "color"
        )

        Truth.assertThat(model.id).isEqualTo(1)
        Truth.assertThat(model.name).isEqualTo("name")
        Truth.assertThat(model.color).isEqualTo("color")
    }
}