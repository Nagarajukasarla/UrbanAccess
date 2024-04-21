package com.example.buspassapplication.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.buspassapplication.ui.theme.NavyBlue
import com.example.buspassapplication.ui.theme.White

@ExperimentalMaterial3Api
@Composable
fun MyButton() {
    Button(
        onClick = {
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor = White,
            containerColor = NavyBlue
        )
    ) {
        NormalText(value = "Submit",isSmall=true)
    }
}