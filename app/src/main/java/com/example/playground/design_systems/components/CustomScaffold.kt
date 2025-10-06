package com.example.playground.design_systems.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.example.playground.design_systems.CustomTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomScaffold(
    title: String,
    navigationIcon: @Composable () -> Unit = {},
    bottomBar: @Composable () -> Unit = {},
    snackbarHost: @Composable () -> Unit = {},
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        topBar = { CustomTopAppBar(title = title, navigationIcon = navigationIcon) },
        bottomBar = bottomBar,
        snackbarHost = snackbarHost,
        containerColor = CustomTheme.colors.background
    ) {
        content(it)
    }
}