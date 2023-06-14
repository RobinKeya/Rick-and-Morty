package com.example.rick_and_morty.feature_characters.presentations.characterDetails

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rick_and_morty.di.MainDispatcher
import com.example.rick_and_morty.feature_characters.domain.models.DomainResult
import com.example.rick_and_morty.feature_characters.domain.usecases.GetCharacterDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    @MainDispatcher private val dispatcher: CoroutineDispatcher,
    stateHandle: SavedStateHandle,
    private val getCharacterDetailsUseCase: GetCharacterDetailsUseCase
) : ViewModel(){
    private val _state = mutableStateOf(
        CharacterDetailScreenState(
            isLoading = true
        )
    )
    val state get() = _state

    val exception = CoroutineExceptionHandler { _, throwable ->
        _state.value = _state.value.copy(
            error = throwable.localizedMessage,
            isLoading = false
        )
    }
    init {
        viewModelScope.launch(dispatcher+exception ) {
            val id = stateHandle.get<Int?>("id")?:0
            val charInfo = getCharacter(id)
            _state.value = _state.value.copy(
                charInfo = charInfo,
                isLoading = false,
                error = null
            )
        }
    }

    private suspend fun getCharacter(id: Int): DomainResult{
        return getCharacterDetailsUseCase(id)
    }
}