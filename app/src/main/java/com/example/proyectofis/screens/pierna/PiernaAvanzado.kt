package com.example.proyectofis.screens.pierna

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
import com.example.proyectofis.screens.brazo.BrazoPrincipianteComponent

@Composable
fun PiernaAvanzadoComponent() {

    val rutinas = listOf(
        Rutina(
            imageId = R.drawable.saltos_de_tijera,
            rutina = "Salto de tijera",
            reps = "30 segundos"
        ),
        Rutina(
            imageId = R.drawable.burpees,
            rutina = "Burpees",
            reps = "10 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.squats,
            rutina = "Squats",
            reps = "14 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.squats,
            rutina = "Squats",
            reps = "14 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.squats,
            rutina = "Squats",
            reps = "14 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.levantamiento_pierna_lateral_izquierda,
            rutina = "Levantamiento de pierna izquierda",
            reps = "12 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.levantamiento_de_pierna_lateral_derecha,
            rutina = "Levantamiento de pierna derecha",
            reps = "12 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.levantamiento_pierna_lateral_izquierda,
            rutina = "Levantamiento de pierna izquierda",
            reps = "12 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.levantamiento_de_pierna_lateral_derecha,
            rutina = "Levantamiento de pierna derecha",
            reps = "12 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.levantamiento_pierna_lateral_izquierda,
            rutina = "Levantamiento de pierna izquierda",
            reps = "12 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.levantamiento_de_pierna_lateral_derecha,
            rutina = "Levantamiento de pierna derecha",
            reps = "12 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.circulos_pierna_izq,
            rutina = "Círculos con la pierna izquierda",
            reps = "12 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.circulos_pierna_der,
            rutina = "Círculos con la pierna derecha",
            reps = "12 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.circulos_pierna_izq,
            rutina = "Círculos con la pierna izquierda",
            reps = "12 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.circulos_pierna_der,
            rutina = "Círculos con la pierna derecha",
            reps = "12 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.circulos_pierna_izq,
            rutina = "Círculos con la pierna izquierda",
            reps = "12 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.circulos_pierna_der,
            rutina = "Círculos con la pierna derecha",
            reps = "12 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.sentadilla_salto,
            rutina = "Sentadilla con salto",
            reps = "14 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.sentadilla_salto,
            rutina = "Sentadilla con salto",
            reps = "14 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.sentadilla_salto,
            rutina = "Sentadilla con salto",
            reps = "14 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.elevacion_trasera_piernas,
            rutina = "Elevación trasera de piernas",
            reps = "12 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.elevacion_trasera_piernas,
            rutina = "Elevación trasera de piernas",
            reps = "12 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.elevacion_trasera_piernas,
            rutina = "Elevación trasera de piernas",
            reps = "12 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.elevacion_trasera_piernas,
            rutina = "Elevación trasera de piernas",
            reps = "12 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.elevacion_trasera_piernas,
            rutina = "Elevación trasera de piernas",
            reps = "12 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.circulos_pierna_der,
            rutina = "Circulos con pierna derecha",
            reps = "12 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.circulos_pierna_izq,
            rutina = "Circulos con pierna izquierda",
            reps = "12 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.levantamiento_pantorrilla_resistencia,
            rutina = "Levantamiendo de pantorrilla derecha con resistencia",
            reps = "16 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.levantamiento_pantorrilla_resistencia,
            rutina = "Levantamiendo de pantorrilla izquierda con resistencia",
            reps = "16 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.levantamiento_pantorrilla_resistencia,
            rutina = "Levantamiendo de pantorrilla derecha con resistencia",
            reps = "16 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.levantamiento_pantorrilla_resistencia,
            rutina = "Levantamiendo de pantorrilla izquierda con resistencia",
            reps = "16 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.levantamiento_pantorrilla_resistencia,
            rutina = "Levantamiendo de pantorrilla derecha con resistencia",
            reps = "16 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.levantamiento_pantorrilla_resistencia,
            rutina = "Levantamiendo de pantorrilla izquierda con resistencia",
            reps = "16 repeticiones"
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
fun PiernaAvanzadoComponentPreview() {
    PiernaAvanzadoComponent()
}