package com.example.rick_and_morty.feature_characters.presentations.composables

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.rick_and_morty.feature_characters.presentations.characterDetails.CharacterDetailScreenState

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CharacterDetailScreen(screenState: CharacterDetailScreenState) {
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        scaffoldState = scaffoldState,
        topBar = { CharacterDetailTopAppBar()}
    ) {
        if(screenState.isLoading){
            CircularProgressIndicator()
        }
        if (screenState.error !=null){
            Text(text = screenState.error)
        }
        if (screenState.charInfo !=null){

            LazyColumn(modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.onPrimary)
            ) {
                item {
                    AsyncImage(
                        model = screenState.charInfo.image,
                        contentDescription = "${screenState.charInfo.name} image",
                        modifier = Modifier.fillMaxHeight(0.5f)
                            .fillMaxWidth()
                            .padding(8.dp),
                        contentScale = ContentScale.Crop
                    )
                }
                item {
                    Text(text = screenState.charInfo.name,
                    style = MaterialTheme.typography.h1,
                    color = Color.Yellow,
                    modifier = Modifier.padding(8.dp)
                        .fillMaxHeight(0.10f))
                    Card(
                        modifier = Modifier.border(2.dp, color = Color.White)
                        .fillMaxWidth()
                        .padding(8.dp)
                        .background(MaterialTheme.colors.onPrimary)
                        .fillMaxHeight(0.40f)) {
                        Column( ) {
                            Row {
                                Text(text = "Status : ",
                                    style = MaterialTheme.typography.h3,
                                    color = Color.Yellow)
                                Text(text = screenState.charInfo.status,
                                    style = MaterialTheme.typography.h3)
                            }

                            Row() {
                                Text(text = "Species : ",
                                    style = MaterialTheme.typography.h3,
                                    color = Color.Yellow)
                                Text(text = screenState.charInfo.species,
                                    style = MaterialTheme.typography.h3)
                            }
                            Row() {
                                Text(text = "Gender : ",
                                    style = MaterialTheme.typography.h3,
                                    color = Color.Yellow)
                                Text(text = screenState.charInfo.gender,
                                    style = MaterialTheme.typography.h3)
                            }
                        }
                    }
                }

            }
        }
    }
}