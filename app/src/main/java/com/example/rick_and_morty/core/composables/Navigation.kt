package com.example.rick_and_morty.core.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.rick_and_morty.core.utils.Screens
import com.example.rick_and_morty.feature_auth.presentation.LoginViewModel
import com.example.rick_and_morty.feature_auth.presentation.SignUpViewModel
import com.example.rick_and_morty.feature_auth.presentation.composables.LoginScreen
import com.example.rick_and_morty.feature_auth.presentation.composables.SelectAuthScreen
import com.example.rick_and_morty.feature_auth.presentation.composables.SignUpScreen
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
        composable(route = Screens.AuthScreen){
            SelectAuthScreen(navController = navController)
        }
        composable(route= Screens.LogIn){
            val vm : LoginViewModel = hiltViewModel()
            LoginScreen(navController = navController, loginViewModel =vm )
        }
        composable(route = Screens.SignUp){
            val vm :SignUpViewModel = hiltViewModel()
            SignUpScreen(navController = navController, signUpViewModel = vm)
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
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(text = "To be implemented")
            }
        }
    }
}