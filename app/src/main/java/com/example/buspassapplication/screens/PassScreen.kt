package com.example.buspassapplication.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.buspassapplication.components.Header
import com.example.buspassapplication.components.NavigationBar
import com.example.buspassapplication.components.PassScreenContent

@Composable
fun PassScreen(
    navController: NavController
) {
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

@Preview(showBackground = true)
@Composable
fun DefaultPreview () {
    PassScreen(navController = rememberNavController())
}