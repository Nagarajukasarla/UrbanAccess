package com.example.buspassapplication.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.example.buspassapplication.ui.theme.AshGary
import com.example.buspassapplication.ui.theme.CloudGray
import com.example.buspassapplication.ui.theme.DarkGray
import com.example.buspassapplication.ui.theme.DimGray
import com.example.buspassapplication.ui.theme.LightGray
import com.example.buspassapplication.ui.theme.NavyBlue

@ExperimentalMaterial3Api
@Composable
fun OutlinedInputField (
    defaultStartChar: String="",
    value: String,
    onValueChanged: (String) -> Unit,
    modifier: Modifier,
    label: String,
    enabled: Boolean = true,
    colors : TextFieldColors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = NavyBlue,
    focusedLabelColor = NavyBlue,
    cursorColor = DarkGray,
    disabledLabelColor = LightGray,
    disabledTextColor = LightGray,
    disabledBorderColor = LightGray
),
    keyboardOptions : KeyboardOptions = KeyboardOptions.Default,
    textStyle : TextStyle = TextStyle(letterSpacing = 0.7.sp,
    ),
    leadingIcon: @Composable (() -> Unit)? = null
) {
    OutlinedTextField (
        modifier = modifier,
        value =  if (value.isEmpty()) defaultStartChar else value,
        onValueChange = { newValue ->
            if (newValue.startsWith(defaultStartChar)) {
                    onValueChanged(newValue)
            }
        },
        label = {
            Text(
                text = label,
                style = TextStyle(
                    letterSpacing = 0.3.sp
                )
            )
        },
        textStyle =textStyle,
        colors = colors,
        singleLine = true,
        enabled = enabled,
        keyboardOptions = keyboardOptions,
        leadingIcon = leadingIcon
    )
}
