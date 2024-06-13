package com.example.buspassapplication.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.buspassapplication.components.PassScreenContent

@Composable
fun PassScreen(
    navController: NavHostController,
    currentUserId: String?
) {
    Surface {
        Column {
            Box {
                Column(
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                ) {
                    PassScreenContent(navController = navController, currentUserId = currentUserId)
                }
            }
        }
    }
}
