package com.example.buspassapplication.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import com.example.buspassapplication.ui.theme.Black
import com.example.buspassapplication.ui.theme.DarkGray
import com.example.buspassapplication.ui.theme.NavyBlue

@ExperimentalMaterial3Api
@Composable
fun OutlinedInputField (
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier,
    label: String,
    enabled: Boolean = true
) {

    OutlinedTextField (
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(
                text = label,
                style = TextStyle(
                    letterSpacing = 0.3.sp
                )
            )
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = NavyBlue,
            focusedLabelColor = NavyBlue,
            cursorColor = DarkGray,
            focusedSupportingTextColor = Black,
            textColor = Black
        ),
        textStyle = TextStyle(
            letterSpacing = 0.7.sp
        ),
        singleLine = true,
        enabled = enabled
    )
}