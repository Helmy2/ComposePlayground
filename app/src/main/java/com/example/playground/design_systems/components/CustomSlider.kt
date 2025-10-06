package com.example.playground.design_systems.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import com.example.playground.design_systems.CustomTheme
import kotlin.math.roundToInt

@Composable
fun CustomSlider(value: Float, onValueChange: (Float) -> Unit, modifier: Modifier = Modifier) {
    var width by remember { mutableStateOf(0f) }
    val trackColor = CustomTheme.colors.onSurface.copy(alpha = 0.5f)
    val activeTrackColor = CustomTheme.colors.primary

    Box(modifier = modifier
        .fillMaxWidth()
        .height(20.dp)
        .onSizeChanged { width = it.width.toFloat() }
    ) {
        Canvas(modifier = Modifier.fillMaxWidth().height(2.dp)) {
            val trackWidth = size.width

            drawLine(
                color = trackColor,
                start = Offset(0f, center.y),
                end = Offset(trackWidth, center.y),
                strokeWidth = 2f
            )

            drawLine(
                color = activeTrackColor,
                start = Offset(0f, center.y),
                end = Offset(trackWidth * value, center.y),
                strokeWidth = 2f
            )
        }
        Canvas(
            modifier = Modifier
                .size(20.dp)
                .offset { IntOffset((value * width).roundToInt() - 10, 0) }
                .clip(CircleShape)
                .pointerInput(Unit) {
                    detectDragGestures {
                        change, _ ->
                        if (width > 0) {
                            val dragPosition = change.position.x
                            onValueChange((dragPosition / width).coerceIn(0f, 1f))
                            change.consume()
                        }
                    }
                }
        ) { drawCircle(Color.White) }
    }
}