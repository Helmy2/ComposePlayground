package com.example.playground.design_systems

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.playground.design_systems.components.CustomIcon
import com.example.playground.design_systems.components.CustomNavigationBar
import com.example.playground.design_systems.components.CustomNavigationBarItem
import com.example.playground.design_systems.components.CustomScaffold
import com.example.playground.design_systems.components.CustomSnackbarHost
import com.example.playground.design_systems.components.rememberCustomSnackbarHostState
import com.example.playground.design_systems.screens.HomeScreen
import com.example.playground.design_systems.screens.SettingsScreen
import kotlinx.coroutines.launch

@Composable
fun DesignSystemScreen() {
    val isSystemInDarkTheme = isSystemInDarkTheme()
    var isDark by remember { mutableStateOf(isSystemInDarkTheme) }

    CustomTheme(darkTheme = isDark) {
        var currentScreen by remember { mutableStateOf("Design System") }
        val snackbarHostState = rememberCustomSnackbarHostState()
        val scope = rememberCoroutineScope()

        val showSnackbar: (String) -> Unit = {
            scope.launch {
                snackbarHostState.showSnackbar(it)
            }
        }

        CustomScaffold(
            title = currentScreen,
            bottomBar = {
                CustomNavigationBar {
                    CustomNavigationBarItem(
                        selected = currentScreen == "Design System",
                        onClick = { currentScreen = "Design System" },
                        icon = { color: Color -> CustomIcon(imageVector = Icons.Default.Home, contentDescription = "Design System", tint = color) },
                        label = "Design System"
                    )
                    CustomNavigationBarItem(
                        selected = currentScreen == "Settings",
                        onClick = { currentScreen = "Settings" },
                        icon = { color: Color -> CustomIcon(imageVector = Icons.Default.Settings, contentDescription = "Settings", tint = color) },
                        label = "Settings"
                    )
                }
            },
            snackbarHost = { CustomSnackbarHost(hostState = snackbarHostState) }
        ) { paddingValues ->
            when (currentScreen) {
                "Design System" -> HomeScreen(
                    showSnackbar = showSnackbar,
                    modifier = Modifier.padding(paddingValues)
                )
                "Settings" -> SettingsScreen(
                    paddingValues = paddingValues,
                    darkTheme = isDark,
                    onThemeChange = { isDark = it }
                )
            }
        }
    }
}