package com.jer.newsappcompose.presentation.home

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.jer.newsappcompose.domain.usecase.news.NewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor( val newsUseCases: NewsUseCase): ViewModel() {

    var state = mutableStateOf(HomeState())
        private set

    val news = newsUseCases.getNews(
        sources = listOf("bbc-news", "abc-news", "al-jazeera-english")
    ).cachedIn(viewModelScope)

}