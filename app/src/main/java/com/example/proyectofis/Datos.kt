package com.example.proyectofis

class Datos {
    // Setters
    // Getters
    var mail: String? = null
    var password: String? = null
    var estatura: String? = null
    var peso: String? = null
    @JvmField
    var calorias_perdida = 0f // Guarda las calorias que pierde el usuario
    @JvmField
    var ejercicios_realizados = 0 // Contador de ejercicios
}
