package com.jer.newsappcompose.presentation.home

data class HomeState(
    val newsTicker: String = "",
    val isLoading: Boolean = false,
)