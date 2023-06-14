package com.example.rick_and_morty.feature_location.presentations.locationList.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.rick_and_morty.R
import com.example.rick_and_morty.feature_location.domain.models.DomainResult

@Composable
fun LocationItem(location: DomainResult) {
    Card() {
        Column(modifier = Modifier.padding(8.dp)) {
            when(location.type){
                "Earth"-> {
                    Image(
                        painter = painterResource(id = R.drawable.earth),
                        contentDescription = "Earth Image",
                        modifier = Modifier.fillMaxWidth(),
                        contentScale = ContentScale.Crop
                    )
                    Text(text = location.name, style = MaterialTheme.typography.h2, modifier = Modifier.padding(8.dp))
                    Text(text = location.type, style = MaterialTheme.typography.h3, modifier = Modifier.padding(8.dp))
                }
                "Space station"-> {
                    Image(
                        painter = painterResource(id = R.drawable.citadel_of_ricks),
                        contentDescription = "Citadel of ricks image",
                        modifier = Modifier.fillMaxWidth(),
                        contentScale = ContentScale.Crop
                    )
                    Text(text = location.name, style = MaterialTheme.typography.h2, modifier = Modifier.padding(8.dp))
                    Text(text = location.type, style = MaterialTheme.typography.h3, modifier = Modifier.padding(8.dp))
                }
                "Planet"-> {
                    Image(
                        painter = painterResource(id = R.drawable.earth),
                        contentDescription = "Earth Image",
                        modifier = Modifier.fillMaxWidth(),
                        contentScale = ContentScale.Crop
                    )
                    Text(text = location.name, style = MaterialTheme.typography.h2, modifier = Modifier.padding(8.dp))
                    Text(text = location.type, style = MaterialTheme.typography.h3, modifier = Modifier.padding(8.dp))
                }
                "Microverse"-> {
                    Image(
                        painter = painterResource(id = R.drawable.dimention),
                        contentDescription = "Microverse Image",
                        modifier = Modifier.fillMaxWidth(),
                        contentScale = ContentScale.Crop
                    )
                    Text(text = location.name, style = MaterialTheme.typography.h2, modifier = Modifier.padding(8.dp))
                    Text(text = location.type, style = MaterialTheme.typography.h3, modifier = Modifier.padding(8.dp))
                }
                "Dream"-> {
                    Image(
                        painter = painterResource(id = R.drawable.froopyland),
                        contentDescription = "Froopylad Image",
                        modifier = Modifier.fillMaxWidth(),
                        contentScale = ContentScale.Crop
                    )
                    Text(text = location.name, style = MaterialTheme.typography.h2, modifier = Modifier.padding(8.dp))
                    Text(text = location.type, style = MaterialTheme.typography.h3, modifier = Modifier.padding(8.dp))
                }
                else-> {
                    Image(
                        painter = painterResource(id = R.drawable.gazorpazorp),
                        contentDescription = "gazorpazorp Image",
                        modifier = Modifier.fillMaxWidth(),
                        contentScale = ContentScale.Crop
                    )
                    Text(text = location.name, style = MaterialTheme.typography.h2, modifier = Modifier.padding(8.dp))
                    Text(text = location.type, style = MaterialTheme.typography.h3, modifier = Modifier.padding(8.dp))
                }
            }
        }
    }
}