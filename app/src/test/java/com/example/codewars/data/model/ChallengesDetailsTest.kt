package com.example.codewars.data.model

import com.example.codewars.helper.BaseUnitTest
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.Test

class ChallengesDetailsTest : BaseUnitTest() {
    @Test
    fun constructor() = runBlocking {
        val model = ChallengesDetails(
            "id",
            "name",
            "slug",
            "category",
            "publishedAt",
            "approvedAt",
            emptyList(),
            "url",
            Rank(
                1,
                "name",
                "color"
            ),
            "createdAt",
            CreatedBy("username", "url"),
            ApprovedBy("username", "url"),
            "description",
            1,
            2,
            3,
            4,
            emptyList(),
            true,
            Unresolved(
                1,
                1
            )
        )

        Truth.assertThat(model.id).isEqualTo("id")
        Truth.assertThat(model.name).isEqualTo("name")
        Truth.assertThat(model.slug).isEqualTo("slug")
        Truth.assertThat(model.category).isEqualTo("category")
        Truth.assertThat(model.publishedAt).isEqualTo("publishedAt")
        Truth.assertThat(model.approvedAt).isEqualTo("approvedAt")
        Truth.assertThat(model.languages).isEmpty()
        Truth.assertThat(model.url).isEqualTo("url")
        Truth.assertThat(model.rank?.id).isEqualTo(1)
        Truth.assertThat(model.rank?.name).isEqualTo("name")
        Truth.assertThat(model.rank?.color).isEqualTo("color")
        Truth.assertThat(model.createdAt).isEqualTo("createdAt")
        Truth.assertThat(model.createdBy?.username).isEqualTo("username")
        Truth.assertThat(model.createdBy?.url).isEqualTo("url")
        Truth.assertThat(model.approvedBy?.username).isEqualTo("username")
        Truth.assertThat(model.approvedBy?.url).isEqualTo("url")
        Truth.assertThat(model.description).isEqualTo("description")
        Truth.assertThat(model.totalAttempts).isEqualTo(1)
        Truth.assertThat(model.totalCompleted).isEqualTo(2)
        Truth.assertThat(model.totalStars).isEqualTo(3)
        Truth.assertThat(model.voteScore).isEqualTo(4)
        Truth.assertThat(model.tags).isEmpty()
        Truth.assertThat(model.contributorsWanted).isTrue()
        Truth.assertThat(model.unresolved?.issues).isEqualTo(1)
        Truth.assertThat(model.unresolved?.suggestions).isEqualTo(1)

    }
}