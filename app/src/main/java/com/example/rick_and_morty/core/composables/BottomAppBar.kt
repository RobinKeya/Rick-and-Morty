package com.example.rick_and_morty.core

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.rick_and_morty.core.composables.BottomAppBarItem
import androidx.compose.material.BottomAppBar
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun BottomAppBar(
    items: List<BottomAppBarItem>,
    modifier: Modifier,
    navController: NavController,
    onItemClick: (BottomAppBarItem)->Unit
) {
    val backStackEntry = navController.currentBackStackEntryAsState()
    BottomAppBar(
        modifier = modifier,
        elevation = 3.dp,
        backgroundColor = MaterialTheme.colors.onPrimary
    ) {
        items.forEach { item->
            val selected = backStackEntry.value?.destination?.route == item.route
            BottomNavigationItem(
                selected =selected,
                modifier = Modifier.padding(8.dp),
                unselectedContentColor = Color.Gray,
                selectedContentColor = Color.White,
                onClick = { onItemClick(item) },
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center) {
                        Image(
                            painter = painterResource(id = item.icon),
                            contentDescription ="${item.route} icon",
                            modifier = Modifier.size(40.dp),
                            contentScale = ContentScale.Crop
                        )
                        Text(text = stringResource(id = item.title),
                        color = if (selected)Color.White else Color.LightGray)
                    }
                }
            )
        }
    }
}