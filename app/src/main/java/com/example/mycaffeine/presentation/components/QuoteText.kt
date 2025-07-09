package com.example.mycaffeine.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycaffeine.R
import com.example.mycaffeine.ui.theme.CoffeePrimaryColor
import com.example.mycaffeine.ui.theme.Sniglet

@Composable
fun QuoteText(
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        BeansIcon(
            modifier = Modifier
                .padding(end = 6.dp)
        )
        Text(
            text = stringResource(R.string.more_espresso_less_depresso),
            color = CoffeePrimaryColor,
            fontFamily = Sniglet,
            fontWeight = FontWeight.Normal,
            fontSize = 20.sp,
            letterSpacing = 0.25.sp,
        )
       BeansIcon(
           modifier = Modifier
               .padding(start = 6.dp)
       )
    }
}

@Composable
fun BeansIcon(
    modifier: Modifier = Modifier
){
    Icon(
        painter = painterResource(id = R.drawable.coffee_beans),
        contentDescription = "Coffee beans",
        tint = CoffeePrimaryColor,
        modifier = modifier
            .size(32.dp)
    )
}

@Preview
@Composable
fun QuoteTextPreview() {
    QuoteText()
}