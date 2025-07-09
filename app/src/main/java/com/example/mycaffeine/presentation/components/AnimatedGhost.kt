package com.example.mycaffeine.presentation.components

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycaffeine.R

@Composable
fun AnimatedGhost(
    modifier: Modifier = Modifier
) {
    val infiniteTransition = rememberInfiniteTransition(label = "ghostAnimation")

    val floatingOffset by infiniteTransition.animateFloat(
        initialValue = 21f,
        targetValue = -21f,
        animationSpec = infiniteRepeatable(
            animation = tween(2000),
            repeatMode = RepeatMode.Reverse
        ),
        label = "ghostFloat"
    )

    val shadowOpacity = calculateShadowOpacity(floatingOffset)

    Column(
        modifier = modifier.padding(top = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ghost),
            contentDescription = stringResource(R.string.ghost),
            modifier = Modifier
                .width(244.dp)
                .graphicsLayer {
                    translationY = floatingOffset
                },
        )
        Image(
            painter = painterResource(id = R.drawable.shadow),
            contentDescription = stringResource(R.string.ghost_shadow),
            modifier = Modifier
                .width(177.dp)
                .graphicsLayer {
                    alpha = shadowOpacity
                }
        )
    }
}

private fun calculateShadowOpacity(floatingOffset: Float): Float {
    return ((floatingOffset + 21f) / 42f).coerceIn(0.6f, 1f)
}

@Preview
@Composable
private fun AnimatedGhostPreview() {
    AnimatedGhost()
}