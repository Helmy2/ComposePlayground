package com.example.playground.design_systems.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.playground.design_systems.CustomTheme
import com.example.playground.design_systems.LocalCustomContentColor

@Composable
fun CustomCard(modifier: Modifier = Modifier, content: @Composable () -> Unit) {
    Column(
        modifier = modifier
            .clip(RoundedCornerShape(12.dp))
            .background(CustomTheme.colors.surface)
            .padding(16.dp)
    ) {
        CompositionLocalProvider(LocalCustomContentColor provides CustomTheme.colors.onSecondary) {
            content()
        }
    }
}