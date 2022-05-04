package com.example.codewars.data.source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.codewars.data.api.CodeWarsApi
import com.example.codewars.data.model.Challenges
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext


class ChallengesByUserPagingSource(val api: CodeWarsApi) : PagingSource<Int, Challenges>() {

    companion object {
        const val INITIAL_START = 1
    }

    override fun getRefreshKey(state: PagingState<Int, Challenges>) = state.anchorPosition?.let {
        state.closestPageToPosition(it)?.prevKey
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Challenges> {
        val start = params.key?.let { it + INITIAL_START } ?: INITIAL_START
        val limit = params.key?.let { it + params.loadSize } ?: params.loadSize

        val data = withContext(Dispatchers.IO) { api.fetchChallengesByUser(start, limit) }

        return LoadResult.Page(
            data.data.orEmpty(),
            prevKey = if (start == INITIAL_START) null else start,
            nextKey = limit
        )
    }
}
