package com.example.rick_and_morty.feature_characters.presentations.composables

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.rick_and_morty.feature_characters.domain.models.DomainResult

@Composable
fun CharacterItem(item: DomainResult) {
    Card(elevation = 4.dp,
    modifier = Modifier
        .padding(8.dp,0.dp,8.dp, 16.dp)
        .clip(RoundedCornerShape(25))) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AsyncImage(
                model = item.image,
                contentDescription = "${item.name} image",
                contentScale = ContentScale.Crop
            )
            Text(text = item.name,
            style = MaterialTheme.typography.h2)
            Row {
                Text(text = item.species,
                style = MaterialTheme.typography.body1)
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = item.status,
                style = MaterialTheme.typography.body1)
            }
        }
    }
}