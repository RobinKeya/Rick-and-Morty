package com.example.rick_and_morty.core

import androidx.paging.PagingState
import com.example.rick_and_morty.feature_characters.data.remote.CharacterApiService
import com.example.rick_and_morty.feature_characters.data.dto.Result
import javax.inject.Inject

class PagingSource @Inject constructor(
    private val apiService: CharacterApiService
): androidx.paging.PagingSource<Int, Result>() {
    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        TODO("Not yet implemented")
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        return try {

            val page = params.key ?: 1
            val response = apiService.getCharacters(page = page)
            LoadResult.Page(
                data = response.results,
                prevKey = if (page == 1) null else page.minus(1),
                nextKey = if (response.results.isEmpty())null else page.plus(1)
            )
        }catch (e: Exception){
            LoadResult.Error(e)
        }
    }
}