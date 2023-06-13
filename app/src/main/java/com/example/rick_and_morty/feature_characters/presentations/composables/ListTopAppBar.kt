package com.example.rick_and_morty.feature_characters.presentations.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.rick_and_morty.R

@Composable
fun ListTopAppBar() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier =Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.two),
            contentDescription = "logo",
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(60.dp).padding(8.dp)
        )
        Image(
            painter = painterResource(id = R.drawable.three),
            contentDescription = "search icon",
            contentScale = ContentScale.Crop,
            modifier = Modifier.size(60.dp).padding(8.dp)
        )
    }
}