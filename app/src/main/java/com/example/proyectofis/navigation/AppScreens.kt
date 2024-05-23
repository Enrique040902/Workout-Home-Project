package com.example.proyectofis.navigation

sealed class AppScreens(
    val route: String
) {
    object SplashScreen: AppScreens("splash_screen")
    object LoginScreen: AppScreens("login_screen")
    object RegistroScreen: AppScreens("register_screen")
    object PesoEstaturaScreen: AppScreens("peso_estatura_screen")
    object PrincipalScreen: AppScreens("principal_screen")

    object PechoMenuScreen: AppScreens("pecho_menu_screen")
    object PiernaMenuScreen: AppScreens("piernas_menu_screen")
    object BrazoMenuScreen: AppScreens("brazo_menu_screen")
    object AbsMenuScreen: AppScreens("abs_menu_screen")

    object PechoPrincipianteScreen: AppScreens("pecho_principiante_screen")
    object PechoIntermedioScreen: AppScreens("pecho_intermedio_screen")
    object PechoAvanzadoScreen: AppScreens("pecho_avanzado_screen")

    object PiernaPrincipianteScreen: AppScreens("pierna_principiante_screen")
    object PiernaIntermedioScreen: AppScreens("pierna_intermedio_screen")
    object PiernaAvanzadoScreen: AppScreens("pierna_avanzado_screen")

    object BrazoPrincipianteScreen: AppScreens("brazo_principiante_screen")
    object BrazoIntermediocreen: AppScreens("brazo_intermedio_screen")
    object BrazoAvanzadoScreen: AppScreens("brazo_avanzado_screen")

    object AbsPrincipinateScreen: AppScreens("abs_principiante_screen")
    object AbsIntermedioScreen: AppScreens("abs_intermedio_screen")
    object AbsAvanzadoScreen: AppScreens("abs_avanzado_screen")

}