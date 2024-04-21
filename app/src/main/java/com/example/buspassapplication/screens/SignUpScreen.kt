package com.example.buspassapplication.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.buspassapplication.components.NormalText
import com.example.buspassapplication.components.OutlinedInputField
import com.example.buspassapplication.ui.theme.White

@ExperimentalMaterial3Api
@Composable
fun SignUpScreen () {
    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .padding(28.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NormalText( 
                value = "Hey there,",
                isSmall = true
            )
            NormalText(
                value = "Create an Account",
                isSmall = false
            )
            Row (
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                OutlinedInputField(label = AnnotatedString("First Name"))
                //OutlinedInputField(label = )
            }
        }
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun DefaultPreviewOfSignupScreeen() {
    SignUpScreen()
}