package com.jer.newsappcompose.domain.usecase.news

import com.jer.newsappcompose.data.local.NewsDao
import com.jer.newsappcompose.domain.model.Article
import com.jer.newsappcompose.domain.repository.NewsRepository

class DeleteArticle(val newsRepository: NewsRepository) {

    suspend operator fun invoke(article: Article) {
        newsRepository.deleteArticle(article)
    }

}