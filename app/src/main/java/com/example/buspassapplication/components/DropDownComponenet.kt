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
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.buspassapplication.ui.theme.DarkGray
import com.example.buspassapplication.ui.theme.NavyBlue
import com.example.buspassapplication.components.OutlinedInputField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropDown(
    options: List<String>,
    value: String,
    onItemSelected: (String) -> Unit
){
    val list = options
    var isExpanded by remember {
        mutableStateOf(false)
    }
    var selectedText by remember {
        mutableStateOf(value)
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding()
        , horizontalAlignment = Alignment.CenterHorizontally
    ){
        ExposedDropdownMenuBox(
            expanded = isExpanded,
            onExpandedChange = {isExpanded = !isExpanded}
        )
        {
            OutlinedTextField(
                modifier = Modifier.menuAnchor(),
                value = selectedText, onValueChange = onItemSelected,
                readOnly = true,
                label = {
                    Text(
                        text = "Gender",
                        style = TextStyle(
                            letterSpacing = 0.3.sp
                        )
                    )
                },
                textStyle = TextStyle(
                    letterSpacing = 0.7.sp,
                    color = DarkGray
                ),
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded)
                },
                singleLine = true,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = NavyBlue,
                    focusedLabelColor = NavyBlue,
                    cursorColor = DarkGray,
                    focusedSupportingTextColor = Color.Black,
                    textColor = Color.Black
                )
            )
            ExposedDropdownMenu(
                expanded = isExpanded,
                onDismissRequest = { isExpanded=false}) {
                list.forEachIndexed { index, text ->
                    DropdownMenuItem(
                        text={
                            Text(
                                text=text,
                                style = TextStyle(fontSize = 16.sp)) },
                        onClick = { selectedText=list[index]
                                    isExpanded=false},
                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding)
                }

            }
        }

    }
}