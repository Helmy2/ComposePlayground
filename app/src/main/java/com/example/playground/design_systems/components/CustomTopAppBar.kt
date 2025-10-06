package com.example.playground.design_systems.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.playground.design_systems.CustomTheme
import com.example.playground.design_systems.LocalCustomContentColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTopAppBar(title: String, navigationIcon: @Composable () -> Unit = {}) {
    TopAppBar(
        title = {
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                CustomText(text = title, style = CustomTheme.typography.title)
            }
        },
        navigationIcon = {
            CompositionLocalProvider(LocalCustomContentColor provides CustomTheme.colors.primary) {
                navigationIcon()
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = CustomTheme.colors.surface,
            titleContentColor = CustomTheme.colors.onSecondary
        )
    )
}