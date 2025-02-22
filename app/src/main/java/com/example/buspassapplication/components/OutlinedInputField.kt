package com.example.buspassapplication.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import com.example.buspassapplication.ui.theme.DarkGray
import com.example.buspassapplication.ui.theme.LightGray
import com.example.buspassapplication.ui.theme.NavyBlue
import toResponsiveSp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
    textStyle : TextStyle = TextStyle(letterSpacing = 0.7.toResponsiveSp()),
    leadingIcon: @Composable (() -> Unit)? = null,
    isError: Boolean = false,
    errorMessage: String? = null
) {
    Column {
        OutlinedTextField(
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
                        letterSpacing = 0.3.toResponsiveSp()
                    )
                )
            },
            textStyle = textStyle,
            colors = if (isError) {
                OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = Color.Red,
                    unfocusedBorderColor = Color.Red,
                    focusedLabelColor = Color.Red,
                    errorBorderColor = Color.Red
                )
            } else {
                colors
            },
            singleLine = true,
            enabled = enabled,
            keyboardOptions = keyboardOptions,
            leadingIcon = leadingIcon,
            isError = isError
        )
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
