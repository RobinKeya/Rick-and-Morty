package com.example.rick_and_morty.feature_characters.presentations.characterDetails

import com.example.rick_and_morty.feature_characters.domain.models.DomainResult

data class CharacterDetailScreenState(
    val charInfo : DomainResult? = null,
    val isLoading : Boolean,
    val error : String? = null
)
