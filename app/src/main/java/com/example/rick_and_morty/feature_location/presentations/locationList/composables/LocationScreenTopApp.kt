package com.example.rick_and_morty.feature_location.presentations.locationList.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.rick_and_morty.R

@Composable
fun LocationScreenTopAppBar() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = stringResource(id = R.string.location), style = MaterialTheme.typography.h1)
        Image(
            painter = painterResource(id = R.drawable.three),
            contentDescription = "Search Icon",
            modifier = Modifier.size(40.dp),
            contentScale = ContentScale.Crop
        )
    }
}