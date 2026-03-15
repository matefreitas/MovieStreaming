package com.example.moviestreaming.presenter.components.bottom.bar

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.example.moviestreaming.core.navigation.bar.BottomAppBarItems
import com.example.moviestreaming.presenter.theme.MovieStreamingTheme

@Composable
fun BottomBarUi(
    modifier: Modifier = Modifier,
    currentDestination: NavDestination?,
    onItemClick: (BottomAppBarItems) -> Unit
) {
    BottomAppBar(
        actions = {
            BottomAppBarItems.items.forEach { item ->
                val isSelect = currentDestination?.hierarchy?.any {
                    it.route == item.route::class.qualifiedName
                } == true
                BottomBarItemUI(
                    item = item,
                    onClick = { onItemClick(item) },
                    isSelect = isSelect
                )
            }
        },
        modifier = modifier.clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),
        containerColor = MovieStreamingTheme.colorScheme.primaryBackgroundColor
    )
}