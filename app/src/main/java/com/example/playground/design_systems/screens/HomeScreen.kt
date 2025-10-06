package com.example.playground.design_systems.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.playground.design_systems.components.ButtonStyle
import com.example.playground.design_systems.components.CustomAssistChip
import com.example.playground.design_systems.components.CustomButton
import com.example.playground.design_systems.components.CustomCard
import com.example.playground.design_systems.components.CustomCheckbox
import com.example.playground.design_systems.components.CustomCircularProgressIndicator
import com.example.playground.design_systems.components.CustomDatePickerDialog
import com.example.playground.design_systems.components.CustomDialog
import com.example.playground.design_systems.components.CustomDropdownMenu
import com.example.playground.design_systems.components.CustomDropdownMenuItem
import com.example.playground.design_systems.components.CustomExposedDropdownMenuBox
import com.example.playground.design_systems.components.CustomFilterChip
import com.example.playground.design_systems.components.CustomInputChip
import com.example.playground.design_systems.components.CustomModalBottomSheet
import com.example.playground.design_systems.components.CustomRadioButton
import com.example.playground.design_systems.components.CustomSlider
import com.example.playground.design_systems.components.CustomSuggestionChip
import com.example.playground.design_systems.components.CustomSwitch
import com.example.playground.design_systems.components.CustomTab
import com.example.playground.design_systems.components.CustomTabRow
import com.example.playground.design_systems.components.CustomText
import com.example.playground.design_systems.components.CustomTextField
import com.example.playground.design_systems.components.CustomTimePickerDialog
import com.example.playground.design_systems.components.CustomTooltipBox
import com.example.playground.design_systems.CustomTheme

@Composable
fun HomeScreen(showSnackbar: (String) -> Unit, modifier: Modifier = Modifier) {
    var showBottomSheet by remember { mutableStateOf(false) }
    var showDialog by remember { mutableStateOf(false) }
    var showDatePicker by remember { mutableStateOf(false) }
    var showTimePicker by remember { mutableStateOf(false) }
    var dropdownExpanded by remember { mutableStateOf(false) }
    val dropdownOptions = listOf("Option A", "Option B", "Option C")
    var selectedDropdownOption by remember { mutableStateOf(dropdownOptions[0]) }

    Column(modifier = modifier.fillMaxSize()) {
        var selectedTabIndex by remember { mutableStateOf(0) }
        CustomTabRow(selectedTabIndex = selectedTabIndex) { selectedIndex ->
            CustomTab(selected = selectedIndex == 0, onClick = { selectedTabIndex = 0 }, text = "Controls")
            CustomTab(selected = selectedIndex == 1, onClick = { selectedTabIndex = 1 }, text = "Other")
        }
        when (selectedTabIndex) {
            0 -> {
                LazyColumn(
                    modifier = Modifier.padding(16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    item {
                        CustomCard {
                            Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                                CustomText(text = "Selection Controls", style = CustomTheme.typography.headline)
                                var checked by remember { mutableStateOf(false) }
                                var selectedOption by remember { mutableStateOf("Option 1") }
                                var switchState by remember { mutableStateOf(false) }

                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    CustomText(text = "Checkbox")
                                    CustomCheckbox(checked = checked, onCheckedChange = { checked = it })
                                }

                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    CustomText(text = "Radio Buttons")
                                    Row(verticalAlignment = Alignment.CenterVertically) {
                                        CustomRadioButton(
                                            selected = selectedOption == "Option 1",
                                            onClick = { selectedOption = "Option 1" }
                                        )
                                        CustomText(text = "Option 1")
                                        CustomRadioButton(
                                            selected = selectedOption == "Option 2",
                                            onClick = { selectedOption = "Option 2" }
                                        )
                                        CustomText(text = "Option 2")
                                    }
                                }

                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    modifier = Modifier.fillMaxWidth()
                                ) {
                                    CustomText(text = "Switch")
                                    CustomSwitch(checked = switchState, onCheckedChange = { switchState = it })
                                }
                            }
                        }
                    }
                    item {
                        CustomCard {
                            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                CustomText(text = "Sliders & Menus", style = CustomTheme.typography.headline)
                                var sliderValue by remember { mutableStateOf(0.5f) }

                                CustomSlider(value = sliderValue, onValueChange = { sliderValue = it })

                                CustomExposedDropdownMenuBox(
                                    expanded = dropdownExpanded,
                                    onExpandedChange = { dropdownExpanded = !dropdownExpanded }
                                ) { modifier ->
                                    CustomTextField(
                                        value = selectedDropdownOption,
                                        onValueChange = {},
                                        readOnly = true,
                                        modifier = modifier
                                    )
                                    CustomDropdownMenu(
                                        expanded = dropdownExpanded,
                                        onDismissRequest = { dropdownExpanded = false }
                                    ) {
                                        dropdownOptions.forEach { selectionOption ->
                                            CustomDropdownMenuItem(
                                                text = selectionOption,
                                                onClick = {
                                                    selectedDropdownOption = selectionOption
                                                    dropdownExpanded = false
                                                }
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                    item {
                        CustomCard {
                            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                CustomText(text = "Chips", style = CustomTheme.typography.headline)
                                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                    CustomAssistChip(onClick = { }, label = "Assist")
                                    CustomFilterChip(selected = true, onClick = { }, label = "Filter")
                                    CustomInputChip(selected = true, onClick = { }, label = "Input")
                                    CustomSuggestionChip(onClick = { }, label = "Suggestion")
                                }
                            }
                        }
                    }
                    item {
                        CustomCard {
                            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                CustomText(text = "Actions", style = CustomTheme.typography.headline)
                                CustomTooltipBox(
                                    tooltipContent = { CustomText("This is a tooltip") }
                                ) {
                                    CustomButton(onClick = { showBottomSheet = true }, text = "Show Bottom Sheet")
                                }

                                CustomButton(onClick = { showDialog = true }, style = ButtonStyle.GRAY, text = "Show Dialog")
                                CustomButton(onClick = { showDatePicker = true }, style = ButtonStyle.GRAY, text = "Show Date Picker")
                                CustomButton(onClick = { showTimePicker = true }, style = ButtonStyle.GRAY, text = "Show Time Picker")
                                CustomButton(onClick = { showSnackbar("This is a snackbar") }, style = ButtonStyle.BORDERLESS, text = "Show Snackbar")
                            }
                        }
                    }
                    item {
                        CustomCard {
                            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                                CustomText(text = "Indicators", style = CustomTheme.typography.headline)
                                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                    CustomCircularProgressIndicator()
                                }
                            }
                        }
                    }
                }
            }

            1 -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    CustomText(text = "Other content goes here")
                }
            }
        }
    }

    if (showBottomSheet) {
        CustomModalBottomSheet(onDismissRequest = { showBottomSheet = false }) {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                CustomText(text = "This is a bottom sheet")
            }
        }
    }

    if (showDialog) {
        CustomDialog(
            onDismissRequest = { showDialog = false },
            title = "Dialog Title",
            text = "This is the content of the dialog.",
            confirmButtonText = "OK",
            onConfirm = { showDialog = false },
            dismissButtonText = "Cancel",
            onDismiss = { showDialog = false }
        )
    }

    if (showDatePicker) {
        CustomDatePickerDialog(
            onDismissRequest = { showDatePicker = false },
            onConfirm = { showDatePicker = false }
        )
    }

    if (showTimePicker) {
        CustomTimePickerDialog(
            onDismissRequest = { showTimePicker = false },
            onConfirm = { showTimePicker = false }
        )
    }
}