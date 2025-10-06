package com.example.playground.design_systems.components

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.playground.design_systems.CustomTheme

@Composable
fun CustomCheckbox(checked: Boolean, onCheckedChange: (Boolean) -> Unit, modifier: Modifier = Modifier) {
    val color = if (checked) CustomTheme.colors.primary else CustomTheme.colors.onSurface

    Box(
        modifier = modifier
            .size(24.dp)
            .clip(RoundedCornerShape(4.dp))
            .border(2.dp, color, RoundedCornerShape(4.dp))
            .clickable(
                onClick = { onCheckedChange(!checked) },
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ),
        contentAlignment = Alignment.Center
    ) {
        if (checked) {
            CustomIcon(imageVector = Icons.Default.Check, contentDescription = "Checked", tint = color)
        }
    }
}