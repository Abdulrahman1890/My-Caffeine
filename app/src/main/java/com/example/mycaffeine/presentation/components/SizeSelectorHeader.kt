package com.example.mycaffeine.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycaffeine.R
import com.example.mycaffeine.ui.theme.OffWhiteColor
import com.example.mycaffeine.ui.theme.SecondaryTextColor
import com.example.mycaffeine.ui.theme.Urbanist

@Composable
fun SizeSelectorHeader(
    onBackPressed: () -> Unit,
    title: String,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Button(
            onClick = onBackPressed,
            colors = ButtonDefaults.buttonColors(
                containerColor = OffWhiteColor
            ),
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape),
            contentPadding = PaddingValues(12.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.left_arrow),
                contentDescription = stringResource(R.string.back),
                tint = SecondaryTextColor,
                modifier = Modifier.size(24.dp)
            )
        }

        Text(
            text = title,
            color = SecondaryTextColor,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = Urbanist,
            letterSpacing = .25.sp,
            lineHeight = 24.sp,
        )
    }
}