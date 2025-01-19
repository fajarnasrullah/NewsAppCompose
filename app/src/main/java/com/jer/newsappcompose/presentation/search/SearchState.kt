package com.jer.newsappcompose.presentation.search

import androidx.paging.PagingData
import com.jer.newsappcompose.domain.model.Article
import kotlinx.coroutines.flow.Flow

data class SearchState (
    val searchQuery: String = "",
    val articles: Flow<PagingData<Article>>? = null

)