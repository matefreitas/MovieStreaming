package com.example.moviestreaming.presenter.components.snackbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moviestreaming.R
import com.example.moviestreaming.core.enums.feedback.FeedbackType
import com.example.moviestreaming.presenter.theme.MovieStreamingTheme
import com.example.moviestreaming.presenter.theme.UrbanistFamily

@Composable
fun FeedBackUi(
    modifier: Modifier = Modifier,
    message: String,
    type: FeedbackType
) {
    val containerColor = when(type){
        FeedbackType.SUCCESS -> MovieStreamingTheme.colorScheme.successColor
        FeedbackType.ERROR -> MovieStreamingTheme.colorScheme.alertColor
        FeedbackType.WARNING -> MovieStreamingTheme.colorScheme.warningColor
        FeedbackType.INFO -> MovieStreamingTheme.colorScheme.infoColor
    }

    Card (
        modifier = modifier.fillMaxWidth().padding(16.dp),
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(
            containerColor = containerColor
        )
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(R.drawable.ic_info),
                contentDescription = message,
                tint = MovieStreamingTheme.colorScheme.whiteColor
            )
            Spacer(modifier = Modifier.width(6.dp))
            Text(
                text = message,
                style = TextStyle(
                    fontFamily = UrbanistFamily,
                    color = MovieStreamingTheme.colorScheme.whiteColor,
                    letterSpacing = 0.2.sp
                )
            )
        }
    }
}

@Preview
@Composable
private fun FeedBackUiPreview() {
    MovieStreamingTheme{
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MovieStreamingTheme.colorScheme.primaryBackgroundColor)
            ,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            FeedBackUi(
                message = "login efetuado com sucesso",
                type = FeedbackType.SUCCESS
            )
            FeedBackUi(
                message = "login efetuado com sucesso",
                type = FeedbackType.WARNING
            )
            FeedBackUi(
                message = "login efetuado com sucesso",
                type = FeedbackType.INFO
            )
            FeedBackUi(
                message = "login efetuado com sucesso",
                type = FeedbackType.ERROR
            )
        }
    }
}