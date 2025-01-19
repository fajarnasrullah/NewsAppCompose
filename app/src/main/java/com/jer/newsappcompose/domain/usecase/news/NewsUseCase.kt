package com.jer.newsappcompose.domain.usecase.news

import com.jer.newsappcompose.presentation.search.SearchEvent

class NewsUseCase(
    val getNews: GetNews,
    val searchNews: SearchNews
) {
}