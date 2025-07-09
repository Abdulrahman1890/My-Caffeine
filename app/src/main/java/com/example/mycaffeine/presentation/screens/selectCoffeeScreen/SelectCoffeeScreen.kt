package com.example.mycaffeine.presentation.screens.selectCoffeeScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mycaffeine.presentation.components.AppHeader
import com.example.mycaffeine.presentation.components.CoffeeCupsSlider
import com.example.mycaffeine.presentation.components.CustomButton
import com.example.mycaffeine.presentation.components.WelcomeMessage
import com.example.mycaffeine.presentation.navigation.Screen
import org.koin.androidx.compose.koinViewModel

@Composable
fun SelectCoffeeScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: SelectCoffeeViewModel = koinViewModel()
) {

    val uiState by viewModel.uiState.collectAsState()
    val coffees = uiState.coffeeList
    val pagerState = rememberPagerState(pageCount = { coffees.size })

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppHeader()
        Spacer(modifier = Modifier.height(16.dp))
        WelcomeMessage()
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            CoffeeCupsSlider(
                coffeeItems = coffees,
                pagerState = pagerState
            )
        }
        CustomButton(
            modifier = Modifier
                .padding(bottom = 50.dp),
            onClickNext = {
                val selectedCoffeeId = coffees[pagerState.currentPage].id
                navController.navigate(Screen.Details.route(selectedCoffeeId))
            }
        )
    }
}