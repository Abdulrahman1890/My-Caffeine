package com.example.mycaffeine.data

import com.example.mycaffeine.R
import com.example.mycaffeine.domian.Coffee
import com.example.mycaffeine.domian.CoffeeCupImages
import com.example.mycaffeine.domian.CoffeeSize
import com.example.mycaffeine.domian.CoffeeStrength
import com.example.mycaffeine.domian.Snacks

object CoffeeDataSource {

    private val standardSizes = listOf(
        CoffeeSize(CoffeeSize.CupSize.SMALL, 150),
        CoffeeSize(CoffeeSize.CupSize.MEDIUM, 200),
        CoffeeSize(CoffeeSize.CupSize.LARGE, 400)
    )

    private val standardStrengthLevels = listOf(
        CoffeeStrength.LOW,
        CoffeeStrength.MEDIUM,
        CoffeeStrength.HIGH
    )

    val availableCoffee = listOf(
        Coffee(
            id = 1,
            name = "Espresso",
            images = CoffeeCupImages(
                R.drawable.espresso_coffee,
                R.drawable.espresso_top_cover,
                R.drawable.espresso_top,
                R.drawable.espresso_empty_cup
            ),
            availableSizes = standardSizes,
            strengthLevels = standardStrengthLevels
        ),
        Coffee(
            id = 2,
            name = "Macchiato",
            images = CoffeeCupImages(
                R.drawable.macchiato_coffee,
                R.drawable.macchiato_top_cover,
                R.drawable.macchiato_top,
                R.drawable.macchiato_empty_cup,
            ),
            availableSizes = standardSizes,
            strengthLevels = standardStrengthLevels
        ),
        Coffee(
            id = 3,
            name = "Latte",
            images = CoffeeCupImages(
                R.drawable.latte_coffee,
                R.drawable.latte_top_cover,
                R.drawable.latte_top,
                R.drawable.latte_empty_cup
            ),
            availableSizes = standardSizes,
            strengthLevels = standardStrengthLevels
        ),
        Coffee(
            id = 4,
            name = "Black",
            images = CoffeeCupImages(
                R.drawable.black_coffee,
                R.drawable.black_cover,
                R.drawable.black_top,
                R.drawable.latte_empty_cup
            ),
            availableSizes = standardSizes,
            strengthLevels = standardStrengthLevels
        )
    )

    val availableSnacks = listOf(
        Snacks(1, "Chocolate Muffin", R.drawable.chocolate_chips),
        Snacks(2, "Cupcake", R.drawable.cupcake),
        Snacks(3, "Cookies", R.drawable.cookies),
        Snacks(4, "Cinnamon Roll", R.drawable.cinnamon_roll),
        Snacks(5, "Croissant", R.drawable.croissant),
        Snacks(6, "Oreo", R.drawable.oreo)
    )
}