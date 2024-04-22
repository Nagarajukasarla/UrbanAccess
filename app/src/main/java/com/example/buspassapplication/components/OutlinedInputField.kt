package com.example.buspassapplication.components

import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.buspassapplication.ui.theme.DarkGray
import com.example.buspassapplication.ui.theme.NavyBlue

@ExperimentalMaterial3Api
@Composable
fun OutlinedInputField (
    modifier: Modifier,
    label: AnnotatedString,
) {

    var textValue by rememberSaveable { mutableStateOf("") }

    OutlinedTextField(
        modifier = modifier,
        value = textValue,
        onValueChange = { textValue = it },
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
            cursorColor = DarkGray
        ),
        textStyle = TextStyle(
            letterSpacing = 0.4.sp
        ),
        singleLine = true
    )
}