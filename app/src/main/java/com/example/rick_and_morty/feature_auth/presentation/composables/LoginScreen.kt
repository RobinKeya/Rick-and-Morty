package com.example.rick_and_morty.feature_auth.presentation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.rick_and_morty.R
import com.example.rick_and_morty.core.utils.Screens
import com.example.rick_and_morty.feature_auth.presentation.LoginViewModel

@Composable
fun LoginScreen(navController: NavController,loginViewModel: LoginViewModel) {
    val visiblePassword = remember{ mutableStateOf(false) }
    Box(modifier= Modifier.fillMaxSize()){
        Column() {
            Row(horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp, end = 16.dp)
            ) {
                Text(text = stringResource(id = R.string.have_account),style = MaterialTheme.typography.h3)
                Text(text = stringResource(id = R.string.login),
                    style = MaterialTheme.typography.h3,
                    modifier = Modifier
                        .clickable { navController.navigate(Screens.SignUp){
                            popUpTo(Screens.LogIn){
                                inclusive = true
                            }
                        }
                        },
                    color = Color.Blue
                )
            }

            Text(text = stringResource(id = R.string.login),
                style = MaterialTheme.typography.h1,
                modifier = Modifier.padding(top = 100.dp, start = 16.dp)
            )
            Text(text = stringResource(id = R.string.signup_welcome),
                style = MaterialTheme.typography.h2,
            modifier = Modifier.padding(16.dp))

            TextField(
                value =loginViewModel.email,
                onValueChange ={value->
                    loginViewModel.email = value
                },
                placeholder = { Text(text = stringResource(id = R.string.email_address))},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 8.dp, 16.dp, 4.dp)
                    .clip(RoundedCornerShape(25)),
                maxLines = 1,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )
            TextField(
                value =loginViewModel.password,
                onValueChange ={value->
                    loginViewModel.password = value
                },
                placeholder = { Text(text = stringResource(id = R.string.password))},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 8.dp, 16.dp, 4.dp)
                    .clip(RoundedCornerShape(25)),
                maxLines = 1,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                visualTransformation = if (visiblePassword.value) VisualTransformation.None else
                    PasswordVisualTransformation(),
                trailingIcon = {
                    val image = if (visiblePassword.value) Icons.Default.Visibility  else Icons.Default.VisibilityOff
                    val description = if(visiblePassword.value) "Hide password" else "Show password"
                    Image(
                        imageVector = image,
                        contentDescription = description,
                        modifier = Modifier.clickable {
                            visiblePassword.value = !visiblePassword.value
                        }
                    )
                }

            )
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
                    .padding(16.dp)
            ) {

                Button(onClick = { navController.navigate(Screens.Home){
                    popUpTo(Screens.Home){
                        inclusive = true
                    }
                } }
                ) {
                    Text(text = stringResource(id = R.string.login),modifier = Modifier.padding(16.dp))
                }
            }

            Text(text = stringResource(id = R.string.or_sign_up_with),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h2,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp))

            Row(verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 32.dp)

            ) {
                Box(contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(60.dp)
                        .padding(8.dp)
                        .clip(CircleShape)
                ) {
                    Image(painter = painterResource(id = R.drawable.l1), contentDescription ="",
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }
                Box(contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(60.dp)
                        .padding(8.dp)
                        .clip(RoundedCornerShape(25))
                ) {
                    Image(painter = painterResource(id = R.drawable.l2), contentDescription ="",
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }
                Box(contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(60.dp)
                        .padding(8.dp)
                        .clip(RoundedCornerShape(25))
                ) {
                    Image(painter = painterResource(id = R.drawable.l3), contentDescription ="",
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }
                Box(contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(60.dp)
                        .padding(8.dp)
                        .clip(RoundedCornerShape(25))
                ) {
                    Image(painter = painterResource(id = R.drawable.l4), contentDescription ="",
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }
            }
        }
    }
}