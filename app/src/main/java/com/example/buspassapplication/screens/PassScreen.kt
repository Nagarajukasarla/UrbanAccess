package com.example.buspassapplication.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.buspassapplication.components.Header
import com.example.buspassapplication.components.NavigationBar
import com.example.buspassapplication.components.PassScreenContent

@Composable
fun PassScreen(
    navController: NavHostController
) {
    Surface {
        Column {
            Header()
            Box(
                modifier = Modifier.weight(1f)
            ) {
                Column (
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                        .padding(bottom = 30.dp)
                ) {
                    PassScreenContent()
                }
            }
            NavigationBar(navController = rememberNavController())
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview () {
    PassScreen(navController = rememberNavController())
}