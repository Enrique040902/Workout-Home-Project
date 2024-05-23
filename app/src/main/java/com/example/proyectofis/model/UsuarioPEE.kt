package com.example.proyectofis.model

data class UsuarioPEE(
    val peso: String,
    val estatura: String,
    val edad: String
) {
    fun toMap() : MutableMap<String, Any> {
        return mutableMapOf(
            "peso" to this.peso,
            "estatura" to this.estatura,
            "edad" to this.edad
        )
    }
}
