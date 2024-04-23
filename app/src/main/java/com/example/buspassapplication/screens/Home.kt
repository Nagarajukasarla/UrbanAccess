package com.example.buspassapplication.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.buspassapplication.R
import com.example.buspassapplication.components.Header
import com.example.buspassapplication.components.NavigationBar
import com.example.buspassapplication.components.PassScreenContent

@Composable
fun Home() {



    Surface {
        Column {
            Header()
            // Pass container
            PassScreenContent()
            // Pass container
            NavigationBar()
        }
    }
}

@Preview
@Composable
fun DefaultPreview () {
    Home()
}