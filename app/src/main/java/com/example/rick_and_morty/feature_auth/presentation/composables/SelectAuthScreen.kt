package com.example.rick_and_morty.feature_auth.presentation.composables

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.rick_and_morty.R
import com.example.rick_and_morty.core.utils.Screens

@Composable
fun SelectAuthScreen(navController: NavController) {
    Box(contentAlignment = Alignment.BottomCenter
        ,modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.onPrimary)
    ) {
        Column(modifier = Modifier.padding(bottom = 30.dp)) {
            Image(
                painter = painterResource(id = R.drawable.used),
                contentDescription ="",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = stringResource(id = R.string.welcome),
                style = MaterialTheme.typography.h1,
                color = Color.Black,
                modifier = Modifier.padding(8.dp)
            )

            Button(onClick = { navController.navigate(Screens.SignUp) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clickable { }
                    .clip(RoundedCornerShape(25))
                    .background(Color.White),
                border = BorderStroke(1.dp, Color.LightGray),
                colors = ButtonDefaults.buttonColors(
                    contentColor = Color.Black
                )
            ) {
                Text(text = stringResource(id = R.string.signup),
                style = MaterialTheme.typography.h3,
                    modifier = Modifier.padding(8.dp)
                )
            }
            OutlinedButton(onClick = { navController.navigate(Screens.LogIn) },
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(25))
                    .padding(16.dp),
                border = BorderStroke(2.dp, Color.LightGray),
                colors = ButtonDefaults.outlinedButtonColors(
                    backgroundColor = MaterialTheme.colors.onPrimary,
                    contentColor = Color.Black
                )
            ) {
                Text(text = stringResource(id = R.string.login),
                    style = MaterialTheme.typography.h3,
                    modifier = Modifier.padding(8.dp)
                    )
            }
        }
    }
}