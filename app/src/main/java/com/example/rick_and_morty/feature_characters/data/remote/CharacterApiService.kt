package com.example.rick_and_morty.feature_characters.data.remote

import com.example.rick_and_morty.feature_characters.data.dto.CharacterInfoDto
import com.example.rick_and_morty.feature_characters.data.dto.Result
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface CharacterApiService {
    @GET("character/")
    suspend fun getCharacters():CharacterInfoDto

    @GET("character/{id}")
    suspend fun getCharacter(@Path("id")id: Int): Result
}