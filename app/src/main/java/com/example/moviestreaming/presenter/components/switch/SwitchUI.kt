package com.example.moviestreaming.presenter.components.switch

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material3.LocalMinimumInteractiveComponentSize
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.moviestreaming.presenter.theme.MovieStreamingTheme

@Composable
fun SwitchUI(
    modifier: Modifier = Modifier,
    checked: Boolean,
    enabled: Boolean = true,
    onCheckedChange: (Boolean) -> Unit
) {
    CompositionLocalProvider(LocalMinimumInteractiveComponentSize provides 0.dp) {
        Switch(
            checked = checked,
            onCheckedChange = onCheckedChange,
            enabled = enabled,
            thumbContent = {
                Spacer(
                    modifier = Modifier.size(SwitchDefaults.IconSize)
                )
            },
            colors = SwitchDefaults.colors(
                checkedThumbColor = MovieStreamingTheme.colorScheme.whiteColor,
                uncheckedThumbColor = MovieStreamingTheme.colorScheme.whiteColor,
                checkedTrackColor = MovieStreamingTheme.colorScheme.defaultColor,
                uncheckedTrackColor = MovieStreamingTheme.colorScheme.switchInactiveBackgroundColor,
                checkedBorderColor = MovieStreamingTheme.colorScheme.defaultColor,
                uncheckedBorderColor = MovieStreamingTheme.colorScheme.switchInactiveBackgroundColor
            ),
            modifier = modifier
        )
    }
}

@PreviewLightDark
@Composable
private fun SwitchUIPreview() {
    MovieStreamingTheme {
        SwitchUI(
            checked = false,
            onCheckedChange = {}
        )
    }
}