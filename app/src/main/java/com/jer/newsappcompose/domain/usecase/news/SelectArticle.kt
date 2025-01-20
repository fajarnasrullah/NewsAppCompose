package com.jer.newsappcompose.domain.usecase.news

import com.jer.newsappcompose.data.local.NewsDao
import com.jer.newsappcompose.domain.model.Article
import kotlinx.coroutines.flow.Flow

class SelectArticle(val newsDao: NewsDao) {

   operator fun invoke(): Flow<List<Article>> {
        return newsDao.getArticle()
    }

}