package com.example.buspassapplication.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.buspassapplication.components.NormalText
import com.example.buspassapplication.ui.theme.White

@Composable
fun LoginScreen(){
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(28.dp)
    ){
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NormalText(
                value = "Hey!",
                isSmall = true
            )
            NormalText(
                value = "Welcome again!",
                isSmall = false
            )
            
        }
    }
}

@Preview
@Composable
fun LoginPreview(){
    LoginScreen()
}