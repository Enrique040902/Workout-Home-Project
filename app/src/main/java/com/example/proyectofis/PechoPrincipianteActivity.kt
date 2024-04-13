package com.example.proyectofis

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectofis.databinding.ActivityPechoPrincipianteBinding

class PechoPrincipianteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityPechoPrincipianteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPechoPrincipianteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saltosTijeraRutina.setContent { RutinaComponent("30 seg") }
        binding.FlexionesInclinacion.setContent { RutinaComponent(rutina = "15 reps") }
        binding.FlexionesNormales.setContent { RutinaComponent(rutina = "15 reps") }
        binding.FlexionesAbiertas.setContent { RutinaComponent(rutina = "10 reps") }
        binding.FlexionesTricepSilla.setContent { RutinaComponent(rutina = "10 reps") }
        binding.FlexionesInclinacion2.setContent { RutinaComponent(rutina = "10 reps") }
        binding.FlexionesAbiertas2.setContent { RutinaComponent(rutina = "10 reps") }
        binding.FlexionesTricepSilla2.setContent { RutinaComponent(rutina = "10 reps") }
        binding.FlexionesApoyoRodilla.setContent { RutinaComponent(rutina = "15 reps") }

    }

    @Composable
    private fun RutinaComponent(rutina: String) {
        Text(
            modifier = Modifier.padding(3.dp),
            text = rutina,
            fontSize = 14.sp,
            fontWeight = FontWeight(600)
        )
    }
}
