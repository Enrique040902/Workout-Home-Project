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
import androidx.navigation.NavController
import com.example.proyectofis.R
import com.example.proyectofis.model.Rutina
import com.example.proyectofis.components.RutinaComponent

@Composable
fun PiernaPrincipianteScreen(navController: NavController) {

    val rutinas = listOf(
        Rutina(
            imageId = R.drawable.salto_lateral,
            rutina = "Salto lateral",
            reps = "30 segundos"
        ),
        Rutina(
            imageId = R.drawable.squats,
            rutina = "Squats",
            reps = "10 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.levantamiento_pierna_lateral_izquierda,
            rutina = "Leventamiento de pierna lateral izquierda",
            reps = "10 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.levantamiento_de_pierna_lateral_derecha,
            rutina = "Leventamiento de pierna lateral derecha",
            reps = "10 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.estocada_hacia_atras,
            rutina = "Estocada hacie atras",
            reps = "10 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.squats,
            rutina = "Squats",
            reps = "10 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.estocada_hacia_atras,
            rutina = "Estocada hacia atras",
            reps = "10 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.donkey_kickis_izquierdo,
            rutina = "Donkey kicks izquierdo",
            reps = "10 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.donkey_kick_derecha,
            rutina = "Donkey kicks derecha",
            reps = "10 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.levantamiento_pierna_lateral_izquierda,
            rutina = "Levantamiento de pierna lateral izquierda",
            reps = "10 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.levantamiento_de_pierna_lateral_derecha,
            rutina = "Leventamiento de pierna lateral derecha",
            reps = "10 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.donkey_kickis_izquierdo,
            rutina = "Donkey kicks izquierdo",
            reps = "10 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.donkey_kick_derecha,
            rutina = "Donkey kicks derecha",
            reps = "10 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.levantamiento_de_pantorrilla,
            rutina = "Levantamiento de pantorrila con pared",
            reps = "10 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.levantamientos_de_pantorrilla_con_sentadilla_con_pared,
            rutina = "Levantamiento de pantorrilla con sentadilla con pared",
            reps = "10 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.levantamiento_de_pantorrilla,
            rutina = "Levantamiento de pantorrila con pared",
            reps = "10 repeticiones"
        ),
        Rutina(
            imageId = R.drawable.levantamientos_de_pantorrilla_con_sentadilla_con_pared,
            rutina = "Levantamiento de pantorrilla con sentadilla con pared",
            reps = "10 repeticiones"
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
            text = stringResource(id = R.string.nivel_principiante),
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
            text = stringResource(R.string.perdida_aprox_de_64_kcal),
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
fun PiernaPrincipianteComponentPreview() {
//    PiernaPrincipianteScreen()
}