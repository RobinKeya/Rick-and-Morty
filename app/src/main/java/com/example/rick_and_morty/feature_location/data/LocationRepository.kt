package com.example.rick_and_morty.feature_location.data

import com.example.rick_and_morty.feature_location.data.dto.LocationDto

interface LocationRepository {
    suspend fun getLocation(): LocationDto
}