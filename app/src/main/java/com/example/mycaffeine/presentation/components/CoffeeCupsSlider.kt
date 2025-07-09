package com.example.mycaffeine.presentation.components

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.fontscaling.MathUtils.lerp
import androidx.compose.ui.unit.sp
import com.example.mycaffeine.data.CoffeeDataSource
import com.example.mycaffeine.domian.Coffee
import com.example.mycaffeine.ui.theme.ButtonColor
import com.example.mycaffeine.ui.theme.Urbanist
import kotlin.math.absoluteValue

@SuppressLint("RestrictedApi", "UnusedBoxWithConstraintsScope")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CoffeeCupsSlider(
    coffeeItems: List<Coffee>,
    pagerState: PagerState
) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {
        val screenWidth = maxWidth
        val itemWidth = screenWidth * 0.5f
        val horizontalPadding = (screenWidth - itemWidth) / 2

        HorizontalPager(
            state = pagerState,
            contentPadding = PaddingValues(horizontal = horizontalPadding),
            pageSpacing = 20.dp
        ) { pageIndex ->
            val pageOffset = (
                    (pagerState.currentPage - pageIndex) + pagerState.currentPageOffsetFraction
                    ).absoluteValue

            val scale = lerp(0.7f, 1.2f, 1f - pageOffset.coerceIn(0f, 1.5f))
            val offsetY = lerp(20f, 1f, 1f - pageOffset.coerceIn(0f, 1f))

            val coffee = coffeeItems[pageIndex]

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.width(itemWidth)
            ) {
                CoffeeImageCard(
                    coffee = coffee,
                    scale = scale,
                    offsetY = offsetY
                )

                Spacer(modifier = Modifier.height(50.dp))

                Text(
                    text = coffee.name,
                    color = ButtonColor,
                    fontFamily = Urbanist,
                    fontWeight = FontWeight.Bold,
                    fontSize = 32.sp,
                    letterSpacing = 0.25.sp,
                )
            }
        }
    }
}

@Composable
private fun CoffeeImageCard(
    coffee: Coffee,
    scale: Float,
    offsetY: Float
) {
    Card(
        modifier = Modifier.graphicsLayer {
            scaleX = scale
            scaleY = scale
            translationY = offsetY * 10
        },
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Image(
            painter = painterResource(id = coffee.images.mainImage),
            contentDescription = "${coffee.name} coffee"
        )
    }
}

@Preview
@Composable
fun CoffeeCupsSliderPreview() {
    CoffeeCupsSlider(
        coffeeItems = CoffeeDataSource.availableCoffee,
        pagerState = rememberPagerState(
            initialPage = 0,
            initialPageOffsetFraction = 0F,
            pageCount = { 1 }
        )
    )
}