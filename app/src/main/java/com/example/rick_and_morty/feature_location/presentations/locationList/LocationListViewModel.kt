package com.example.rick_and_morty.feature_location.presentations.locationList

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rick_and_morty.di.MainDispatcher
import com.example.rick_and_morty.feature_location.domain.models.DomainResult
import com.example.rick_and_morty.feature_location.domain.useCases.GetAllLocationsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LocationListViewModel @Inject constructor(
    private val getAllLocationsUseCase: GetAllLocationsUseCase,
    @MainDispatcher private val dispatcher: CoroutineDispatcher
): ViewModel(){
    private val _state = mutableStateOf(
        LocationScreenState(
            locations = emptyList(),
            isLoading = true,
            error = null
        )
    )
    val state get() = _state

    private val exception = CoroutineExceptionHandler { _, throwable ->
        _state.value = _state.value.copy(
            locations = emptyList(),
            isLoading = false,
            error = throwable.localizedMessage
        )
    }
    init {
        viewModelScope.launch(dispatcher + exception) {
            val locations = getLocations()
            _state.value = _state.value.copy(
                locations = locations,
                isLoading = false,
                error = null
            )
        }
    }
    private suspend fun getLocations(): List<DomainResult>{
        return getAllLocationsUseCase()
    }
}