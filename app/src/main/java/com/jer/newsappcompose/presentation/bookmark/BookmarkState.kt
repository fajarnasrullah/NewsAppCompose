package com.jer.newsappcompose.presentation.bookmark

import com.jer.newsappcompose.domain.model.Article

data class BookmarkState (

    val articles: List<Article> = emptyList()
)