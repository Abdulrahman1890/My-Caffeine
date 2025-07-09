package com.example.mycaffeine.presentation.components

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
import com.example.mycaffeine.ui.theme.DescriptionColor
import com.example.mycaffeine.ui.theme.Urbanist

@Composable
fun ClosingMessage(
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
    ) {
        Text(
            text = stringResource(R.string.bon_app_tit),
            color = DescriptionColor,
            fontFamily = Urbanist,
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            letterSpacing = 0.25.sp,
        )
        Icon(
            painter = painterResource(id = R.drawable.magic_wand),
            contentDescription = stringResource(R.string.magic_wand),
            tint = DescriptionColor,
            modifier = Modifier
                .size(24.dp)
                .padding(start = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ClosingMessagePreview() {
    ClosingMessage()
}