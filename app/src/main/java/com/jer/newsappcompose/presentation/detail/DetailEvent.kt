package com.jer.newsappcompose.presentation.detail

import com.jer.newsappcompose.domain.model.Article

sealed class DetailEvent {

    data class  UpsertDeleteArticle(val article: Article) : DetailEvent()

    object RemoveSideEffect : DetailEvent()
}