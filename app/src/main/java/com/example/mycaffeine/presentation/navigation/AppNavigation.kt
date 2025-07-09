package com.example.mycaffeine.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.mycaffeine.presentation.screens.selectCoffeeScreen.SelectCoffeeScreen
import com.example.mycaffeine.presentation.screens.customizeCoffeeScreen.CustomizeCoffeeScreen
import com.example.mycaffeine.presentation.screens.goodByeScreen.GoodByeScreen
import com.example.mycaffeine.presentation.screens.startingScreen.StartingScreen
import com.example.mycaffeine.presentation.screens.readyOrderScreen.ReadyOrderScreen
import com.example.mycaffeine.presentation.screens.preparingOrderScreen.PreparingOrderScreen
import com.example.mycaffeine.presentation.screens.snacksScreen.SnacksScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            StartingScreen(navController)
        }
        composable(Screen.CoffeeSelection.route) {
            SelectCoffeeScreen(navController)
        }
        composable(
            Screen.Details.route,
            arguments = listOf(navArgument("coffeeId") { type = NavType.IntType })
        ) {
            CustomizeCoffeeScreen(navController)
        }
        composable(
            Screen.Processing.route,
            arguments = listOf(
                navArgument("coffeeId") { type = NavType.IntType },
                navArgument("size") { type = NavType.StringType },
                navArgument("volume") { type = NavType.StringType }
            )
        )
        {
            PreparingOrderScreen(navController)
        }

        composable(
            Screen.OrderReady.route,
            arguments = listOf(navArgument("coffeeId") { type = NavType.IntType })
        ) {
            ReadyOrderScreen(navController = navController)
        }

        composable(Screen.SnackSelection.route) {
            SnacksScreen(navController)
        }

        composable(
            Screen.Enjoy.route,
            arguments = listOf(navArgument("snackId") { type = NavType.IntType })) {
            GoodByeScreen(
                navController = navController
            )
        }

    }
}