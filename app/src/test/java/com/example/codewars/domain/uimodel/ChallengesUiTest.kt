package com.example.codewars.domain.uimodel

import com.example.codewars.helper.BaseUnitTest
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.Test

class ChallengesUiTest : BaseUnitTest() {
    @Test
    fun constructor() = runBlocking {
        val model = ChallengesUi(
            "id",
            "name",
            "slug",
            "completedLanguages",
            "completedAt"
        )

        Truth.assertThat(model.id).isEqualTo("id")
        Truth.assertThat(model.name).isEqualTo("name")
        Truth.assertThat(model.slug).isEqualTo("slug")
        Truth.assertThat(model.completedLanguages).isEqualTo("completedLanguages")
        Truth.assertThat(model.completeDate).isEqualTo("completedAt")

    }
}