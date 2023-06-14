package com.example.rick_and_morty.feature_location.data.remote

import com.example.rick_and_morty.feature_location.data.dto.LocationDto
import retrofit2.http.GET

interface LocationApiService {
    @GET("location/")
    suspend fun getLocations(): LocationDto
}