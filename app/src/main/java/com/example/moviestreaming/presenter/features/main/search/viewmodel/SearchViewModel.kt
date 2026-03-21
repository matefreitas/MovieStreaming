package com.example.moviestreaming.presenter.features.main.search.viewmodel

import androidx.lifecycle.ViewModel
import com.example.moviestreaming.presenter.features.main.search.action.SearchAction
import com.example.moviestreaming.presenter.features.main.search.state.SearchState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class SearchViewModel: ViewModel() {
    private val _state = MutableStateFlow(SearchState())
    val state = _state.asStateFlow()

    fun submitAction(action: SearchAction){}
}