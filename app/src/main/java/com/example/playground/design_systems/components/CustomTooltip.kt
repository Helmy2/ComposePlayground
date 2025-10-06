package com.example.playground.design_systems.components

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupPositionProvider
import com.example.playground.design_systems.CustomTheme

@Composable
fun CustomTooltipBox(
    tooltipContent: @Composable () -> Unit,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    var showTooltip by remember { mutableStateOf(false) }
    var pressPosition by remember { mutableStateOf<androidx.compose.ui.geometry.Offset?>(null) }

    Box(
        modifier = modifier.pointerInput(Unit) {
            detectTapGestures(
                onLongPress = { offset ->
                    pressPosition = offset
                    showTooltip = true
                },
                onPress = {
                    tryAwaitRelease()
                    showTooltip = false
                }
            )
        }
    ) {
        content()
        if (showTooltip) {
            Popup(
                onDismissRequest = { showTooltip = false },
                popupPositionProvider = object : PopupPositionProvider {
                    override fun calculatePosition(
                        anchorBounds: androidx.compose.ui.unit.IntRect,
                        windowSize: androidx.compose.ui.unit.IntSize,
                        layoutDirection: androidx.compose.ui.unit.LayoutDirection,
                        popupContentSize: androidx.compose.ui.unit.IntSize
                    ): androidx.compose.ui.unit.IntOffset {
                        val pressX = pressPosition?.x?.toInt() ?: 0
                        val x = anchorBounds.left + pressX - (popupContentSize.width / 2)
                        val y = anchorBounds.top - popupContentSize.height - 32
                        
                        return androidx.compose.ui.unit.IntOffset(
                            x.coerceIn(0, windowSize.width - popupContentSize.width),
                            y.coerceAtLeast(0)
                        )
                    }
                }
            ) {
                Surface(
                    shape = RoundedCornerShape(4.dp),
                    color = CustomTheme.colors.surface,
                    contentColor = CustomTheme.colors.onSurface,
                    shadowElevation = CustomTheme.elevation.default
                ) {
                    Box(modifier = Modifier.padding(8.dp)) {
                        tooltipContent()
                    }
                }
            }
        }
    }
}
