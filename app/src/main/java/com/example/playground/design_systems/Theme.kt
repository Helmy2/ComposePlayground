package com.example.playground.design_systems

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Immutable
data class CustomColors(
    val primary: Color,
    val onPrimary: Color,
    val secondary: Color,
    val onSecondary: Color,
    val surface: Color,
    val onSurface: Color,
    val background: Color
)

@Immutable
data class CustomTypography(
    val body: TextStyle,
    val title: TextStyle,
    val headline: TextStyle
)

@Immutable
data class CustomElevation(
    val default: Dp,
    val pressed: Dp
)

// iOS Blue Palette
private val IOSBlueLightColors = CustomColors(
    primary = Color(0xFF007AFF),
    onPrimary = Color.White,
    secondary = Color(0xFFF2F2F7),
    onSecondary = Color.Black,
    surface = Color.White,
    onSurface = Color(0xFF8E8E93),
    background = Color(0xFFF2F2F7)
)

private val IOSBlueDarkColors = CustomColors(
    primary = Color(0xFF0A84FF),
    onPrimary = Color.White,
    secondary = Color(0xFF2C2C2E),
    onSecondary = Color.White,
    surface = Color(0xFF1C1C1E),
    onSurface = Color(0xFF8D8D93),
    background = Color(0xFF000000)
)

val LocalCustomColors = staticCompositionLocalOf {
    IOSBlueLightColors
}
val LocalCustomTypography = staticCompositionLocalOf {
    CustomTypography(
        body = TextStyle.Default,
        title = TextStyle.Default,
        headline = TextStyle.Default
    )
}
val LocalCustomElevation = staticCompositionLocalOf {
    CustomElevation(
        default = Dp.Unspecified,
        pressed = Dp.Unspecified
    )
}

val LocalCustomContentColor = staticCompositionLocalOf { Color.Unspecified }

@Composable
fun CustomTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val customColors = if (darkTheme) IOSBlueDarkColors else IOSBlueLightColors
    val customTypography = CustomTypography(
        body = TextStyle(fontSize = 16.sp),
        title = TextStyle(fontSize = 32.sp, fontWeight = FontWeight.Bold),
        headline = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
    )
    val customElevation = CustomElevation(
        default = 0.dp,
        pressed = 0.dp
    )
    CompositionLocalProvider(
        LocalCustomColors provides customColors,
        LocalCustomTypography provides customTypography,
        LocalCustomElevation provides customElevation,
        LocalCustomContentColor provides customColors.onSecondary,
        content = content
    )
}

object CustomTheme {
    val colors: CustomColors
        @Composable
        get() = LocalCustomColors.current
    val typography: CustomTypography
        @Composable
        get() = LocalCustomTypography.current
    val elevation: CustomElevation
        @Composable
        get() = LocalCustomElevation.current
    val contentColor: Color
        @Composable
        get() = LocalCustomContentColor.current
}