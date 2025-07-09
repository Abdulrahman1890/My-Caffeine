package com.example.mycaffeine.presentation.screens.customizeCoffeeScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mycaffeine.presentation.components.CoffeeBeansSizeButtons
import com.example.mycaffeine.presentation.components.CoffeeSize
import com.example.mycaffeine.presentation.components.CoffeeSizeSelector
import com.example.mycaffeine.presentation.components.CoffeeStrength
import com.example.mycaffeine.presentation.components.CustomButton
import com.example.mycaffeine.presentation.components.SizeSelectorHeader
import com.example.mycaffeine.presentation.navigation.Screen
import com.example.mycaffeine.presentation.screens.customizeCoffeeScreen.CustomizeCoffeeUiState.BeansSize
import org.koin.androidx.compose.koinViewModel

@Composable
fun CustomizeCoffeeScreen(
    navController: NavController,
    viewModel: CustomizeCoffeeViewModel = koinViewModel()
) {

    val state by viewModel.uiState.collectAsState()

    SelectSize(
        selectedSize = state.selectedSize,
        cupVolume = state.cupVolume,
        cupScale = state.cupScale,
        onSizeSelected = { viewModel.updateSelectedSize(it) },
        onClickNext = {
            navController.navigate(
                Screen.Processing.createRoute(
                    state.coffee!!.id,
                    state.selectedSize,
                    state.cupVolume
                )
            )
        },
        onClickPrevious = { navController.popBackStack() },
        drinkName = state.coffee?.name ?: "",
        selectedSeedsSize = state.selectedSeedsSize,
        onSeedsSelected = { viewModel.updateSeedsSize(it) }
    )
}


@Composable
private fun SelectSize(
    selectedSize: CoffeeSize,
    cupVolume: Int,
    cupScale: Float,
    onSizeSelected: (CoffeeSize) -> Unit,
    onClickNext: () -> Unit,
    onClickPrevious: () -> Unit,
    drinkName: String,
    selectedSeedsSize: BeansSize,
    onSeedsSelected: (BeansSize) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(top = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            SizeSelectorHeader(onClickPrevious, drinkName)
            Spacer(modifier = Modifier.height(16.dp))

            CoffeeStrength(
                volumeMl = cupVolume,
                cupSize = cupScale,
                selectedStrength = selectedSeedsSize
            )

            CoffeeSizeSelector(
                selectedSize = selectedSize,
                onSizeSelected = onSizeSelected,
            )

            Spacer(modifier = Modifier.height(16.dp))

            CoffeeBeansSizeButtons(
                selectedStrength = selectedSeedsSize,
                onStrengthSelected = onSeedsSelected,
                modifier = Modifier.padding(top = 16.dp)
            )
        }

        CustomButton(
            onClickNext = onClickNext,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 50.dp)
        )
    }
}
