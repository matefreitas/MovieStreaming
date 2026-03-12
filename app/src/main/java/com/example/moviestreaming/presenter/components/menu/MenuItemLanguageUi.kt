package com.example.moviestreaming.presenter.components.menu

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moviestreaming.R
import com.example.moviestreaming.presenter.theme.MovieStreamingTheme
import com.example.moviestreaming.presenter.theme.UrbanistFamily

@Composable
fun MenuItemLanguageUi(
    modifier: Modifier = Modifier,
    icon: Int,
    label: Int,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable(
                indication = null,
                interactionSource = remember { MutableInteractionSource() }
            ) { onClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            modifier = Modifier.size(28.dp),
            tint = MovieStreamingTheme.colorScheme.iconColor
        )

        Spacer(modifier = Modifier.padding(16.dp))

        Text(
            text = stringResource(id = label),
            modifier = Modifier.weight(1f),
            style = TextStyle(
                fontSize = 18.sp,
                lineHeight = 25.2.sp,
                fontFamily = UrbanistFamily,
                fontWeight = FontWeight.SemiBold,
                color = MovieStreamingTheme.colorScheme.textColor,
                letterSpacing = 0.2.sp
            )
        )

        Text(
            text = "English (US)",
            modifier = Modifier,
            style = TextStyle(
                fontSize = 18.sp,
                lineHeight = 25.2.sp,
                fontFamily = UrbanistFamily,
                fontWeight = FontWeight.SemiBold,
                color = MovieStreamingTheme.colorScheme.textColor,
                letterSpacing = 0.2.sp
            )
        )

        Spacer(modifier = Modifier.padding(16.dp))

        Icon(
            painter = painterResource(id = R.drawable.ic_arrow_right),
            contentDescription = null,
            tint = MovieStreamingTheme.colorScheme.iconColor
        )
    }
}

@PreviewLightDark
@Composable
private fun MenuItemLanguageUiPreview() {
    MovieStreamingTheme {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .background(MovieStreamingTheme.colorScheme.backgroundColor),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MenuItemLanguageUi(
                icon = R.drawable.ic_language,
                label = R.string.label_language_account_screen,
                onClick = {}
            )
        }
    }
}