package com.example.proyectofis.screens.brazo

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectofis.R
import com.example.proyectofis.model.Rutina
import com.example.proyectofis.components.RutinaComponent

@Composable
fun BrazoAvanzadoComponent() {

    val rutinas = listOf(
        Rutina(
            imageId = R.drawable.principiante_circulo_brazos,
            rutina = "Circulo con los brazos",
            reps = "30 seg"
        ),
        Rutina(
            imageId = R.drawable.principiante_circulo_brazos,
            rutina = "Circulo con los brazos en sentido inverso",
            reps = "30 segundos"
        ),
        Rutina(
            imageId = R.drawable.saltos_sin_cuerda,
            rutina = "Saltos sin cuerdas",
            reps = "30 segundos"
        ),
        Rutina(
            imageId = R.drawable.burpees,
            rutina = "Burpees",
            reps = "16 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.flexion_biceps_izq_pierna,
            rutina = "Flexión de bicep izquierdo con pierna",
            reps = "16 segundos"
        ),
        Rutina(
            imageId = R.drawable.flexion_biceps_der_pierna,
            rutina = "Flexión de bicep derecho con pierna",
            reps = "16 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.flexion_bicep_izq,
            rutina = "Flexión bícep izquierdo",
            reps = "14 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.flexion_bicep_der,
            rutina = "Flexión con bícep derecho",
            reps = "14 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.triceps_suelo,
            rutina = "Tríceps en suelo",
            reps = "18 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.ganchos_alternos,
            rutina = "Ganchos alternos",
            reps = "30 segundos"
        ),
        Rutina(
            imageId = R.drawable.fondos_militares,
            rutina = "Fondos militares",
            reps = "14 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.triceps_suelo,
            rutina = "Tríceps en suelo",
            reps = "16 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.ganchos_alternos,
            rutina = "Ganchos alternos",
            reps = "30 segundos"
        ),
        Rutina(
            imageId = R.drawable.burpees,
            rutina = "Burpees",
            reps = "16 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.flexion_bicep_izq,
            rutina = "Flexión bícep izquierdo",
            reps = "12 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.fondos_militares,
            rutina = "Fondos militares",
            reps = "12 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.fondos_tumbado,
            rutina = "Fondos tumbado",
            reps = "30 segundos"
        ),
        Rutina(
            imageId = R.drawable.medio_flexion_rotacion,
            rutina = "Flexión y rotación",
            reps = "12 repeticiones"
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            text = stringResource(id = R.string.nivel_avanzado),
            style = TextStyle(
                fontSize = 30.sp,
                textAlign = TextAlign.Center
            )
        )
        Text(
            modifier = Modifier
                .padding(
                    start = 8.dp
                ),
            text = stringResource(R.string.perdida_aprox_de_74_kcal),
            style = TextStyle(
                fontSize = 14.sp,
                color = Color.Gray
            )
        )
        LazyColumn(
            modifier = Modifier
                .padding(8.dp)
        ) {
            items(rutinas) {rutina ->
                RutinaComponent(
                    imageId = rutina.imageId,
                    rutina = rutina.rutina,
                    reps = rutina.reps
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun BrazoAvanzadoComponentPreview() {
    BrazoAvanzadoComponent()
}