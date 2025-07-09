package com.example.mycaffeine.presentation.screens.customizeCoffeeScreen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.mycaffeine.data.CoffeeDataSource
import com.example.mycaffeine.presentation.components.CoffeeSize
import com.example.mycaffeine.presentation.screens.customizeCoffeeScreen.CustomizeCoffeeUiState.BeansSize
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class CustomizeCoffeeViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {

    private val _uiState = MutableStateFlow(CustomizeCoffeeUiState())
    val uiState: StateFlow<CustomizeCoffeeUiState> = _uiState.asStateFlow()

    private val coffeeId: Int = checkNotNull(savedStateHandle["coffeeId"])

    init {
        loadCoffeeDetails()
    }

    private fun loadCoffeeDetails() {
        val coffee = CoffeeDataSource.availableCoffee.find { it.id == coffeeId }
        coffee?.let {
            _uiState.update { currentState ->
                currentState.copy(
                    coffee = it,
                    selectedSize = CoffeeSize.M,
                    selectedSeedsSize = BeansSize.LOW
                )
            }
        }
    }

    fun updateSelectedSize(size: CoffeeSize) {
        _uiState.update { it.copy(selectedSize = size) }
    }

    fun updateSeedsSize(size: BeansSize) {
        _uiState.update { it.copy(selectedSeedsSize = size) }
    }
}
