package com.example.mycaffeine.presentation.screens.goodByeScreen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.mycaffeine.data.CoffeeDataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GoodByeViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _uiState = MutableStateFlow(GoodByeUiState())
    val uiState: StateFlow<GoodByeUiState> = _uiState.asStateFlow()

    private val snackId: Int = checkNotNull(savedStateHandle["snackId"])

    init {
        getSnackDetails()
    }

    private fun getSnackDetails() {
        val snack = CoffeeDataSource.availableSnacks.find { it.id == snackId }
        _uiState.update { it.copy(selectedSnack = snack) }
    }
}