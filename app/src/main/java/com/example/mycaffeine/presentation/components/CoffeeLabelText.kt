package com.example.mycaffeine.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycaffeine.ui.theme.CoffeePrimaryColor
import com.example.mycaffeine.ui.theme.GrayColor
import com.example.mycaffeine.ui.theme.Sniglet

@Composable
fun CoffeeLabelText(
    text: String,
    modifier: Modifier = Modifier
) {
    Text(
        text = text,
        fontSize = 32.sp,
        fontFamily = Sniglet,
        fontWeight = FontWeight.ExtraBold,
        color = CoffeePrimaryColor,
        modifier = modifier
    )

}

@Composable
fun GrayColumns(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        repeat(2) {
            Box(
                modifier = Modifier
                    .size(4.dp)
                    .background(GrayColor, shape = CircleShape)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CoffeeLabelTextPreview() {
    CoffeeLabelText(
        "Coffee"
    )
}