package com.example.buspassapplication.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.buspassapplication.ui.theme.DarkGray
import com.example.buspassapplication.ui.theme.LightGray
import com.example.buspassapplication.ui.theme.NavyBlue

@ExperimentalMaterial3Api
@Composable
fun OutLessTextField(
    defaultStartChar: String = "",
    value: String,
    onValueChanged: (String) -> Unit,
    modifier: Modifier,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    fontSize: TextUnit = 25.sp,
) {

        var textFieldWidth by remember { mutableStateOf(40.dp) }

        BasicTextField(
            modifier = Modifier
                .width(textFieldWidth)
                .padding(8.dp)
                .height(40.dp),
            value = value,
            onValueChange = onValueChanged,
            singleLine = true,
            textStyle = TextStyle(
                letterSpacing = 0.7.sp,
                fontSize = fontSize,
            ),
            keyboardOptions = keyboardOptions,
            keyboardActions = KeyboardActions.Default,
            onTextLayout = { textLayoutResult ->
                textFieldWidth = (value.length * 20).dp
            }
        )

}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun OutLessTextFieldPreview() {
    OutLessTextField(
        defaultStartChar = "",
        value = "Helloookkkk",
        onValueChanged = {},
        modifier = Modifier,
    )
}
