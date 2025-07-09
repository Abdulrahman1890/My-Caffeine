package com.example.mycaffeine.presentation.screens.snacksScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mycaffeine.R
import com.example.mycaffeine.presentation.components.CancelButton
import com.example.mycaffeine.presentation.components.SnacksSlider
import com.example.mycaffeine.presentation.navigation.Screen
import com.example.mycaffeine.ui.theme.SecondaryTextColor
import com.example.mycaffeine.ui.theme.Urbanist
import org.koin.androidx.compose.koinViewModel

@Composable
fun SnacksScreen(
    navController: NavController,
    viewModel: SnacksViewModel = koinViewModel()
) {

    val uiState by viewModel.uiState.collectAsState()
    val snacks = uiState.snacks

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 50.dp, start = 16.dp),
        horizontalAlignment = Alignment.Start
    ) {
        CancelButton(
            onClick = {
                navController.navigate(Screen.Home.route) {
                    popUpTo(Screen.Home.route) { inclusive = true }
                }
            },
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = stringResource(R.string.take_your_snack),
            color = SecondaryTextColor,
            fontFamily = Urbanist,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            letterSpacing = 0.25.sp,
        )
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            SnacksSlider(
                pagerState = rememberPagerState(
                    initialPage = 1,
                    initialPageOffsetFraction = 0f,
                    pageCount = { 6 }
                ),
                onSnackSelected = { selectedSnack ->
                    navController.navigate(Screen.Enjoy.createRoute(selectedSnack.id))
                },
                snacks = snacks
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SnacksScreenPreview() {
    SnacksScreen(navController = NavController(LocalContext.current))
}

