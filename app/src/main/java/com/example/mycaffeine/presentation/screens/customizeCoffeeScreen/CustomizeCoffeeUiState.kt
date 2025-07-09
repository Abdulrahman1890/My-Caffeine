package com.example.mycaffeine.presentation.screens.customizeCoffeeScreen

import com.example.mycaffeine.domian.Coffee
import com.example.mycaffeine.presentation.components.CoffeeSize

data class CustomizeCoffeeUiState(
    val coffee: Coffee? = null,
    val selectedSize: CoffeeSize = CoffeeSize.M,
    val selectedSeedsSize: BeansSize = BeansSize.LOW
) {
    val cupVolume: Int
        get() = when (selectedSize) {
            CoffeeSize.S -> 150
            CoffeeSize.M -> 200
            CoffeeSize.L -> 400
        }

    val cupScale: Float
        get() = when (selectedSize) {
            CoffeeSize.S -> 0.8f
            CoffeeSize.M -> 1.0f
            CoffeeSize.L -> 1.2f
        }

    enum class BeansSize {
        LOW, MEDIUM, HIGH
    }
}