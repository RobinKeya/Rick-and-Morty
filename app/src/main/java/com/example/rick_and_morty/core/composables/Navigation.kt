package com.example.rick_and_morty.core.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.rick_and_morty.core.utils.Screens
import com.example.rick_and_morty.feature_characters.presentations.characterDetails.CharacterDetailViewModel
import com.example.rick_and_morty.feature_characters.presentations.characterList.CharacterListViewModel
import com.example.rick_and_morty.feature_characters.presentations.composables.CharacterDetailScreen
import com.example.rick_and_morty.feature_characters.presentations.composables.CharacterListScreen
import com.example.rick_and_morty.feature_location.presentations.locationList.LocationListViewModel
import com.example.rick_and_morty.feature_location.presentations.locationList.composables.LocationScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screens.Splash){
        composable(route= Screens.Splash){
            SplashScreen(navController = navController)
        }
        composable(route = Screens.Home){
            val vm : CharacterListViewModel = hiltViewModel()
            CharacterListScreen(screenState = vm.state.value){id ->
                navController.navigate("${Screens.Home}/${id}")
            }
        }
        composable(route= "${Screens.Home}/{id}",
        arguments = listOf(navArgument(name = "id"){
            type = NavType.IntType
        })
        ){
            val vm : CharacterDetailViewModel = hiltViewModel()
            CharacterDetailScreen(screenState = vm.state.value)
        }
        composable(route = Screens.Location){
            val vm : LocationListViewModel = hiltViewModel()
            LocationScreen(screenState = vm.state.value)
        }
        composable(route = Screens.Episodes){
            Box(contentAlignment = Alignment.Center) {
                Text(text = "To be implemented")
            }
        }
    }
}