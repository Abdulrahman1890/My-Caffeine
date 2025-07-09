package com.example.mycaffeine.presentation.screens.readyOrderScreen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mycaffeine.data.CoffeeDataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ReadyOrderViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {
    private val _uiState = MutableStateFlow(ReadyOrderUiState())
    val uiState: StateFlow<ReadyOrderUiState> = _uiState.asStateFlow()

    private val coffeeId: Int = checkNotNull(savedStateHandle["coffeeId"])

    init {
        prepareCoffee()
    }

    private fun prepareCoffee() {
        viewModelScope.launch {
            val coffee = CoffeeDataSource.availableCoffee.find { it.id == coffeeId }
            _uiState.update { currentState ->
                currentState.copy(selectedCoffee = coffee)
            }
        }
    }

    fun onTakeAwayToggled() {
        _uiState.update { currentState ->
            currentState.copy(isTakeAway = !currentState.isTakeAway)
        }
    }
}