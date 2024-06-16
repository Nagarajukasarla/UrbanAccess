package com.example.buspassapplication.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import com.example.buspassapplication.components.NormalText
import com.example.buspassapplication.ui.theme.Black
import com.example.buspassapplication.ui.theme.PoppinsBold
import com.example.buspassapplication.ui.theme.White
import toResponsiveDp
import toResponsiveSp

@ExperimentalMaterial3Api
@Composable
fun WelcomeScreen(
    navController: NavHostController
) {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .padding(bottom = 15.toResponsiveDp())
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            NormalText(
                modifier = Modifier,
                value = "Welcome to Urban Access",
                fontSize = 22.toResponsiveSp(),
                fontWeight = FontWeight.Black,
                fontFamily = PoppinsBold,
                color = Black
            )
        }
    }
}

