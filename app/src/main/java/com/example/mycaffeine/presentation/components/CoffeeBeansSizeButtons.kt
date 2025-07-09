package com.example.mycaffeine.presentation.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycaffeine.R
import com.example.mycaffeine.presentation.screens.customizeCoffeeScreen.CustomizeCoffeeUiState.BeansSize
import com.example.mycaffeine.presentation.utils.coffeeDropShadow
import com.example.mycaffeine.ui.theme.CoffeePrimaryColor
import com.example.mycaffeine.ui.theme.OffWhiteColor
import com.example.mycaffeine.ui.theme.SecondaryLabelColor
import com.example.mycaffeine.ui.theme.Urbanist

@Composable
fun CoffeeBeansSizeButtons(
    selectedStrength: BeansSize,
    onStrengthSelected: (BeansSize) -> Unit,
    modifier: Modifier = Modifier
) {
    val strengthLabels = listOf("Low", "Medium", "High")

    Column {
        Row(
            modifier = modifier
                .height(56.dp)
                .background(
                    OffWhiteColor,
                    shape = RoundedCornerShape(50.dp)
                )
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            BeansSize.entries.forEach { strengthLevel ->

                StrengthButton(
                    strengthLevel = strengthLevel,
                    isSelected = selectedStrength == strengthLevel,
                    onStrengthSelected = onStrengthSelected
                )
            }
        }

        StrengthLabels(
            labels = strengthLabels,
            modifier = modifier.width(152.dp)
        )
    }
}


@Composable
private fun StrengthButton(
    strengthLevel: BeansSize,
    isSelected: Boolean,
    onStrengthSelected: (BeansSize) -> Unit
) {
    val animatedColor by animateColorAsState(
        targetValue = if (isSelected) CoffeePrimaryColor else OffWhiteColor,
        animationSpec = tween(durationMillis = 200),
        label = "strengthButtonColor"
    )

    Button(
        onClick = { onStrengthSelected(strengthLevel) },
        modifier = Modifier
            .size(40.dp)
            .coffeeDropShadow(
                shape = CircleShape,
                color = if (isSelected) CoffeePrimaryColor else OffWhiteColor,
                alpha = if (isSelected) 0.5f else 0.3f,
                blur = 4.dp,
                offsetX = 0.dp,
                offsetY = 4.dp
            ),
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(containerColor = animatedColor),
        contentPadding = PaddingValues(8.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.beans),
            contentDescription = "beans",
            modifier = Modifier.size(24.dp)
        )
    }
}


@Composable
private fun StrengthLabels(
    labels: List<String>,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        labels.forEach { label ->
            Text(
                text = label,
                fontSize = 10.sp,
                fontWeight = FontWeight.Medium,
                letterSpacing = 0.25.sp,
                color = SecondaryLabelColor,
                fontFamily = Urbanist
            )
        }
    }
}