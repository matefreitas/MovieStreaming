package com.example.moviestreaming.presenter.components.bottom.bar

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import com.example.moviestreaming.core.navigation.bar.BottomAppBarItems
import com.example.moviestreaming.core.navigation.routes.bar.BottomAppBarRoutes
import com.example.moviestreaming.presenter.theme.MovieStreamingTheme

@Composable
fun BottomBarUi(
    modifier: Modifier = Modifier,
    currentDestination: NavDestination?,
    onItemClick: (BottomAppBarItems) -> Unit
) {
    AnimatedVisibility(
        visible = isBottomAppBar(currentDestination),
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it })
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
}

fun isBottomAppBar(currentDestination: NavDestination?): Boolean {
    return when (currentDestination?.route) {
        BottomAppBarRoutes.Home::class.qualifiedName,
        BottomAppBarRoutes.Search::class.qualifiedName,
        BottomAppBarRoutes.Favorite::class.qualifiedName,
        BottomAppBarRoutes.Download::class.qualifiedName,
        BottomAppBarRoutes.Account::class.qualifiedName -> true

        else -> false
    }
}