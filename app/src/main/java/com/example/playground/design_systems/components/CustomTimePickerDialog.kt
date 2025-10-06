package com.example.playground.design_systems.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTimePickerDialog(
    onDismissRequest: () -> Unit,
    onConfirm: () -> Unit
) {
    val timePickerState = rememberTimePickerState()
    TimePickerDialog(
        onDismissRequest = onDismissRequest,
        confirmButton = {
            CustomButton(onClick = onConfirm, text = "OK")
        },
        dismissButton = {
            CustomButton(onClick = onDismissRequest, text = "Cancel")
        }
    ) {
        TimePicker(state = timePickerState)
    }
}