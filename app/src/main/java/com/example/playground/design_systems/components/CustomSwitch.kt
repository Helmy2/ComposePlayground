package com.example.playground.design_systems.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.playground.design_systems.CustomTheme

@Composable
fun CustomSwitch(
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    val trackColor by animateColorAsState(if (checked) CustomTheme.colors.primary else CustomTheme.colors.onSurface)
    val thumbColor by animateColorAsState(if (checked) CustomTheme.colors.onPrimary else CustomTheme.colors.surface)
    val thumbPosition by animateDpAsState(if (checked) 20.dp else 0.dp)

    Box(
        modifier = modifier
            .width(51.dp)
            .height(31.dp)
            .clip(CircleShape)
            .background(trackColor)
            .clickable(
                onClick = { onCheckedChange(!checked) },
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            )
    ) {
        Box(
            modifier = Modifier
                .size(27.dp)
                .offset(x = thumbPosition, y = 2.dp)
                .clip(CircleShape)
                .background(thumbColor)
        )
    }
}
