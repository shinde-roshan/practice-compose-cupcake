package com.example.cupcake.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cupcake.R
import com.example.cupcake.ui.theme.CupcakeTheme

@Composable
fun StartOrderScreen (
    quantityOptions: List<Pair<Int, Int>>,
    modifier: Modifier = Modifier
) {
    val paddingMedium = dimensionResource(id = R.dimen.padding_medium)
    val paddingSmall = dimensionResource(id = R.dimen.padding_small)
    
    Column (
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
    ) {
        Column (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(paddingMedium),
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.height(paddingMedium))
            Image(
                painter = painterResource(id = R.drawable.cupcake),
                contentDescription = null,
                modifier = Modifier.width(300.dp)
            )
            Spacer(modifier = Modifier.height(paddingMedium))
            Text(
                text = stringResource(id = R.string.order_cupcake),
                style = MaterialTheme.typography.headlineSmall
            )
            Spacer(modifier = Modifier.height(paddingSmall))
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(paddingMedium),
            modifier = Modifier.fillMaxWidth()
        ) {
            quantityOptions.forEach { 
                Button(
                    onClick = {},
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = stringResource(it.first))
                }
            }
        }
    }
}

@Preview (showBackground = true)
@Composable
fun StartOrderScreenPreview() {
    CupcakeTheme {
        StartOrderScreen(
            quantityOptions = listOf(
                Pair(R.string.one_cupcake, 1),
                Pair(R.string.six_cupcakes, 6),
                Pair(R.string.twelve_cupcakes, 12)
            ),
            modifier = Modifier
                .fillMaxSize()
                .padding(dimensionResource(id = R.dimen.padding_medium))
        )
    }
}