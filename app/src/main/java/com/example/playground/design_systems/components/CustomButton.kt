package com.example.playground.design_systems.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.playground.design_systems.CustomTheme

enum class ButtonStyle {
    FILLED,
    GRAY,
    BORDERLESS
}

@Composable
fun CustomButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    style: ButtonStyle = ButtonStyle.FILLED,
    text: String
) {
    val backgroundColor = when (style) {
        ButtonStyle.FILLED -> CustomTheme.colors.primary
        ButtonStyle.GRAY -> CustomTheme.colors.secondary
        ButtonStyle.BORDERLESS -> Color.Transparent
    }
    val contentColor = when (style) {
        ButtonStyle.FILLED -> CustomTheme.colors.onPrimary
        ButtonStyle.GRAY -> CustomTheme.colors.onSecondary
        ButtonStyle.BORDERLESS -> CustomTheme.colors.primary
    }

    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(backgroundColor)
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp, vertical = 8.dp),
        contentAlignment = Alignment.Center
    ) {
        CustomText(text = text, color = contentColor)
    }
}