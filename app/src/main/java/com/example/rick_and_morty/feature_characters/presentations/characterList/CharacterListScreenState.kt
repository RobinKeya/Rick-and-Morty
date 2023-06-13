package com.example.rick_and_morty.feature_characters.presentations.characterList

import com.example.rick_and_morty.feature_characters.domain.models.DomainResult

data class CharacterListScreenState(
    val charList : List<DomainResult>,
    val isLoading : Boolean,
    val error : String? = null
)
