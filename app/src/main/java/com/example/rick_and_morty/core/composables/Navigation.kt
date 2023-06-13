package com.example.rick_and_morty.core

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.rick_and_morty.feature_characters.presentations.characterList.CharacterListViewModel
import com.example.rick_and_morty.feature_characters.presentations.composables.CharacterListScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "home"){
        composable(route = "home"){
            val vm : CharacterListViewModel = hiltViewModel()
            CharacterListScreen(screenState = vm.state.value)
        }
    }
}