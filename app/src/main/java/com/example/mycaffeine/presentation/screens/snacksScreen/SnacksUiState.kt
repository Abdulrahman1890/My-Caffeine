package com.example.mycaffeine.presentation.screens.snacksScreen

import com.example.mycaffeine.domian.Snacks

data class SnacksUiState(
    val snacks: List<Snacks> = emptyList()
)