package com.example.loginflow.app

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.loginflow.navigation.Screen
import com.example.loginflow.screens.LoginScreen
import com.example.loginflow.screens.SignUpScreen
import com.example.loginflow.screens.TermsAndConditionsScreen

@Composable
fun MyApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = Screen.SignUpScreen.route) {
            composable(route = Screen.LoginScreen.route) {
                LoginScreen(navController)
            }
            composable(
                route = Screen.SignUpScreen.route,
////                +"/{name}/{age}"
//                arguments = listOf(
//                    navArgument("name") {
//                        type = NavType.StringType
//                    },
//                    navArgument("age"){
//                        type = NavType.StringType
//                    }
//                )
            ) { entry ->
                SignUpScreen(navController)
//                name = entry.arguments?.getString("name").toString(),
//                age = entry.arguments?.getString("age").toString()
            }
        }
    }
}
