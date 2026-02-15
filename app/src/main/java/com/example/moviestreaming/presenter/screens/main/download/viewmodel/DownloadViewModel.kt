package com.example.moviestreaming.presenter.screens.main.download.viewmodel

import androidx.lifecycle.ViewModel
import com.example.moviestreaming.presenter.screens.main.download.action.DownloadAction
import com.example.moviestreaming.presenter.screens.main.download.state.DownloadState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class DownloadViewModel: ViewModel() {
    private val _state = MutableStateFlow(DownloadState())
    val state = _state.asStateFlow()

    fun submit(action: DownloadAction) {}
}