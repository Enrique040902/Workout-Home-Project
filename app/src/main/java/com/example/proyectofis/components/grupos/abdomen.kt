package com.example.proyectofis.components.grupos

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
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
        AbsComponent()
    }
}


@Composable
fun AbsComponent(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .shadow(
                elevation = 4.dp,
                shape = RoundedCornerShape(8.dp),
                spotColor = colorResource(id = R.color.lightColorPrimary)
            )
            .background(
                color = colorResource(id = R.color.lightColorPrimary),
                shape = RoundedCornerShape(8.dp)
            )
            .clickable { /* TODO */ },
        contentAlignment = Alignment.Center
    ) {
        ImageAbsComponent()

        Text(
            text = "Abs",
            style = TextStyle(
                fontSize = 38.sp,
                color = Color.DarkGray,
            )
        )
    }
}

@Composable
private fun ImageAbsComponent() {
    Image(
        modifier = Modifier
            .fillMaxSize()
            .blur(2.dp)
            .padding(4.dp),
        contentScale = ContentScale.Fit,
        painter = painterResource(id = R.drawable.abdominal_2),
        contentDescription = "Imagen de abdominal",
        alpha = 0.8f
    )
}

@Preview
@Composable
private fun AbsComponentPreview() {
    AbsComponent()
}

@Preview(showSystemUi = true)
@Composable
private fun MenuComponentPreview(){
    MenuComponent()
}