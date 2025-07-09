package com.example.mycaffeine.presentation.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.mycaffeine.R
import com.example.mycaffeine.ui.theme.LabelColor
import kotlin.math.PI
import kotlin.math.sin

@Composable
fun AnimatedWaveProgressBar(
    modifier: Modifier = Modifier,
    wavelength: Dp = 80.dp,
    waveHeight: Dp = 12.dp,
    color: Color = LabelColor
) {
    val waveLengthPx = with(LocalDensity.current) { wavelength.toPx() }
    val amplitudePx = with(LocalDensity.current) { waveHeight.toPx() }

    val infiniteTransition =
        rememberInfiniteTransition(label = stringResource(R.string.wave_animation))
    val animatedProgress by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1f,
        animationSpec = infiniteRepeatable(
            animation = tween(5000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = stringResource(R.string.wave_progress)
    )

    Canvas(
        modifier = modifier
    ) {
        val visibleWidth = size.width * animatedProgress
        val centerY = size.height / 2
        val path = Path()

        var currentX = 0f
        path.moveTo(currentX, centerY)

        while (currentX <= visibleWidth) {
            val waveY = (sin((currentX / waveLengthPx) * 2 * PI) * amplitudePx).toFloat() + centerY
            path.lineTo(currentX, waveY)
            currentX += 1f
        }

        drawPath(
            path = path,
            color = color,
            style = Stroke(width = 2.dp.toPx())
        )
    }
}
