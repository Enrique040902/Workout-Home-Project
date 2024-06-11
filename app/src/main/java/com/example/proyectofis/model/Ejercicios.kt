package com.example.proyectofis.model

data class Ejercicios(
    var ejerciciosRealizados: Int = 0,
    var caloriasQuemadas: Double = 0.0
) {
    fun toMap() : MutableMap<String, Any> {
        return mutableMapOf(
            "Ejercicios realizados" to this.ejerciciosRealizados,
            "Calorias quemadas" to this.caloriasQuemadas
        )
    }
}
