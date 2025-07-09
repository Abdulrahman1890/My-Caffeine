package com.example.mycaffeine.presentation.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycaffeine.presentation.utils.coffeeDropShadow
import com.example.mycaffeine.ui.theme.CoffeePrimaryColor
import com.example.mycaffeine.ui.theme.OffWhiteColor
import com.example.mycaffeine.ui.theme.TextButtonColor
import com.example.mycaffeine.ui.theme.Urbanist

enum class CoffeeSize {
    S, M, L
}

@Composable
fun CoffeeSizeSelector(
    selectedSize: CoffeeSize,
    onSizeSelected: (CoffeeSize) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .height(56.dp)
            .background(OffWhiteColor, shape = RoundedCornerShape(50.dp))
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        CoffeeSize.entries.forEach { size ->
            val isSelected = selectedSize == size

            val buttonColor by animateColorAsState(
                targetValue = if (isSelected) CoffeePrimaryColor else OffWhiteColor,
                animationSpec = tween(durationMillis = 200),
                label = "button color"
            )
            val textColor by animateColorAsState(
                targetValue = if (isSelected) TextButtonColor else Color(0x991F1F1F),
                animationSpec = tween(durationMillis = 200),
                label = "text color"
            )

            Button(
                onClick = { onSizeSelected(size) },
                modifier = Modifier
                    .width(40.dp)
                    .coffeeDropShadow(
                        shape = CircleShape,
                        color = if (isSelected) CoffeePrimaryColor else OffWhiteColor,
                        alpha = if (isSelected) 0.5f else 0.3f,
                        blur = 4.dp,
                        offsetX = 0.dp,
                        offsetY = 4.dp
                    ),
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = buttonColor
                ),
                contentPadding = PaddingValues(8.dp)
            ) {
                Text(
                    text = size.name.first().toString(),
                    color = textColor,
                    fontFamily = Urbanist,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    letterSpacing = .25.sp,
                )
            }
        }
    }
}