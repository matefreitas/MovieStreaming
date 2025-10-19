package com.example.moviestreaming.presenter.components.indicator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.moviestreaming.presenter.theme.MovieStreamingTheme

@Composable
fun SliderIndicator(
    modifier: Modifier = Modifier,
    totalIndicator: Int,
    currentIndicator: Int
) {
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(totalIndicator) { index ->
            if (index == currentIndicator) {
                Spacer(
                    modifier = Modifier
                        .width(32.dp)
                        .height(8.dp)
                        .clip(CircleShape)
                        .background(MovieStreamingTheme.colorScheme.defaultColor)
                )
            } else {
                Spacer(
                    modifier = Modifier
                        .size(8.dp)
                        .clip(CircleShape)
                        .background(MovieStreamingTheme.colorScheme.whiteColor)
                )
            }

            if (index != totalIndicator - 1){
                Spacer(modifier = Modifier.padding(horizontal = 2.dp))
            }
        }
    }
}

@Preview
@Composable
private fun SliderIndicatorPreview() {
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SliderIndicator(totalIndicator = 5, currentIndicator = 2)

    }
}