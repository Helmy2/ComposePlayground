package com.example.playground.design_systems.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.playground.design_systems.CustomTheme

@Composable
private fun CustomChipInternal(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    selected: Boolean,
    label: String
) {
    val backgroundColor = if (selected) CustomTheme.colors.primary else CustomTheme.colors.surface
    val contentColor = if (selected) CustomTheme.colors.onPrimary else CustomTheme.colors.onSurface
    val border = if (!selected) Modifier.border(1.dp, CustomTheme.colors.primary, CircleShape) else Modifier

    Box(
        modifier = modifier
            .clip(CircleShape)
            .background(backgroundColor)
            .then(border)
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        CustomText(text = label, color = contentColor)
    }
}

@Composable
fun CustomAssistChip(onClick: () -> Unit, modifier: Modifier = Modifier, label: String) {
    CustomChipInternal(
        onClick = onClick,
        modifier = modifier,
        selected = false,
        label = label
    )
}

@Composable
fun CustomFilterChip(selected: Boolean, onClick: () -> Unit, modifier: Modifier = Modifier, label: String) {
    CustomChipInternal(
        selected = selected,
        onClick = onClick,
        modifier = modifier,
        label = label
    )
}

@Composable
fun CustomInputChip(selected: Boolean, onClick: () -> Unit, modifier: Modifier = Modifier, label: String) {
    CustomChipInternal(
        selected = selected,
        onClick = onClick,
        modifier = modifier,
        label = label
    )
}

@Composable
fun CustomSuggestionChip(onClick: () -> Unit, modifier: Modifier = Modifier, label: String) {
    CustomChipInternal(
        onClick = onClick,
        modifier = modifier,
        selected = false,
        label = label
    )
}
