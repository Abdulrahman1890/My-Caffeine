package com.example.mycaffeine.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mycaffeine.R

@Composable
fun SnackConfirmation(
    snackImage: Int,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = snackImage),
            contentDescription = stringResource(R.string.selected_snack),
        )
        Spacer(modifier = Modifier.height(12.dp))
        ClosingMessage()
    }
}

@Preview(showBackground = true)
@Composable
private fun SnackConfirmationPreview() {
    SnackConfirmation(R.drawable.cupcake)
}