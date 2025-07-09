package com.example.mycaffeine.domian

data class Coffee(
    val id: Int,
    val name: String,
    val images: CoffeeCupImages,
    val availableSizes: List<CoffeeSize>,
    val strengthLevels: List<CoffeeStrength>
)

data class CoffeeSize(
    val cupSize: CupSize,
    val volumeMl: Int,
) {
    enum class CupSize {
        SMALL, MEDIUM, LARGE
    }
}

enum class CoffeeStrength {
    LOW, MEDIUM, HIGH
}