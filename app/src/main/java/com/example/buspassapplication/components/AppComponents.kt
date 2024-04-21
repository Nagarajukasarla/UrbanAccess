package com.example.buspassapplication.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.buspassapplication.ui.theme.DarkGray
import com.example.buspassapplication.ui.theme.NavyBlue
import com.example.buspassapplication.ui.theme.TextColor

@Composable
fun NormalText(
    value: String,
    isSmall: Boolean
) {
    Text(
        text = AnnotatedString(value),
        modifier = Modifier
            .fillMaxWidth(),
        style = if(isSmall) MaterialTheme.typography.titleSmall else MaterialTheme.typography.titleLarge,
        color = TextColor,
        textAlign = TextAlign.Center
    )
}

@ExperimentalMaterial3Api
@Composable
fun OutlinedInputField (
    label: AnnotatedString
) {

    var textValue by rememberSaveable { mutableStateOf("") }

    OutlinedTextField(
        modifier = Modifier.width(200.dp),
        value = textValue,
        onValueChange = { textValue = it },
        label = {
            Text(text = label)
        },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = NavyBlue,
            focusedLabelColor = NavyBlue,
            cursorColor = DarkGray
        ),
        singleLine = true
    )
}