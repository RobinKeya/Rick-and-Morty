package com.example.rick_and_morty.feature_characters.presentations.composables

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rick_and_morty.R
import com.example.rick_and_morty.feature_characters.presentations.characterList.CharacterListScreenState

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CharacterListScreen(screenState: CharacterListScreenState) {
    val scaffoldState = rememberScaffoldState()
    Scaffold(scaffoldState = scaffoldState, topBar = { ListTopAppBar()}) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            item(){
                Image(
                    painter = painterResource(id = R.drawable.one),
                    contentDescription ="background_image",
                    modifier = Modifier
                        .fillMaxWidth()
                        .offset(y = -(20).dp),
                    contentScale = ContentScale.Crop
                )
            }
            item {
                Text(text = stringResource(id = R.string.characters),
                style = MaterialTheme.typography.h1
                )
                Spacer(modifier = Modifier. height(10.dp))
                Text(text = stringResource(id = R.string.main_characters),
                style = MaterialTheme.typography.h2)
            }
            item {
                if (screenState.isLoading){
                    CircularProgressIndicator()
                }
                if (screenState.error !=null){
                    Text(text = screenState.error)
                }
            }
            item(){
                LazyRow(contentPadding = PaddingValues(4.dp)){
                    items(screenState.charList){
                        CharacterItem(item = it)
                    }
                }
            }
        }
    }
}