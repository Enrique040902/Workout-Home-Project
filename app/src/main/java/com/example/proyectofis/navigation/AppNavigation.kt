package com.example.proyectofis.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.internal.composableLambda
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyectofis.screens.AbsMenuScreen
import com.example.proyectofis.screens.BrazoMenuScreen
import com.example.proyectofis.screens.PechoMenuScreen
import com.example.proyectofis.screens.PiernaMenuScreen
import com.example.proyectofis.screens.PrincipalScreen
import com.example.proyectofis.screens.SplashScreen
import com.example.proyectofis.screens.abs.AbsAvanzadoScreen
import com.example.proyectofis.screens.abs.AbsIntermedioComponentPreview
import com.example.proyectofis.screens.abs.AbsIntermedioScreen
import com.example.proyectofis.screens.abs.AbsPrincipianteScreen
import com.example.proyectofis.screens.brazo.BrazoIntermedioScreen
import com.example.proyectofis.screens.brazo.BrazoPrincipianteScreen
import com.example.proyectofis.screens.login.LoginScreen
import com.example.proyectofis.screens.login.LoginViewModel
import com.example.proyectofis.screens.pecho.PechoAvanzadoScreen
import com.example.proyectofis.screens.pecho.PechoIntermedioScreen
import com.example.proyectofis.screens.pecho.PechoPrincipianteScreen
import com.example.proyectofis.screens.pierna.PiernaAvanzadoScreen
import com.example.proyectofis.screens.pierna.PiernaPrincipianteScreen
import com.example.proyectofis.screens.registro.PesoEstaturaComponent
import com.example.proyectofis.screens.registro.PesoEstaturaScreen
import com.example.proyectofis.screens.registro.PesoEstaturaViewModel
import com.example.proyectofis.screens.registro.RegistroScreen
import com.example.proyectofis.screens.registro.RegistroViewModel

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppScreens.PesoEstaturaScreen.route
    ) {
        composable(route = AppScreens.SplashScreen.route) {
            SplashScreen(navController = navController)
        }
        composable(route = AppScreens.LoginScreen.route) {
            LoginScreen(viewModel = LoginViewModel(), navController)
        }
        composable(route = AppScreens.RegistroScreen.route) {
            RegistroScreen(viewModel = RegistroViewModel(), navController)
        }
        composable(route = AppScreens.PesoEstaturaScreen.route) {
            PesoEstaturaScreen(navController = navController)
        }
        composable(route = AppScreens.PrincipalScreen.route) {
            PrincipalScreen(navController)
        }

        // Navegación para pecho
        composable(route = AppScreens.PechoMenuScreen.route) {
            PechoMenuScreen(navController = navController)
        }
        composable(route = AppScreens.PechoPrincipianteScreen.route) {
            PechoPrincipianteScreen(navController = navController)
        }
        composable(route = AppScreens.PechoIntermedioScreen.route) {
            PechoIntermedioScreen(navController = navController)
        }
        composable(route = AppScreens.PechoAvanzadoScreen.route) {
            PechoAvanzadoScreen(navController = navController)
        }

        // Navegación para pierna
        composable(route = AppScreens.PiernaMenuScreen.route) {
            PiernaMenuScreen(navController = navController)
        }
        composable(route = AppScreens.PiernaPrincipianteScreen.route) {
            PiernaPrincipianteScreen(navController = navController)
        }
        composable(route = AppScreens.PiernaIntermedioScreen.route) {
            PiernaPrincipianteScreen(navController = navController)
        }
        composable(route = AppScreens.PiernaAvanzadoScreen.route) {
            PiernaAvanzadoScreen(navController = navController)
        }
        // Navegación para Brazo
        composable(route = AppScreens.BrazoMenuScreen.route) {
            BrazoMenuScreen(navController = navController)
        }
        composable(route = AppScreens.BrazoPrincipianteScreen.route) {
            BrazoPrincipianteScreen(navController = navController)
        }
        composable(route = AppScreens.BrazoIntermediocreen.route) {
            BrazoIntermedioScreen(navController = navController)
        }
        composable(route = AppScreens.BrazoAvanzadoScreen.route) {
            BrazoIntermedioScreen(navController = navController)
        }
        // Navegación para Abs
        composable(route = AppScreens.AbsMenuScreen.route) {
            AbsMenuScreen(navController = navController)
        }
        composable(route = AppScreens.AbsPrincipinateScreen.route) {
            AbsPrincipianteScreen(navController = navController)
        }
        composable(route = AppScreens.AbsIntermedioScreen.route) {
            AbsIntermedioScreen(navController = navController)
        }
        composable(route = AppScreens.AbsAvanzadoScreen.route) {
            AbsAvanzadoScreen(navController = navController)
        }
    }
}