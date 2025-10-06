package com.example.playground.design_systems.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.playground.design_systems.CustomTheme

@Composable
fun CustomNavigationBarItem(
    selected: Boolean,
    onClick: () -> Unit,
    icon: @Composable (color: Color) -> Unit,
    label: String,
    modifier: Modifier = Modifier
) {
    val color = if (selected) CustomTheme.colors.primary else CustomTheme.colors.onSurface

    Column(
        modifier = modifier
            .clickable(
                onClick = onClick,
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            )
            .padding(vertical = 8.dp, horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        icon(color)
        Spacer(Modifier.height(4.dp))
        CustomText(text = label, color = color)
    }
}