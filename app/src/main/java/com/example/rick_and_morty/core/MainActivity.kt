package com.example.rick_and_morty.core

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.rick_and_morty.core.composables.Navigation
import com.example.rick_and_morty.core.utils.Constants
import com.example.rick_and_morty.core.utils.Screens
import com.example.rick_and_morty.ui.theme.RickandMortyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickandMortyTheme {
                val navController = rememberNavController()
                val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
                val scaffoldState = rememberScaffoldState()
                Scaffold(
                    scaffoldState = scaffoldState,
                    bottomBar = { if(currentRoute != Screens.Splash){
                        BottomAppBar(
                            items = Constants.items,
                            modifier =Modifier.fillMaxWidth() ,
                            navController = navController,
                            onItemClick = {navController.navigate("${it.route}")}
                        )
                    }}
                ) {
                    Navigation(navController =navController )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RickandMortyTheme {
    }
}