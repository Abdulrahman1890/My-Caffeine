package com.example.mycaffeine.presentation.screens.selectCoffeeScreen

import com.example.mycaffeine.domian.Coffee

data class SelectCoffeeUiState(
    val coffeeList: List<Coffee> = emptyList(),
)