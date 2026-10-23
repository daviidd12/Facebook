package me.juanbohorquez.facebook

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import me.juanbohorquez.facebook.ui.theme.screens.FacebookForgotPasswordScreen
import me.juanbohorquez.facebook.ui.theme.screens.FacebookLoginScreen
import me.juanbohorquez.facebook.ui.theme.screens.FacebookRegisterScreen
import me.juanbohorquez.facebook.ui.theme.screens.FeedScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            val myNavController = rememberNavController()
            NavHost(
                navController = myNavController,
                startDestination = "login",
                modifier = Modifier.fillMaxSize()
            ) {
                composable(route = "login"){
                    FacebookLoginScreen(
                        onNavigateToRegister = { myNavController.navigate("register") },
                        onNavigateToForgotPassword = { myNavController.navigate("forgot_password") },
                        onNavigateToFeed = { myNavController.navigate("feed") }
                    )
                }
                composable(route = "register"){
                    FacebookRegisterScreen(
                        onNavigateToLogin = { myNavController.popBackStack() }
                    )
                }
                composable(route = "forgot_password"){
                    FacebookForgotPasswordScreen(
                        onNavigateBack = { myNavController.popBackStack() }
                    )
                }
                composable(route = "feed"){
                    FeedScreen()
                }
            }




        }
    }
}

