package com.example.rick_and_morty.feature_characters.domain

import com.example.rick_and_morty.di.IODispatcher
import com.example.rick_and_morty.feature_characters.data.CharacterRepository
import com.example.rick_and_morty.feature_characters.data.dto.Result
import com.example.rick_and_morty.feature_characters.data.remote.CharacterApiService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CharacterRepositoryImpl @Inject constructor(
    @IODispatcher private val dispatcher: CoroutineDispatcher,
    private val characterApiService: CharacterApiService
): CharacterRepository {
    override suspend fun getCharacters(page: Int): List<Result> {
        return withContext(dispatcher) {
            return@withContext characterApiService.getCharacters(page = page).results
        }
    }

    override suspend fun getCharacter(id: Int): Result {
        return withContext(dispatcher){
            return@withContext characterApiService.getCharacter(id)
        }
    }
}