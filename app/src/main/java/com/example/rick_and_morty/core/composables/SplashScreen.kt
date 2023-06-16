package com.example.rick_and_morty.core.composables

import android.view.animation.OvershootInterpolator
import android.window.SplashScreen
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.rick_and_morty.R
import com.example.rick_and_morty.core.utils.Constants
import com.example.rick_and_morty.core.utils.Screens
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.onPrimary)
    ) {
        val scale = remember{
            Animatable(0.0f)
        }
        
        LaunchedEffect(key1 = true ){
            scale.animateTo(
                targetValue = 0.8f,
                animationSpec = tween(
                    800,
                    easing = {
                        OvershootInterpolator(4f).getInterpolation(it)
                    }
                )
            )
            delay(3000)
            navController.navigate(Screens.AuthScreen){
                popUpTo(Screens.Splash){
                    inclusive = true
                }
            }
        }
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "logo",
            modifier = Modifier
                .fillMaxSize()
                .padding(40.dp)
                .scale(scale.value)
        )
    }
}