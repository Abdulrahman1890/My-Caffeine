package com.example.mycaffeine.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.mycaffeine.R
import com.example.mycaffeine.ui.theme.OffWhiteColor

@Composable
fun CancelButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(48.dp)
            .background(
                color = OffWhiteColor,
                shape = CircleShape
            )
            .clickable { onClick() }
    ) {
        Icon(
            painter = painterResource(id = R.drawable.close),
            contentDescription = stringResource(R.string.cancel),
            modifier = Modifier
                .align(Alignment.Center)
                .size(24.dp)
        )
    }
}