package com.example.rick_and_morty.feature_location.domain.useCases

import com.example.rick_and_morty.di.IODispatcher
import com.example.rick_and_morty.feature_location.data.LocationRepository
import com.example.rick_and_morty.feature_location.domain.models.DomainResult
import com.example.rick_and_morty.feature_location.domain.models.toDomainResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetAllLocationsUseCase @Inject constructor(
    @IODispatcher private val dispatcher: CoroutineDispatcher,
    private val repository: LocationRepository
) {
    suspend operator fun invoke(): List<DomainResult>{
        return withContext(dispatcher){
            return@withContext repository.getLocation().results.map {
                it.toDomainResult()
            }
        }
    }
}