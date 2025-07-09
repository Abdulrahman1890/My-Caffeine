package com.example.mycaffeine.presentation.screens.readyOrderScreen

import com.example.mycaffeine.domian.Coffee

data class ReadyOrderUiState(
    val selectedCoffee: Coffee? = null,
    val isTakeAway: Boolean = false
)