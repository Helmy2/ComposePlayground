package com.example.playground.design_systems.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animate
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp
import com.example.playground.design_systems.CustomTheme
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun CustomCircularProgressIndicator(modifier: Modifier = Modifier) {
    var rotation by remember { mutableStateOf(0f) }

    LaunchedEffect(Unit) {
        animate(0f, 360f, animationSpec = infiniteRepeatable(tween(1000, easing = LinearEasing))) {
            value, _ ->
            rotation = value
        }
    }

    val color = CustomTheme.colors.primary

    Canvas(modifier = modifier.size(24.dp)) {
        val radius = size.minDimension / 2f
        val strokeWidth = radius / 4f
        val numLines = 12

        for (i in 0 until numLines) {
            val angle = (i * 30f + rotation) * (Math.PI / 180f).toFloat()
            val alpha = (i + 1) / numLines.toFloat()

            drawLine(
                color = color.copy(alpha = alpha),
                start = Offset(center.x + (radius - strokeWidth) * cos(angle), center.y + (radius - strokeWidth) * sin(angle)),
                end = Offset(center.x + radius * cos(angle), center.y + radius * sin(angle)),
                strokeWidth = strokeWidth,
                cap = StrokeCap.Round
            )
        }
    }
}