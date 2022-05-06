package com.example.codewars.data.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.paging.Pager
import androidx.paging.PagingData
import com.example.codewars.data.model.Challenges
import com.example.codewars.domain.repository.ChallengesByUserRepository
import com.example.codewars.helper.ChallengesByUserFactory
import com.example.codewars.helper.CoroutinesTestRule
import com.example.codewars.helper.PagingDataTest
import com.google.common.truth.Truth.assertThat
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.singleOrNull
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ChallengesByUserRepositoryImpTest : PagingDataTest() {

    @get:Rule
    val instantTaskExecutor = InstantTaskExecutorRule()

    @get:Rule
    @ExperimentalCoroutinesApi
    val coroutineRule = CoroutinesTestRule()

    @MockK
    private lateinit var mockPager: Pager<Int, Challenges>

    private lateinit var sut: ChallengesByUserRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        sut = ChallengesByUserRepositoryImp(pager = mockPager)
    }

    @Test
    fun fetchImagesSuccessTest() = runBlocking {
        val expected = ChallengesByUserFactory.characterList
        every { mockPager.flow }.returns(flowOf(PagingData.from(expected)))

        sut.fetchChallengesByUser().collect {
            val actual = getDifferSnapshot(it)

            assertThat(actual).isNotEmpty()
            assertThat(actual.items).isNotEmpty()
            assertThat(actual.items).isEqualTo(expected)
        }
    }

    @Test
    fun fetchImagesErrorTest() = runBlocking {
        every { mockPager.flow }.returns(flowOf(PagingData.empty()))

        val data = sut.fetchChallengesByUser().singleOrNull()
        val actual = getDifferSnapshot(data!!)

        assertThat(actual).isEmpty()
    }
}
