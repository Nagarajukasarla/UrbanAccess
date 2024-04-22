package com.example.buspassapplication.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.buspassapplication.components.HeadingText
import com.example.buspassapplication.components.MyButton
import com.example.buspassapplication.components.NormalText
import com.example.buspassapplication.components.OutlinedInputField
import com.example.buspassapplication.components.PasswordField
import com.example.buspassapplication.ui.theme.DarkGray
import com.example.buspassapplication.ui.theme.NavyBlue
import com.example.buspassapplication.ui.theme.PoppinsMedium

@ExperimentalMaterial3Api
@Composable
fun LoginScreen(){

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent)
            .padding(28.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            HeadingText(
                value = "Hey there,",
                isSmall = true
            )
            HeadingText(
                value = "Welcome back!",
                isSmall = false
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedInputField(
                label = AnnotatedString("Email"),
                modifier = Modifier.width(330.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            PasswordField(
                modifier = Modifier.width(330.dp),
                label = AnnotatedString("Password"),
            )
            Spacer(modifier = Modifier.height(25.dp))
            Row {
                NormalText(
                    value= AnnotatedString("Forgot password? "),
                    fontSize = 15.sp,
                    fontFamily = PoppinsMedium,
                    color = DarkGray,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier
                )
                NormalText(
                    value= AnnotatedString("Reset"),
                    fontSize = 15.sp,
                    fontFamily = PoppinsMedium,
                    color = NavyBlue,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier
                )
            }
            Spacer(modifier = Modifier.height(25.dp))
            MyButton(
                text = AnnotatedString("Submit"),
                width = 280.dp
            )
            Row {
                NormalText(
                    value = AnnotatedString("Not a member? "),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = PoppinsMedium,
                    color = DarkGray,
                    modifier = Modifier

                )
                NormalText(
                    value = AnnotatedString("Signup"),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = PoppinsMedium,
                    color = NavyBlue,
                    modifier = Modifier

                )
            }
        }
    }

}

@ExperimentalMaterial3Api
@Preview
@Composable
fun LoginPreview(){
    LoginScreen()
}