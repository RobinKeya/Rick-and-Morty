package com.example.rick_and_morty.feature_characters.domain.usecases
import com.example.rick_and_morty.di.IODispatcher
import com.example.rick_and_morty.feature_characters.data.CharacterRepository
import com.example.rick_and_morty.feature_characters.domain.models.DomainResult
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetAllCharacterUseCase @Inject constructor(
    private val repository: CharacterRepository,
    @IODispatcher private val dispatcher: CoroutineDispatcher
) {
    suspend operator fun invoke(page: Int): List<DomainResult> {
        return withContext(dispatcher) {
            return@withContext repository.getCharacters(page).map {
                DomainResult(
                    episode = it.episode,
                    gender = it.gender,
                    id = it.id,
                    image = it.image,
                    name = it.name,
                    status = it.status,
                    species = it.species
                    //location = it.location,
                    //origin = it.origin.let { name = it.name,url = it.url }
                )
            }
        }
    }
}