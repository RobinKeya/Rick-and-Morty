package com.example.rick_and_morty.feature_location.domain

import com.example.rick_and_morty.di.IODispatcher
import com.example.rick_and_morty.feature_location.data.LocationRepository
import com.example.rick_and_morty.feature_location.data.dto.LocationDto
import com.example.rick_and_morty.feature_location.data.remote.LocationApiService
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LocationRepositoryImpl @Inject constructor(
    @IODispatcher private val dispatcher : CoroutineDispatcher,
    private val apiService: LocationApiService
): LocationRepository {
    override suspend fun getLocation(): LocationDto {
        return withContext(dispatcher){
            return@withContext apiService.getLocations()
        }
    }
}