package com.example.playground.design_systems.components

import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import com.example.playground.design_systems.CustomTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomDatePicker(state: DatePickerState) {
    DatePicker(
        state = state,
        colors = DatePickerDefaults.colors(
            containerColor = CustomTheme.colors.surface,
            titleContentColor = CustomTheme.colors.onSurface,
            headlineContentColor = CustomTheme.colors.onSurface,
            weekdayContentColor = CustomTheme.colors.onSurface,
            subheadContentColor = CustomTheme.colors.onSurface,
            yearContentColor = CustomTheme.colors.onSurface,
            currentYearContentColor = CustomTheme.colors.primary,
            selectedYearContentColor = CustomTheme.colors.onPrimary,
            selectedYearContainerColor = CustomTheme.colors.primary,
            dayContentColor = CustomTheme.colors.onSurface,
            disabledDayContentColor = CustomTheme.colors.onSurface.copy(alpha = 0.5f),
            selectedDayContentColor = CustomTheme.colors.onPrimary,
            disabledSelectedDayContentColor = CustomTheme.colors.onPrimary.copy(alpha = 0.5f),
            selectedDayContainerColor = CustomTheme.colors.primary,
            disabledSelectedDayContainerColor = CustomTheme.colors.primary.copy(alpha = 0.5f),
            todayContentColor = CustomTheme.colors.primary,
            todayDateBorderColor = CustomTheme.colors.primary,
        )
    )
}