package com.jer.newsappcompose.domain.usecase.news

import com.jer.newsappcompose.data.local.NewsDao
import com.jer.newsappcompose.domain.model.Article

class UpsertArticle(val newsDao: NewsDao)  {

    suspend operator fun invoke(article: Article) {
        newsDao.upsert(article = article)
    }

}