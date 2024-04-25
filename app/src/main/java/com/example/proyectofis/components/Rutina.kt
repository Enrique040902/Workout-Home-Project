package com.example.proyectofis.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectofis.R

@Composable
fun RutinaComponent(
    imageId: Int,
    rutina: String,
    reps: String
) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .height(100.dp)
            .background(
                color = colorResource(id = R.color.lightColorPrimary),
                shape = RoundedCornerShape(5.dp)
            )
            .clip(RoundedCornerShape(10.dp))
    ) {
        Image(
            painter = painterResource(id = imageId),
            contentDescription = null,
            modifier = Modifier.size(100.dp)
        )
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = rutina,
                style = TextStyle(
                    fontSize = 20.sp,
                )
            )
            Text(
                text = reps,
                style = TextStyle(
                    fontSize = 18.sp,
                )
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun RutinaComponentPreview() {
    RutinaComponent(
        imageId = R.drawable.brazo,
        rutina = "Rutinas de brazo",
        reps = "20 repeticiones"
    )
}