package com.example.mycaffeine.presentation.navigation

import com.example.mycaffeine.presentation.components.CoffeeSize

sealed class Screen(val route: String) {
    object Home : Screen("home_screen")
    object CoffeeSelection : Screen("coffee_selection_screen")
    object Details : Screen("details_screen/{coffeeId}") {
        fun route(coffeeId: Int) = "details_screen/$coffeeId"
    }

    object Processing : Screen("processing_screen/{coffeeId}/{size}/{volume}") {
        fun createRoute(coffeeId: Int, size: CoffeeSize, volume: Int) =
            "processing_screen/$coffeeId/$size/$volume"
    }

    object OrderReady : Screen("order_ready_screen/{coffeeId}") {
        fun createRoute(coffeeId: Int) = "order_ready_screen/$coffeeId"
    }

    object SnackSelection : Screen("snack_selection_screen")
    object Enjoy : Screen("enjoy_screen/{snackId}") {
        fun createRoute(snackId: Int) = "enjoy_screen/$snackId"
    }
}