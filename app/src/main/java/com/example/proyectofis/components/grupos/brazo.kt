package com.example.proyectofis.components.grupos

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectofis.R

@Composable
private fun MenuComponent(){
    Column(
        modifier = Modifier
            .padding(16.dp)
    ) {
        BrazoComponent()
    }
}


@Composable
fun BrazoComponent(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(8.dp),
                spotColor = colorResource(id = R.color.lightColorPrimary)
            )
            .background(
                colorResource(id = R.color.lightColorPrimary),
                shape = RoundedCornerShape(8.dp)
            )
            .clickable { /* TODO */ },
        contentAlignment = Alignment.Center
    ) {
        ImageBrazoComponent()

        Text(
            text = "Brazo",
            style = TextStyle(
                fontSize = 38.sp,
                color = Color.DarkGray,
            )
        )
    }
}

@Composable
private fun ImageBrazoComponent() {
    Image(
        modifier = Modifier
            .fillMaxSize()
            .blur(2.dp)
            .padding(4.dp),
        contentScale = ContentScale.FillWidth,
        painter = painterResource(id = R.drawable.brazo),
        contentDescription = "Imagen de brazo",
        alpha = 0.8f
    )
}

@Preview
@Composable
private fun BrazoComponentPreview() {
    BrazoComponent()
}

@Preview(showSystemUi = true)
@Composable
private fun MenuComponentPreview(){
    MenuComponent()
}