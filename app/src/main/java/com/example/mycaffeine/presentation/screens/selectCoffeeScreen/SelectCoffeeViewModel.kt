package com.example.mycaffeine.presentation.screens.selectCoffeeScreen

import androidx.lifecycle.ViewModel
import com.example.mycaffeine.data.CoffeeDataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SelectCoffeeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(SelectCoffeeUiState())
    val uiState: StateFlow<SelectCoffeeUiState> = _uiState.asStateFlow()

    init {
        getCoffeeList()
    }

    private fun getCoffeeList() {
        _uiState.update { currentState ->
            currentState.copy(coffeeList = CoffeeDataSource.availableCoffee)
        }
    }

}