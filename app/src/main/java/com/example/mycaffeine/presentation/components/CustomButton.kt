package com.example.mycaffeine.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycaffeine.R
import com.example.mycaffeine.ui.theme.ButtonColor
import com.example.mycaffeine.ui.theme.TextButtonColor
import com.example.mycaffeine.ui.theme.Urbanist

@Composable
fun CustomButton(
    onClickNext: () -> Unit,
    modifier: Modifier = Modifier,
    text: String = stringResource(R.string.continuee),
    icon: Int = R.drawable.right_arrow,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .background(
                color = ButtonColor,
                shape = RoundedCornerShape(100.dp)
            )
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(100.dp),
                ambientColor = Color.Black,
                spotColor = Color.Black
            )
            .padding(horizontal = 32.dp, vertical = 16.dp)
            .clickable(onClick = onClickNext)
    ) {
        Text(
            text = text,
            color = TextButtonColor,
            fontFamily = Urbanist,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            letterSpacing = 0.25.sp,
            modifier = Modifier.padding(end = 8.dp)
        )
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.size(24.dp),
            tint = TextButtonColor
        )
    }
}