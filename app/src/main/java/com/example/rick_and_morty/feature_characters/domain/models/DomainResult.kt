package com.example.rick_and_morty.feature_characters.domain.models


data class DomainResult(
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
   // val location: Location,
    val name: String,
    //val origin: Origin,
    val species: String,
    val status: String,
)