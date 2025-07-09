package com.example.mycaffeine.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
import com.example.mycaffeine.ui.theme.ButtonTransparentColor
import com.example.mycaffeine.ui.theme.DescriptionColor
import com.example.mycaffeine.ui.theme.LabelColor
import com.example.mycaffeine.ui.theme.Urbanist

@Composable
fun CoffeePreparationStatus(
    volumeMl: String,
    cupImage: Int,
    progress: Float,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 50.dp)
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
        ) {
            Text(
                text = volumeMl,
                fontSize = 14.sp,
                fontFamily = Urbanist,
                fontWeight = FontWeight.Medium,
                color = LabelColor,
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .offset(y = 250.dp)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = cupImage),
                    contentDescription = stringResource(R.string.coffee_cup),
                    modifier = Modifier
                        .width(200.dp)
                        .height(244.dp)
                )
                Image(
                    painter = painterResource(id = R.drawable.brand_logo),
                    contentDescription = stringResource(R.string.logo),
                    modifier = Modifier.size(66.dp)
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AnimatedWaveProgressBar(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                )

                Spacer(modifier = Modifier.height(25.dp))

                Text(
                    text = stringResource(R.string.almost_done),
                    fontSize = 22.sp,
                    fontFamily = Urbanist,
                    fontWeight = FontWeight.Bold,
                    color = DescriptionColor,
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = stringResource(R.string.your_coffee_will_be_finish_in),
                    fontSize = 16.sp,
                    fontFamily = Urbanist,
                    fontWeight = FontWeight.Bold,
                    color = ButtonTransparentColor,
                    modifier = Modifier.padding(horizontal = 32.dp),
                    maxLines = 2
                )

                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 32.dp),
                    horizontalArrangement = Arrangement.spacedBy(
                        14.dp,
                        Alignment.CenterHorizontally
                    ),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    CoffeeLabelText(stringResource(R.string.co))
                    GrayColumns()
                    CoffeeLabelText(stringResource(R.string.ff))
                    GrayColumns()
                    CoffeeLabelText(stringResource(R.string.ee))
                }

                Spacer(modifier = Modifier.height(64.dp))
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CoffeePreparationStatusPreview() {
    CoffeePreparationStatus(
        volumeMl = stringResource(R.string._400_ml),
        cupImage = R.drawable.default_cup,
        progress = 0.5f
    )
}