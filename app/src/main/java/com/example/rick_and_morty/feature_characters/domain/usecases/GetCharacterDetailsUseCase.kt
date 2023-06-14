package com.example.rick_and_morty.feature_characters.domain.usecases

import com.example.rick_and_morty.di.IODispatcher
import com.example.rick_and_morty.feature_characters.data.CharacterRepository
import com.example.rick_and_morty.feature_characters.domain.models.DomainResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetCharacterDetailsUseCase @Inject constructor(
    private val repository: CharacterRepository,
    @IODispatcher private val dispatcher: CoroutineDispatcher
) {
    suspend operator fun invoke(id: Int): DomainResult{
        return withContext(dispatcher){
            return@withContext repository.getCharacter(id).let {
                DomainResult(
                    episode = it.episode,
                    id = it.id,
                    gender = it.gender,
                    image = it.image,
                    name = it.name,
                    species = it.species,
                    status = it.status
                )
            }
        }
    }
}