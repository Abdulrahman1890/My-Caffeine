package com.example.mycaffeine.presentation.screens.snacksScreen

import androidx.lifecycle.ViewModel
import com.example.mycaffeine.data.CoffeeDataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SnacksViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(SnacksUiState())
    val uiState: StateFlow<SnacksUiState> = _uiState.asStateFlow()

    init {
        getSnacks()
    }

    private fun getSnacks() {
        _uiState.update { it.copy(snacks = CoffeeDataSource.availableSnacks) }
    }
}