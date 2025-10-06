package com.example.playground.design_systems.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.playground.design_systems.CustomTheme

@Composable
fun CustomTabRow(selectedTabIndex: Int, modifier: Modifier = Modifier, tabs: @Composable (Int) -> Unit) {
    Row(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(CustomTheme.colors.secondary)
            .padding(2.dp)
    ) {
        tabs(selectedTabIndex)
    }
}

@Composable
fun CustomTab(
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    text: String
) {
    val backgroundColor = if (selected) CustomTheme.colors.surface else CustomTheme.colors.secondary
    val contentColor = if (selected) CustomTheme.colors.primary else CustomTheme.colors.onSurface

    Box(
        modifier = modifier
            .clip(RoundedCornerShape(8.dp))
            .background(backgroundColor)
            .clickable(onClick = onClick)
            .padding(horizontal = 12.dp, vertical = 6.dp),
        contentAlignment = Alignment.Center
    ) {
        CustomText(text = text, color = contentColor)
    }
}