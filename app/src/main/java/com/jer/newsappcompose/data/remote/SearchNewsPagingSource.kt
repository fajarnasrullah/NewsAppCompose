package com.jer.newsappcompose.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.jer.newsappcompose.domain.model.Article

class SearchNewsPagingSource(
    private val searchQuery: String,
    private val newsApi: NewsApi,
    private val sources: String
): PagingSource<Int, Article>() {

    var totalNewsCount = 0

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        val page = params.key ?: 1
        return try {
            val newsResponse = newsApi.searchNews(searchQuery, page, sources)
            totalNewsCount += newsResponse.articles.size
            val articles = newsResponse.articles.distinctBy { it.title }
            LoadResult.Page(
                data = articles,
                nextKey = if (totalNewsCount == newsResponse.totalResults) null else page + 1,
                prevKey = null
            )
        } catch (e: Exception) {
            e.printStackTrace()
            LoadResult.Error(e)
        }
    }


    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition?.let { anchorPage ->
            val page = state.closestPageToPosition(anchorPage)
            page?.nextKey?.minus(1) ?: page?.prevKey?.plus(1)
        }
    }

}