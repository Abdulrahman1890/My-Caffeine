package com.example.mycaffeine.presentation.screens.preparingOrderScreen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class PreparingOrderViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {
    val coffeeId: Int = checkNotNull(savedStateHandle["coffeeId"])
    val size: String = checkNotNull(savedStateHandle["size"])
    val volume: String = checkNotNull(savedStateHandle["volume"])
}