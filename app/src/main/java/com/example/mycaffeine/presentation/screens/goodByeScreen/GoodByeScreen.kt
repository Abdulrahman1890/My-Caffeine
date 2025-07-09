package com.example.mycaffeine.presentation.screens.goodByeScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mycaffeine.R
import com.example.mycaffeine.presentation.components.CancelButton
import com.example.mycaffeine.presentation.components.CustomButton
import com.example.mycaffeine.presentation.components.QuoteText
import com.example.mycaffeine.presentation.components.SnackConfirmation
import com.example.mycaffeine.presentation.navigation.Screen
import org.koin.androidx.compose.koinViewModel

@Composable
fun GoodByeScreen(
    navController: NavController,
    viewModel: GoodByeViewModel = koinViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()
    val snack = uiState.selectedSnack

    val onFinish = {
        navController.navigate(Screen.Home.route) {
            popUpTo(Screen.Home.route) { inclusive = true }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CancelButton(
            onClick = onFinish,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 16.dp)
        )
        Spacer(modifier = Modifier.height(24.dp))
        QuoteText(modifier = Modifier.padding(horizontal = 8.dp))
        Spacer(modifier = Modifier.height(24.dp))
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
        ) {
            SnackConfirmation(
                snack!!.imageRes,
                modifier = Modifier
                    .padding(horizontal = 30.dp)
            )
        }
        CustomButton(
            modifier = Modifier
                .padding(bottom = 50.dp),
            text = stringResource(R.string.thank_youuu),
            onClickNext = onFinish
        )
    }
}