package com.example.loginflow.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Email
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.loginflow.R
import com.example.loginflow.components.ButtonComponent
import com.example.loginflow.components.ClickableSignupTextComponent
import com.example.loginflow.components.DividerComponent
import com.example.loginflow.components.HeadingTextComponents
import com.example.loginflow.components.MyTextField
import com.example.loginflow.components.NormalTextComponents
import com.example.loginflow.components.PasswordTextField

@Composable
fun LoginScreen(navController : NavController){
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            NormalTextComponents(value = stringResource(R.string.hello))
            HeadingTextComponents(value = "Please enter login credentials")
            Spacer(Modifier.height(12.dp))
            MyTextField(labelValue = "Email", Icons.Sharp.Email)
            PasswordTextField(labelValue = "Password")
            Spacer(modifier = Modifier.height(20.dp))
            ButtonComponent("Login",navController)
            Spacer(modifier = Modifier.height(20.dp))
            DividerComponent()
            Spacer(modifier = Modifier.height(10.dp))
            ClickableSignupTextComponent(navController)
        }

    }
}
//@Preview
//@Composable
//fun LoginPreview() {
//    LoginScreen(navController)
//}