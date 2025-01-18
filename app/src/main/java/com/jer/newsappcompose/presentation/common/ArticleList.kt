package com.jer.newsappcompose.presentation.common

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import androidx.paging.LoadStates
import androidx.paging.compose.LazyPagingItems
import com.jer.newsappcompose.domain.model.Article
import com.jer.newsappcompose.presentation.Dimens.MediumPadding1
import com.jer.newsappcompose.presentation.Dimens.VerySmallPadding
import kotlin.concurrent.timer

@Composable
fun ArticleList(
    modifier: Modifier = Modifier,
    articles: LazyPagingItems<Article>,
    onClick: (Article) -> Unit
) {

    val handlePagingResult = handlePagingResult(articles = articles)
    if (handlePagingResult) {
        LazyColumn(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(MediumPadding1),
            contentPadding = PaddingValues(all = VerySmallPadding),
        ) {
            items(count = articles.itemCount,) { count ->
                articles[count]?.let {
                    ArticleCard(article = it, onClick = { onClick(it) })
                }
            }
        }
    }

}


@Composable
fun handlePagingResult(
    articles: LazyPagingItems<Article>
): Boolean {

    val loadingState = articles.loadState

    val error = when {
        loadingState.refresh is LoadState.Error -> loadingState.refresh as LoadState.Error
        loadingState.append is LoadState.Error -> loadingState.append as LoadState.Error
        loadingState.prepend is LoadState.Error -> loadingState.prepend as LoadState.Error
        else -> null
    }
    
    return when {
        loadingState.refresh is LoadState.Loading -> {
            ShimmerEffect()
            false
        }

        error != null -> {
            EmptyScreen()
            false
        }

        else -> {
            true
        }

    }

}

@Composable
fun ShimmerEffect(modifier: Modifier = Modifier) {
    Column(verticalArrangement = Arrangement.spacedBy(MediumPadding1)) {
        repeat(10) {
            ArticleCardShimmerEffect(
                modifier = Modifier.padding(horizontal = MediumPadding1)
            )
        }
    }
}