package com.example.mycaffeine.presentation.screens.readyOrderScreen

import android.annotation.SuppressLint
import android.graphics.BlurMaskFilter
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.EaseOutCubic
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mycaffeine.R
import com.example.mycaffeine.data.CoffeeDataSource
import com.example.mycaffeine.domian.CoffeeCupImages
import com.example.mycaffeine.presentation.components.CancelButton
import com.example.mycaffeine.presentation.components.CustomButton
import com.example.mycaffeine.presentation.navigation.Screen
import com.example.mycaffeine.ui.theme.CoffeePrimaryColor
import com.example.mycaffeine.ui.theme.SecondaryTextColor
import com.example.mycaffeine.ui.theme.TakeAwayTextColor
import com.example.mycaffeine.ui.theme.Urbanist
import kotlinx.coroutines.delay
import org.koin.androidx.compose.koinViewModel


@Composable
fun ReadyOrderScreen(
    navController: NavController,
    viewModel: ReadyOrderViewModel = koinViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    OrderReadyScreenContent(
        uiState = uiState,
        onTakeAwayToggled = viewModel::onTakeAwayToggled,
        onTakeSnackClicked = {
            navController.navigate(Screen.SnackSelection.route)
        },
        onCloseClicked = {
            navController.navigate(Screen.Home.route) {
                popUpTo(Screen.Home.route) { inclusive = true }
            }
        }
    )
}

@SuppressLint("ConfigurationScreenWidthHeight")
@Composable
fun OrderReadyScreenContent(
    uiState: ReadyOrderUiState,
    onTakeAwayToggled: () -> Unit,
    onTakeSnackClicked: () -> Unit,
    onCloseClicked: () -> Unit
) {

    var isContentVisible by remember { mutableStateOf(false) }

    LaunchedEffect(Unit) {
        delay(300)
        isContentVisible = true
    }

    val lidOffsetY by animateDpAsState(
        targetValue = if (isContentVisible) -(150).dp else (-600).dp,
        animationSpec = tween(
            durationMillis = 800,
            delayMillis = 200,
            easing = EaseOutCubic
        ),
        label = stringResource(R.string.lidoffsetanimation)
    )

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp, vertical = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AnimatedVisibility(
                visible = isContentVisible,
                enter = slideInVertically(animationSpec = tween(800, easing = EaseOutCubic)) { -it }
            ) {
                TopSection(onCloseClicked = onCloseClicked)
            }

            Spacer(modifier = Modifier.weight(1f))

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                CoffeeCup(
                    coffeeImages = uiState.selectedCoffee!!.images,
                    lidOffsetY = lidOffsetY,
                    modifier = Modifier
                        .fillMaxWidth(0.75f)
                        .aspectRatio(1f)
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            BottomSection(
                isVisible = isContentVisible,
                isTakeAway = uiState.isTakeAway,
                topImage = uiState.selectedCoffee!!.images.topViewImage,
                onTakeAwayToggled = onTakeAwayToggled,
                onTakeSnackClicked = onTakeSnackClicked
            )
        }
    }
}

@Composable
private fun TopSection(
    onCloseClicked: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            CancelButton(
                onClick = onCloseClicked,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(top = 30.dp)
            )
        }
        Spacer(modifier = Modifier.height(32.dp))
        Box(
            modifier = Modifier
                .size(56.dp)
                .drawBehind {
                    drawIntoCanvas {
                        val paint = Paint()
                        val frameworkPaint = paint.asFrameworkPaint()
                        val color = CoffeePrimaryColor
                        val blurRadius = 16.dp.toPx()

                        if (blurRadius > 0) {
                            frameworkPaint.maskFilter = (BlurMaskFilter(
                                blurRadius,
                                BlurMaskFilter.Blur.NORMAL
                            ))
                        }
                        frameworkPaint.color = color.toArgb()

                        it.drawCircle(
                            center = center,
                            radius = size.width / 2,
                            paint = paint
                        )
                    }
                }
                .clip(CircleShape)
                .background(CoffeePrimaryColor),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = Icons.Default.Check,
                contentDescription = stringResource(R.string.order_ready),
                tint = Color.White,
                modifier = Modifier.size(32.dp)
            )
        }
        Text(
            text = stringResource(R.string.your_coffee_is_ready_enjoy),
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = SecondaryTextColor,
            modifier = Modifier.padding(top = 24.dp)
        )
    }
}

