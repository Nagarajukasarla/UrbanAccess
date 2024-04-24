package com.example.buspassapplication.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.buspassapplication.Screen
import com.example.buspassapplication.components.HeadingText
import com.example.buspassapplication.components.NormalText
import com.example.buspassapplication.components.OutlinedInputField
import com.example.buspassapplication.components.PasswordField
import com.example.buspassapplication.components.PrimaryButton
import com.example.buspassapplication.ui.theme.DarkGray
import com.example.buspassapplication.ui.theme.NavyBlue
import com.example.buspassapplication.ui.theme.PoppinsLight
import com.example.buspassapplication.ui.theme.PoppinsMedium

@ExperimentalMaterial3Api
@Composable
fun ForgotPasswordOTP(navController: NavController){

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
                value = "Verification",
                isSmall = false
            )
            Spacer(modifier = Modifier.height(20.dp))
            NormalText(
                value= "We have sent otp to your mail",
                fontSize = 15.sp,
                fontFamily = PoppinsLight,
                color = DarkGray,
                fontWeight = FontWeight.Normal,
                modifier = Modifier
            )
            NormalText(
                value= "please type the code here. ",
                fontSize = 15.sp,
                fontFamily = PoppinsLight,
                color = DarkGray,
                fontWeight = FontWeight.Normal,
                modifier = Modifier
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedInputField(
                label = AnnotatedString("One time password"),
                modifier = Modifier.width(330.dp)
            )
            Spacer(modifier = Modifier.height(25.dp))
            PrimaryButton(
                text = "Reset Password",
                width = 280.dp
            )

            NormalText(
                value = "< Back to Log in",
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = PoppinsMedium,
                color = NavyBlue,
                modifier = Modifier
            )

        }
    }

}

@ExperimentalMaterial3Api
@Preview
@Composable
fun LoginPasswordOTPPreview(){
    ForgotPasswordOTP(navController = rememberNavController())
}