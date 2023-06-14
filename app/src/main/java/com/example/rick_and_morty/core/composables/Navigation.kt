package com.example.rick_and_morty.core.composables

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.rick_and_morty.feature_characters.presentations.characterDetails.CharacterDetailViewModel
import com.example.rick_and_morty.feature_characters.presentations.characterList.CharacterListViewModel
import com.example.rick_and_morty.feature_characters.presentations.composables.CharacterDetailScreen
import com.example.rick_and_morty.feature_characters.presentations.composables.CharacterListScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home"){
        composable(route = "home"){
            val vm : CharacterListViewModel = hiltViewModel()
            CharacterListScreen(screenState = vm.state.value){id ->
                navController.navigate("home/${id}")
            }
        }
        composable(route= "home/{id}",
        arguments = listOf(navArgument(name = "id"){
            type = NavType.IntType
        })
        ){
            val vm : CharacterDetailViewModel = hiltViewModel()
            CharacterDetailScreen(screenState = vm.state.value)
        }
    }
}