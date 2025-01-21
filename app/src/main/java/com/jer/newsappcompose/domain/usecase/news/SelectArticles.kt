package com.jer.newsappcompose.domain.usecase.news

import com.jer.newsappcompose.data.local.NewsDao
import com.jer.newsappcompose.domain.model.Article
import com.jer.newsappcompose.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SelectArticles(val newsRepository: NewsRepository) {

   operator fun invoke(): Flow<List<Article>> {
        return newsRepository.selectArticles()
    }

}