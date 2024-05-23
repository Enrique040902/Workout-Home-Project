package com.example.proyectofis.model

data class Usuario(
    val id: String?,
    val email: String,
    val displayName: String
) {
    fun toMap() : MutableMap<String, Any?> {
        return mutableMapOf(
            "id" to this.id,
            "email" to this.email,
            "display_name" to displayName
        )
    }
}