package com.example.rick_and_morty.feature_location.presentations.locationList.composables

import android.annotation.SuppressLint
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import com.example.rick_and_morty.feature_location.presentations.locationList.LocationScreenState

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LocationScreen(screenState: LocationScreenState) {
    val scaffoldState = rememberScaffoldState()
    Scaffold(scaffoldState = scaffoldState, topBar = { LocationScreenTopAppBar()}) {
        if (screenState.isLoading){
            CircularProgressIndicator()
        }
        if(screenState.error !=null){
            Text(text = screenState.error)
        }
        LazyColumn(){
            items(screenState.locations){ location->
                LocationItem(location)
            }
        }
    }
}