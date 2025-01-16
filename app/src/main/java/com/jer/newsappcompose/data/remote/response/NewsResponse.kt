package com.jer.newsappcompose.data.remote.response

import com.jer.newsappcompose.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)