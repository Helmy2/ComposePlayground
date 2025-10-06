package com.example.playground.design_systems.components

import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

@Composable
fun rememberCustomSnackbarHostState(): SnackbarHostState {
    return remember { SnackbarHostState() }
}

@Composable
fun CustomSnackbarHost(hostState: SnackbarHostState) {
    SnackbarHost(hostState = hostState)
}