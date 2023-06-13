package com.example.rick_and_morty.feature_characters.presentations.characterList

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rick_and_morty.di.MainDispatcher
import com.example.rick_and_morty.feature_characters.domain.models.DomainResult
import com.example.rick_and_morty.feature_characters.domain.usecases.GetAllCharacterUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel @Inject constructor(
    private val getAllCharacterUseCase: GetAllCharacterUseCase,
    @MainDispatcher private val dispatcher: CoroutineDispatcher
): ViewModel() {

    private val _state = mutableStateOf(
        CharacterListScreenState(
        charList = emptyList(),
        isLoading = true,
        error = null))
    val state get() = _state

    private val exception  = CoroutineExceptionHandler { _, throwable ->
        _state.value = _state.value.copy(
            charList = emptyList(),
            isLoading = false,
            error = throwable.localizedMessage
        )
    }

    init {
        viewModelScope.launch(dispatcher + exception) {
            val charList = getCharacters()
            _state.value = _state.value.copy(
                charList = charList,
                isLoading = false
            )
        }

    }
    private suspend fun getCharacters():List<DomainResult>{
        return getAllCharacterUseCase(2)
    }
}