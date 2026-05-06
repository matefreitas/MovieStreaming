package com.example.moviestreaming.presenter.features.country.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.example.moviestreaming.R
import com.example.moviestreaming.domain.local.model.country.Country
import com.example.moviestreaming.presenter.components.button.PrimaryButton
import com.example.moviestreaming.presenter.components.radio.RadioButtonUi
import com.example.moviestreaming.presenter.components.topAppBar.TopAppBarUI
import com.example.moviestreaming.presenter.features.country.action.CountryAction
import com.example.moviestreaming.presenter.features.country.state.CountryState
import com.example.moviestreaming.presenter.features.country.viewmodel.CountryViewModel
import com.example.moviestreaming.presenter.theme.MovieStreamingTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun CountryScreen(
    onCountrySelected: (Country?) -> Unit,
    onBackPressed: () -> Unit
) {
    val viewModel = koinViewModel<CountryViewModel>()
    val state by viewModel.state.collectAsState()

    CountryContent(
        state = state,
        action = viewModel::submitAction,
        onCountrySelected = onCountrySelected,
        onBackPressed = onBackPressed
    )
}

@Composable
private fun CountryContent(
    state: CountryState,
    action: (CountryAction) -> Unit,
    onCountrySelected: (Country?) -> Unit,
    onBackPressed: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBarUI(
                title = stringResource(R.string.label_title_country_screen),
                onclick = onBackPressed
            )
        },
        bottomBar = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .windowInsetsPadding(WindowInsets.navigationBars)
                    .background(MovieStreamingTheme.colorScheme.primaryBackgroundColor.copy(alpha = 0.7f))
            ) {
                HorizontalDivider()
                PrimaryButton(
                    modifier = Modifier
                        .padding(start = 24.dp, end = 24.dp, top = 24.dp, bottom = 32.dp),
                    text = stringResource(R.string.label_button_select_genre_screen),
                    enabled = state.selectedCountry != null,
                    onclick = {
                        onCountrySelected(state.selectedCountry)
                    }
                )
            }
        },
        containerColor = MovieStreamingTheme.colorScheme.primaryBackgroundColor
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = 24.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(
                bottom = 24.dp,
                top = 8.dp
            )
        ) {
            items(state.countries) { item ->
                RadioButtonUi(
                    selected = item == state.selectedCountry,
                    text = item.name ?: "",
                    onClick = {
                        action(CountryAction.OnCountrySelected(item))
                    }
                )
            }
        }
    }
}

@PreviewLightDark
@Composable
private fun CountryPreview() {
    MovieStreamingTheme {
        CountryContent(
            state = CountryState(
                countries = Country.items
            ),
            action = {},
            onCountrySelected = {},
            onBackPressed = {}
        )
    }
}