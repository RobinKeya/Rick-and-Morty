package com.example.rick_and_morty.feature_auth.presentation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.rick_and_morty.R
import com.example.rick_and_morty.feature_auth.presentation.LoginViewModel

@Composable
fun LoginScreen(navController: NavController,loginViewModel: LoginViewModel) {
    Box(modifier= Modifier.fillMaxSize()){
        Column() {
            Row(horizontalArrangement = Arrangement.End,
                modifier = Modifier.padding(16.dp)) {
                Text(text = stringResource(id = R.string.have_account))
                Text(text = stringResource(id = R.string.login))
            }

            Text(text = stringResource(id = R.string.signup),
                modifier = Modifier.padding(top = 100.dp)
            )
            Text(text = stringResource(id = R.string.signup_welcome),
            modifier = Modifier.padding(16.dp))

            TextField(
                value =loginViewModel.email,
                onValueChange ={value->
                    loginViewModel.email = value
                }
            )
            TextField(
                value =loginViewModel.password,
                onValueChange ={value->
                    loginViewModel.password = value
                }
            )

            Button(onClick = { /*TODO*/ }) {
                Text(text = stringResource(id = R.string.signup))
            }

            Text(text = stringResource(id = R.string.or_sign_up_with))

            Row(horizontalArrangement = Arrangement.SpaceEvenly) {
                Box(contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(32.dp)
                        .clip(RoundedCornerShape(25))
                        .border(1.dp, Color.LightGray)
                ) {
                    Image(painter = painterResource(id = R.drawable.l1), contentDescription ="",
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp)
                    )
                }
                Box(contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(32.dp)
                        .clip(RoundedCornerShape(25))
                        .border(1.dp, Color.LightGray)
                ) {
                    Image(painter = painterResource(id = R.drawable.l2), contentDescription ="",
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp)
                    )
                }
                Box(contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(32.dp)
                        .clip(RoundedCornerShape(25))
                        .border(1.dp, Color.LightGray)
                ) {
                    Image(painter = painterResource(id = R.drawable.l3), contentDescription ="",
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp)
                    )
                }
                Box(contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(32.dp)
                        .clip(RoundedCornerShape(25))
                        .border(1.dp, Color.LightGray)
                ) {
                    Image(painter = painterResource(id = R.drawable.l4), contentDescription ="",
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp)
                    )
                }
            }
        }
    }
}