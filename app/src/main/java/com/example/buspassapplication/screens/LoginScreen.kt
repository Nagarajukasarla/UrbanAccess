package com.example.buspassapplication.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.buspassapplication.components.MyButton
import com.example.buspassapplication.components.NormalText
import com.example.buspassapplication.components.OutlinedInputField
import com.example.buspassapplication.ui.theme.NavyBlue
import com.example.buspassapplication.ui.theme.ShinyBlue
import com.example.buspassapplication.ui.theme.White



    val annotatedString = buildAnnotatedString {
        withStyle(style = androidx.compose.ui.text.SpanStyle(color = Color.Black)) {
            append("Not a Member?")
        }
        withStyle(style = androidx.compose.ui.text.SpanStyle(color = ShinyBlue)) {
            append("Sign up.")
        }
    }


@OptIn(ExperimentalMaterial3Api::class)
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
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(modifier = Modifier
                .width(350.dp)
                .height(400.dp)
                .background(
                    color = White,
                    shape = MaterialTheme.shapes.medium
                )
            ){
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ){
            NormalText(
                value = "Hey!",
                isSmall = true
            )
            NormalText(
                value = "Welcome again!",
                isSmall = false
            )
            OutlinedInputField(label = AnnotatedString("Email"))
            OutlinedInputField(label = AnnotatedString("Password"))
            Spacer(modifier = Modifier.width(20.dp))
            NormalText(
                value="forgot password?",
                isSmall = true
            )
            MyButton()
            Text(text = annotatedString)
        }}
        }
    }

}

@Preview
@Composable
fun LoginPreview(){
    LoginScreen()
}