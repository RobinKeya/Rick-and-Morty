package com.example.rick_and_morty.feature_characters.data

import com.example.rick_and_morty.feature_characters.data.dto.Result

interface CharacterRepository {
    suspend fun getCharacters(page: Int): List<Result>
    suspend fun getCharacter(id: Int): Result
}