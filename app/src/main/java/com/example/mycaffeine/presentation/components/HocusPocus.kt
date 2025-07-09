package com.example.mycaffeine.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mycaffeine.R
import com.example.mycaffeine.ui.theme.Sniglet
import kotlinx.coroutines.delay

@Composable
fun HocusPocus(
    modifier: Modifier = Modifier
) {
    val textLines = listOf(
        "Hocus",
        "Pocus",
        "I Need Coffee",
        "to Focus"
    )

    Box(
        modifier = modifier
            .padding(top = 8.dp)
            .wrapContentWidth()
    ) {
        Column(
            modifier = Modifier.wrapContentSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            textLines.forEachIndexed { index, line ->
                Text(
                    text = line,
                    color = Color.Black,
                    fontFamily = Sniglet,
                    fontWeight = FontWeight.Normal,
                    fontSize = 32.sp,
                    lineHeight = 50.sp,
                    letterSpacing = 0.25.sp,
                    modifier = if (index == textLines.lastIndex) {
                        Modifier.padding(top = 8.dp)
                    } else {
                        Modifier
                    }
                )
            }
        }
        AnimatedStar(
            modifier = Modifier
                .padding(start = 10.dp, top = 65.dp)
                .size(16.dp)
        )
        AnimatedStar(
            modifier = Modifier
                .align(alignment = Alignment.TopEnd)
                .size(16.dp)
                .offset(x = 1.dp)
        )
        AnimatedStar(
            modifier = Modifier
                .align(alignment = Alignment.BottomEnd)
                .offset(x = 18.dp)
                .size(16.dp)
        )
    }
}

@Composable
private fun AnimatedStar(
    modifier: Modifier = Modifier
) {
    var isLighting = remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        while (true) {
            delay(500)
            isLighting.value = !isLighting.value
        }
    }

    val image = if (isLighting.value) {
        painterResource(id = R.drawable.black_star)
    } else {
        painterResource(id = R.drawable.gray_star)
    }

    Image(
        painter = image,
        contentDescription = stringResource(R.string.star),
        modifier = modifier.size(16.dp)
    )
}
