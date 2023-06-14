package com.example.rick_and_morty.feature_characters.presentations.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.rick_and_morty.R

@Composable
fun CharacterDetailTopAppBar() {
    Row(
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .background(MaterialTheme.colors.onPrimary)
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = R.drawable.baseline_arrow_back_ios_new_24),
            contentDescription ="Back arrow"
        )
    }
}