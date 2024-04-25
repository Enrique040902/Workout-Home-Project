package com.example.proyectofis.screens.pecho

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
import com.example.proyectofis.Rutina
import com.example.proyectofis.components.RutinaComponent

@Composable
fun PechoIntermedioComponent() {

    val rutinas = listOf(
        Rutina(
            imageId = R.drawable.saltos_de_tijera,
            rutina = "Saltos de tijera",
            reps = "30 seg"
        ),
        Rutina(
            imageId = R.drawable.principiante_flexiones_de_brazos_con_rodillas_apoyadas,
            rutina = "Flexiones con apoyo de rodillas",
            reps = "12 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.flexiones_simples,
            rutina = "Flexiones",
            reps = "12 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.principiante_flexion_brazos_abiertos,
            rutina = "Flexiones con brazos abiertos",
            reps = "16 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.medio_flexiones_indues,
            rutina = "Flexiones hindúes",
            reps = "10 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.medio_flexiones_escalonadas,
            rutina = "Flexiones escalonadas",
            reps = "10 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.medio_flexion_rotacion,
            rutina = "Flexiones con rotación",
            reps = "12 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.principiante_flexiones_de_brazos_con_rodillas_apoyadas,
            rutina = "Flexiones con apoyo de rodillas",
            reps = "10 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.medio_flexiones_indues,
            rutina = "Flexiones hindúes",
            reps = "5 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.flexiones_con_inclinacion_apoyo_piernas,
            rutina = "Flexiones con inclinación (Apoyo en piernas)",
            reps = "12 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.medio_flexiones_escalonadas,
            rutina = "Flexiones escalonadas",
            reps = "8 repeticiones"
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
            text = stringResource(R.string.nivel_intermedio),
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
            text = stringResource(R.string.perdida_aprox_pecho_intermedio),
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
fun PechoIntermedioComponentPreview() {
    PechoIntermedioComponent()
}