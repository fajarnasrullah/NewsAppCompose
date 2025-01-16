package com.jer.newsappcompose.domain.usecase.news

import androidx.paging.PagingData
import com.jer.newsappcompose.domain.model.Article
import com.jer.newsappcompose.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNews(
    private val newsRepository: NewsRepository
) {

    operator fun invoke(sources: List<String>): Flow<PagingData<Article>> {
        return newsRepository.getNews(sources = sources)
    }

}