@Composable
private fun CoffeeCup(
    coffeeImages: CoffeeCupImages,
    modifier: Modifier = Modifier,
    lidOffsetY: Dp
) {
    Box(
        modifier = modifier
            .fillMaxWidth(0.75f)
            .aspectRatio(1f),
        contentAlignment = Alignment.Center
    ) {
        Image(
            painter = painterResource(id = coffeeImages.emptyCupImage),
            contentDescription = stringResource(R.string.coffee_cup),
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Image(
            painter = painterResource(id = R.drawable.brand_logo),
            contentDescription = stringResource(R.string.the_chance_coffee_logo),
            modifier = Modifier
                .size(80.dp)
                .align(Alignment.Center)
        )

        Image(
            painter = painterResource(id = coffeeImages.coverImage),
            contentDescription = stringResource(R.string.coffee_lid),
            modifier = Modifier
                .fillMaxSize()
                .offset(y = lidOffsetY),
        )
    }
}

@Composable
private fun BottomSection(
    isVisible: Boolean,
    isTakeAway: Boolean,
    topImage: Int,
    onTakeAwayToggled: () -> Unit,
    onTakeSnackClicked: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(bottom = 16.dp)
    ) {
        AnimatedVisibility(
            visible = isVisible,
            enter = fadeIn(animationSpec = tween(durationMillis = 600, delayMillis = 400))
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                CoffeeToggleButton(
                    isToggled = isTakeAway,
                    topImage = topImage,
                    onToggle = onTakeAwayToggled
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = stringResource(R.string.take_away),
                    fontFamily = Urbanist,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = TakeAwayTextColor
                )
            }
        }
        Spacer(modifier = Modifier.height(24.dp))
        AnimatedVisibility(
            visible = isVisible,
            enter = slideInVertically(
                animationSpec = tween(durationMillis = 800, easing = EaseOutCubic)
            ) { it }
        ) {
            CustomButton(
                text = stringResource(R.string.take_snack),
                onClickNext = onTakeSnackClicked
            )
        }
    }
}

@Composable
fun CoffeeToggleButton(
    topImage: Int,
    isToggled: Boolean,
    onToggle: () -> Unit,
    modifier: Modifier = Modifier
) {
    val trackColor by animateColorAsState(
        targetValue = if (isToggled) Color(0xFF8B5A2B) else Color(0xFFFBEAE0),
        animationSpec = tween(300),
        label = stringResource(R.string.trackcolor)
    )

    val horizontalBias by animateFloatAsState(
        targetValue = if (isToggled) -1f else 1f,
        animationSpec = tween(300),
        label = stringResource(R.string.horizontalbias)
    )

    Box(
        modifier = modifier
            .width(120.dp)
            .height(56.dp)
            .clip(RoundedCornerShape(50))
            .background(trackColor)
            .clickable(
                onClick = onToggle,
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            )
            .padding(horizontal = 8.dp),
        contentAlignment = Alignment.Center,
    ) {

        Text(
            text = stringResource(R.string.on),
            color = Color.White,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.CenterEnd)
                .padding(end = 12.dp)
        )

        Text(
            text = stringResource(R.string.off),
            color = Color.Gray,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.CenterStart)
                .padding(start = 12.dp)
        )


        Box(
            modifier = Modifier
                .fillMaxHeight()
                .align(BiasAlignment(horizontalBias = horizontalBias, verticalBias = 0f))
        ) {
            Image(
                painter = painterResource(id = topImage),
                contentDescription = stringResource(R.string.toggle_thumb),
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape)
                    .align(Alignment.Center),
                contentScale = ContentScale.Crop
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ReadyOrderScreenPreview() {

    val previewState = ReadyOrderUiState(
        selectedCoffee = CoffeeDataSource.availableCoffee.first(),
        isTakeAway = false
    )
    OrderReadyScreenContent(
        uiState = previewState,
        onTakeAwayToggled = {},
        onTakeSnackClicked = {},
        onCloseClicked = {}
    )

}