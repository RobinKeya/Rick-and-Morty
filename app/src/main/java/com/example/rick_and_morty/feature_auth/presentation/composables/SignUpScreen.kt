package com.example.rick_and_morty.feature_auth.presentation.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
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
import com.example.rick_and_morty.feature_auth.presentation.SignUpViewModel

@Composable
fun SignUpScreen(navController: NavController,signUpViewModel: SignUpViewModel) {
    val showPassword = remember {
        mutableStateOf(false)
    }
    val showConfirmPassword = remember {
        mutableStateOf(false)
    }

    Box(modifier= Modifier.fillMaxSize()){
        Column() {
            Row(horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)) {
                Text(text = stringResource(id = R.string.have_account), style = MaterialTheme.typography.h3)
                Text(text = stringResource(id = R.string.login),
                    style = MaterialTheme.typography.h3,
                modifier = Modifier
                    .clickable { navController.navigate(Screens.LogIn){
                        popUpTo(Screens.SignUp){
                            inclusive = true
                        }
                    }
                    },
                    color = Color.Blue
                )
            }

            Text(text = stringResource(id = R.string.signup),
                style = MaterialTheme.typography.h1,
            modifier = Modifier.padding(top = 100.dp, start = 16.dp))
            Text(text = stringResource(id = R.string.signup_welcome),
                style = MaterialTheme.typography.h2,
            modifier = Modifier.padding(16.dp))
            
            TextField(
                value =signUpViewModel.email,
                onValueChange ={value->
                    signUpViewModel.email = value
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
                value =signUpViewModel.password,
                onValueChange ={value->
                    signUpViewModel.password = value
                },
                placeholder= { Text(text = stringResource(id = R.string.password))},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 8.dp, 16.dp, 4.dp)
                    .clip(RoundedCornerShape(25)),
                maxLines = 1,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                visualTransformation = if (showPassword.value) VisualTransformation.None else
                    PasswordVisualTransformation(),
                trailingIcon = {
                    val image = if(showPassword.value) Icons.Default.Visibility else Icons.Default.VisibilityOff
                    val description = if(showPassword.value) "Show password" else "Hide password"
                    IconButton(onClick = { showPassword.value = !showPassword.value }) {
                        Icon(imageVector = image, contentDescription = description)
                    }
                }

            )
            TextField(
                value =signUpViewModel.confirmPassword,
                onValueChange ={value->
                    signUpViewModel.confirmPassword = value
                },
                placeholder = { Text(text = stringResource(id = R.string.confirm_password))},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, 8.dp, 16.dp, 4.dp)
                    .clip(RoundedCornerShape(25)),
                maxLines = 1,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                visualTransformation = if( showConfirmPassword.value) VisualTransformation.None else
                    PasswordVisualTransformation(),
                trailingIcon = {
                    val image = if(showConfirmPassword.value) Icons.Default.Visibility else Icons.Default.VisibilityOff
                    val description = if(showConfirmPassword.value) "Show password" else "Hide password"
                    IconButton(onClick = { showConfirmPassword.value = !showConfirmPassword.value }) {
                        Icon(imageVector = image, contentDescription = description)
                    }
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
                    .padding(top = 32.dp, bottom = 32.dp)
            )
            
            Row(horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
            ) {
                Box(contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(60.dp)
                        .padding(8.dp)
                        .clip(RoundedCornerShape(25))

                ) {
                    Image(painter = painterResource(id = R.drawable.l1), contentDescription ="",
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Box(contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(60.dp)
                        .padding(8.dp)
                        .clip(RoundedCornerShape(25))
                ) {
                    Image(painter = painterResource(id = R.drawable.l2), contentDescription ="",
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Box(contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(60.dp)
                        .padding(8.dp)
                        .clip(RoundedCornerShape(25))
                ) {
                    Image(painter = painterResource(id = R.drawable.l3), contentDescription ="",
                        modifier = Modifier.fillMaxSize()

                    )
                }
                Box(contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .size(60.dp)
                        .padding(8.dp)
                        .clip(RoundedCornerShape(25))
                ) {
                    Image(painter = painterResource(id = R.drawable.l4), contentDescription ="",
                        modifier = Modifier.fillMaxSize()

                    )
                }
            }
        }
    }
}