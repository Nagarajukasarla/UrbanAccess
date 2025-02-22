package com.example.buspassapplication.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.buspassapplication.ui.theme.LightGray
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.buspassapplication.enums.GenderEnum
import toResponsiveSp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GenderDropDown(
    label: String,
    options: List<GenderEnum>,
    value: String,
    onItemSelected: (String) -> Unit,
    modifier: Modifier = Modifier.fillMaxWidth(),
    isError: Boolean = false,
    errorMessage: String? = null,
    enabled: Boolean = true
) {
    var isExpanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf(value) }

    Column {
        ExposedDropdownMenuBox(
            expanded = isExpanded && enabled,
            onExpandedChange = { if (enabled) isExpanded = !isExpanded }
        ) {
            OutlinedTextField(
                modifier = modifier.menuAnchor(),
                value = selectedText,
                onValueChange = { },
                readOnly = true,
                enabled = enabled,
                label = {
                    Text(
                        text = label,
                        style = TextStyle(
                            letterSpacing = 0.3.toResponsiveSp()
                        )
                    )
                },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
                },
                isError = isError,
                colors = if (isError) {
                    OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Color.Red,
                        unfocusedBorderColor = Color.Red,
                        focusedLabelColor = Color.Red,
                        errorBorderColor = Color.Red,
                        disabledTextColor = LightGray,
                        disabledBorderColor = LightGray,
                        disabledLabelColor = LightGray
                    )
                } else {
                    OutlinedTextFieldDefaults.colors(
                        disabledTextColor = LightGray,
                        disabledBorderColor = LightGray,
                        disabledLabelColor = LightGray
                    )
                }
            )
            if (enabled) {
                ExposedDropdownMenu(
                    expanded = isExpanded,
                    onDismissRequest = { isExpanded = false }
                ) {
                    options.forEach { gender ->
                        DropdownMenuItem(
                            text = {
                                Text(text = gender.value)
                            },
                            onClick = {
                                selectedText = gender.value
                                onItemSelected(selectedText)
                                isExpanded = false
                            }
                        )
                    }
                }
            }
        }
        if (isError && errorMessage != null) {
            Text(
                text = errorMessage,
                color = Color.Red,
                fontSize = 12.sp,
                modifier = Modifier.padding(start = 16.dp)
            )
        }
    }
}