package com.example.codewars.data.model

import com.example.codewars.helper.BaseUnitTest
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.Test

class ChallengesTest : BaseUnitTest() {
    @Test
    fun constructor() = runBlocking {
        val model = Challenges(
            "id",
            "name",
            "slug",
            arrayListOf(),
            "completedAt"
        )

        Truth.assertThat(model.id).isEqualTo("id")
        Truth.assertThat(model.name).isEqualTo("name")
        Truth.assertThat(model.slug).isEqualTo("slug")
        Truth.assertThat(model.completedLanguages).isEmpty()
        Truth.assertThat(model.completedAt).isEqualTo("completedAt")


    }
}