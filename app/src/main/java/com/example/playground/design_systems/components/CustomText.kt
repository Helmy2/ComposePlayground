package com.example.playground.design_systems.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import com.example.playground.design_systems.CustomTheme

@Composable
fun CustomText(text: String, modifier: Modifier = Modifier, color: Color =  CustomTheme.colors.onSurface, style: TextStyle = CustomTheme.typography.body) {
    Text(
        text = text,
        modifier = modifier,
        style = style,
        color = color
    )
}