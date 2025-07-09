package com.example.mycaffeine.presentation.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycaffeine.R
import com.example.mycaffeine.presentation.screens.customizeCoffeeScreen.CustomizeCoffeeUiState.BeansSize
import com.example.mycaffeine.ui.theme.LabelColor
import com.example.mycaffeine.ui.theme.Urbanist

@Composable
fun CoffeeStrength(
    volumeMl: Int,
    cupSize: Float,
    selectedStrength: BeansSize,
    modifier: Modifier = Modifier
) {
    val animatedCupScale by animateFloatAsState(
        targetValue = cupSize,
        animationSpec = tween(durationMillis = 300),
        label = stringResource(R.string.cupscale)
    )

    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "$volumeMl ML",
            color = LabelColor,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = Urbanist,
            letterSpacing = .25.sp,
            lineHeight = 14.sp,
            modifier = Modifier
                .padding(start = 16.dp, top = 64.dp)
                .align(Alignment.TopStart)
        )

        Box(
            modifier = Modifier
                .padding(top = 49.dp, bottom = 48.dp)
                .wrapContentSize()
                .scale(animatedCupScale),
            contentAlignment = Alignment.Center
        ) {
            AnimatedCoffeeBeans(selectedStrength = selectedStrength)

            Image(
                painter = painterResource(id = R.drawable.default_cup),
                contentDescription = stringResource(R.string.coffee_cup),
                modifier = Modifier.size(199.4.dp, 244.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.brand_logo),
                contentDescription = stringResource(R.string.cup_icon),
                modifier = Modifier
                    .align(Alignment.Center)
                    .size(66.dp)
            )
        }
    }
}

@Composable
private fun AnimatedCoffeeBeans(
    selectedStrength: BeansSize,
    modifier: Modifier = Modifier
) {
    val isLowStrength = selectedStrength == BeansSize.LOW
    val isMediumStrength = selectedStrength == BeansSize.MEDIUM
    val isHighStrength = selectedStrength == BeansSize.HIGH

    Box(
        modifier = modifier.height(230.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        AnimatedCoffeeBeanLayer(
            isVisible = isLowStrength || isMediumStrength || isHighStrength,
            animationDelay = 0,
            exitDelay = 400
        )

        AnimatedCoffeeBeanLayer(
            isVisible = isMediumStrength || isHighStrength,
            animationDelay = 300,
            exitDelay = 200
        )

        AnimatedVisibility(
            visible = isHighStrength,
            enter = slideInVertically(
                animationSpec = tween(1000, delayMillis = 100),
                initialOffsetY = { -it * 3 }
            ),
            exit = slideOutVertically(
                animationSpec = tween(1000),
                targetOffsetY = { -it * 4 }
            )
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                Image(
                    painter = painterResource(R.drawable.dropped_coffee_beans),
                    contentDescription = stringResource(R.string.coffee_beans),
                    modifier = Modifier.size(100.dp)
                )
            }
        }
    }
}

@Composable
private fun AnimatedCoffeeBeanLayer(
    isVisible: Boolean,
    animationDelay: Int,
    exitDelay: Int
) {
    AnimatedVisibility(
        visible = isVisible,
        enter = slideInVertically(
            animationSpec = tween(1000, delayMillis = animationDelay),
            initialOffsetY = { -it * 3 }
        ),
        exit = slideOutVertically(
            animationSpec = tween(1000, delayMillis = exitDelay),
            targetOffsetY = { -it * 4 }
        )
    ) {
        Image(
            painter = painterResource(R.drawable.dropped_coffee_beans),
            contentDescription = "Coffee beans",
            modifier = Modifier.size(100.dp)
        )
    }
}