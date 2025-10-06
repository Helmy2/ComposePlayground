package com.example.playground.design_systems.components

import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomDatePickerDialog(
    onDismissRequest: () -> Unit,
    onConfirm: () -> Unit
) {
    val datePickerState = rememberDatePickerState()
    DatePickerDialog(
        onDismissRequest = onDismissRequest,
        confirmButton = {
            CustomButton(onClick = onConfirm, text = "OK")
        },
        dismissButton = {
            CustomButton(onClick = onDismissRequest, text = "Cancel")
        }
    ) {
        CustomDatePicker(state = datePickerState)
    }
}