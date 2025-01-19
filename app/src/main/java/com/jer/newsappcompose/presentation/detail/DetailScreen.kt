package com.jer.newsappcompose.presentation.detail

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.jer.newsappcompose.domain.model.Article
import com.jer.newsappcompose.presentation.detail.components.DetailTopAppBar


@Composable
fun DetailsScreen(
    article: Article,
    event: (DetailEvent) -> Unit ,
    navigateUp: () -> Unit
    ) {

    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
    ) {
        DetailTopAppBar(
            onBackClick = navigateUp ,
            onBookmarkClick = { event(DetailEvent.SaveArticle) },
            onShareClick = {
                Intent(Intent.ACTION_SEND).also {
                    it.putExtra(Intent.EXTRA_TEXT, article.url)
                    it.type = "text/plain"
                    if (it.resolveActivity(context.packageManager) != null) {
                        context.startActivity(it)
                    }
                }

            },
            onBrowsingClick = {
                Intent(Intent.ACTION_SEND).also {
                    it.data = Uri.parse(article.url)
                    if(it.resolveActivity(context.packageManager) != null) {
                        context.startActivity(it)
                    }
                }
            }
        )
    }
}