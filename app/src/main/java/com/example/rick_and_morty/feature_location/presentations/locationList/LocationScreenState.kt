package com.example.rick_and_morty.feature_location.presentations.locationList

import com.example.rick_and_morty.feature_location.domain.models.DomainResult

data class LocationScreenState(
    val locations : List<DomainResult>,
    val isLoading: Boolean,
    val error : String? =null
)
