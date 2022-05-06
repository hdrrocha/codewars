package com.example.codewars.domain.uimodel

import com.example.codewars.helper.BaseUnitTest
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.Test

class ChallengesDetailsUiTest : BaseUnitTest() {
    @Test
    fun constructor() = runBlocking {
        val model = ChallengesDetailsUi(
            "id",
            "name",
            "slug",
            "category",
            "publishedAt",
            "approvedAt",
            "languages",
            "url",
            RankUi(
                1,
                "name",
                "color"
            ),
            "createdAt",
            CreatedByUi("username", "url"),
            ApprovedByUi("username", "url"),
            "description",
            "1",
            "2",
            "3",
            "4",
            "tags",
            true,
            UnresolvedUi(
                "1",
                "1"
            )
        )

        Truth.assertThat(model.id).isEqualTo("id")
        Truth.assertThat(model.name).isEqualTo("name")
        Truth.assertThat(model.slug).isEqualTo("slug")
        Truth.assertThat(model.category).isEqualTo("category")
        Truth.assertThat(model.publishedAt).isEqualTo("publishedAt")
        Truth.assertThat(model.approveDat).isEqualTo("approvedAt")
        Truth.assertThat(model.languages).isEqualTo("languages")
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
        Truth.assertThat(model.totalAttempts).isEqualTo("1")
        Truth.assertThat(model.totalCompleted).isEqualTo("2")
        Truth.assertThat(model.totalStars).isEqualTo("3")
        Truth.assertThat(model.voteScore).isEqualTo("4")
        Truth.assertThat(model.tags).isEqualTo("tags")
        Truth.assertThat(model.contributorsWanted).isTrue()
        Truth.assertThat(model.unresolved?.issues).isEqualTo("1")
        Truth.assertThat(model.unresolved?.suggestions).isEqualTo("1")

    }
}
