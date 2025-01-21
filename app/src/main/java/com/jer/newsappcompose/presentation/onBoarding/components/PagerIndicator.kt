package com.jer.newsappcompose.presentation.onBoarding.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.jer.newsappcompose.presentation.Dimens.IndicatorSize

@Composable
fun PagerIndicator(
    modifier: Modifier = Modifier,
    pagesCount: Int,
    selectedPage: Int,
    selectedColor: Color = Color(0xFF1877F2),
    unSelectedColor: Color = Color.LightGray
) {

    Row (
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        repeat(times = pagesCount) { page ->
            Box(modifier = Modifier
                .size(IndicatorSize)
                .clip(CircleShape)
                .background(color = if (page == selectedPage) selectedColor else unSelectedColor)
            )
        }
    }

}

@Preview(showBackground = true, backgroundColor = 3)
@Composable
private fun PagerIndicatorPreview() {
    PagerIndicator(
        pagesCount = 3,
        selectedPage = 1
    )


}