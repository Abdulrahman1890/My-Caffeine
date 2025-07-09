package com.example.mycaffeine.presentation.screens.preparingOrderScreen

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import com.example.mycaffeine.R
import com.example.mycaffeine.data.CoffeeDataSource
import com.example.mycaffeine.presentation.components.CoffeePreparationStatus
import com.example.mycaffeine.presentation.navigation.Screen
import org.koin.androidx.compose.koinViewModel

@Composable
fun PreparingOrderScreen(
    navController: NavController,
    viewModel: PreparingOrderViewModel = koinViewModel()
) {

    val coffee = CoffeeDataSource.availableCoffee.find { it.id == viewModel.coffeeId }
    val cupImageRes = coffee?.images?.emptyCupImage ?: R.drawable.default_cup
    val volume = viewModel.volume


    val progress = remember { Animatable(0f) }
    LaunchedEffect(key1 = Unit) {
        progress.animateTo(1f, animationSpec = tween(7000))
        navController.navigate(Screen.OrderReady.createRoute(viewModel.coffeeId)) {
            popUpTo(Screen.Processing.route) { inclusive = true }
        }
    }

    CoffeePreparationStatus(
        volumeMl = "$volume ML",
        cupImage = cupImageRes,
        progress = progress.value
    )
}