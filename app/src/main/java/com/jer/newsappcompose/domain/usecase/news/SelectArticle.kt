package com.jer.newsappcompose.domain.usecase.news

import com.jer.newsappcompose.data.local.NewsDao
import com.jer.newsappcompose.domain.model.Article

class SelectArticle(val newsDao: NewsDao) {

    suspend operator fun invoke(url: String) : Article? {
        return newsDao.getArticle(url)
    }
}