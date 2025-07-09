package com.example.mycaffeine.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycaffeine.R
import com.example.mycaffeine.ui.theme.WelcomeTextColor
import com.example.mycaffeine.ui.theme.PrimaryTextColor
import com.example.mycaffeine.ui.theme.Urbanist

@Composable
fun WelcomeMessage(
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = stringResource(R.string.good_morning),
            color = WelcomeTextColor,
            fontFamily = Urbanist,
            fontWeight = FontWeight.Bold,
            fontSize = 36.sp,
            letterSpacing = 0.25.sp,
        )
        Text(
            text = stringResource(R.string.abdulrahman),
            color = PrimaryTextColor,
            fontFamily = Urbanist,
            fontWeight = FontWeight.Bold,
            fontSize = 36.sp,
            letterSpacing = 0.25.sp,
            modifier = Modifier.padding(bottom = 4.dp)
        )
        Text(
            text = stringResource(R.string.what_would_you_like_to_drink_today),
            color = PrimaryTextColor,
            fontFamily = Urbanist,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            letterSpacing = 0.25.sp,
        )
    }
}

@Preview
@Composable
fun WelcomeMessagePreview() {
    WelcomeMessage()
}