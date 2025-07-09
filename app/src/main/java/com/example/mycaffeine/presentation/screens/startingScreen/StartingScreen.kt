package com.example.mycaffeine.presentation.screens.startingScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mycaffeine.R
import com.example.mycaffeine.presentation.components.AnimatedGhost
import com.example.mycaffeine.presentation.components.AppHeader
import com.example.mycaffeine.presentation.components.CustomButton
import com.example.mycaffeine.presentation.components.HocusPocus
import com.example.mycaffeine.presentation.navigation.Screen

@Composable
fun StartingScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .padding(top = 50.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AppHeader()
        HocusPocus()
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            AnimatedGhost()
        }
        CustomButton(
            text = stringResource(R.string.bring_my_coffee),
            icon = R.drawable.coffee_cup_icon,
            modifier = Modifier
                .padding(bottom = 50.dp),
            onClickNext = { navController.navigate(Screen.CoffeeSelection.route) },
        )
    }
}