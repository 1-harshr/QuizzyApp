package com.harsh.quizzyapp.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.harsh.quizzyapp.ui.homepage.HomePageComposable
import com.harsh.quizzyapp.ui.loginscreen.LoginScreenComposable
import org.koin.androidx.compose.koinViewModel
import com.harsh.quizzyapp.ui.viewmodel.HomePageViewModel
import com.harsh.quizzyapp.ui.viewmodel.LoginViewModel

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object HomePage : Screen("homepage")
}

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ) {
        composable(Screen.Login.route) {
            val viewModel: LoginViewModel = koinViewModel()
            LoginScreenComposable(
                viewModel = viewModel,
                onLoginSuccess = {
                    navController.navigate(Screen.HomePage.route) {
                        popUpTo(Screen.Login.route) { inclusive = true }
                    }
                }
            )
        }

        composable(Screen.HomePage.route) {
            val viewModel: HomePageViewModel = koinViewModel()
            HomePageComposable(viewModel = viewModel)
        }
    }
}

