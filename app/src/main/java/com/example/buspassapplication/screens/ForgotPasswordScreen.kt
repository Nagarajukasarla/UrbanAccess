package com.example.buspassapplication.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.buspassapplication.components.HeadingText
import com.example.buspassapplication.components.NormalText
import com.example.buspassapplication.components.OutlinedInputField
import com.example.buspassapplication.components.PrimaryButton
import com.example.buspassapplication.ui.theme.DarkGray
import com.example.buspassapplication.ui.theme.NavyBlue
import com.example.buspassapplication.ui.theme.PoppinsLight
import com.example.buspassapplication.ui.theme.PoppinsMedium
import com.example.buspassapplication.ui.theme.White

@ExperimentalMaterial3Api
@Composable
fun ForgotPasswordScreen (navController: NavController){
    var isContentVisible by remember {
        mutableStateOf(false)
    }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent)
            .padding(18.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            HeadingText(value = "Password Recovery")
            Spacer(modifier = Modifier.height(20.dp))
            NormalText(
                value= "Enter your email and we'll send you instructions",
                fontSize = 15.sp,
                fontFamily = PoppinsLight,
                color = DarkGray,
                fontWeight = FontWeight.Normal,
                modifier = Modifier
            )
            NormalText(
                value= "to reset password. ",
                fontSize = 15.sp,
                fontFamily = PoppinsLight,
                color = DarkGray,
                fontWeight = FontWeight.Normal,
                modifier = Modifier
            )
            Spacer(modifier = Modifier.height(20.dp))
            OutlinedInputField(
                label = "Email",
                modifier = Modifier.width(330.dp)
            )
            Spacer(modifier = Modifier.height(25.dp))
            Button(
                onClick = {
                    isContentVisible = !isContentVisible
                },
                modifier = Modifier
                    .width(280.dp)
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                colors = ButtonDefaults.buttonColors(
                    contentColor = White,
                    containerColor = NavyBlue
                )
            ) {
                NormalText(
                    value = "Log in",
                    fontSize = 17.sp,
                    fontWeight = FontWeight(18),
                    fontFamily = PoppinsMedium,
                    color = White,
                    letterSpacing = 0.5.sp,
                    modifier = Modifier
                )
            }
                NormalText(
                    value = "< Back to Log in",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = PoppinsMedium,
                    color = NavyBlue,
                    modifier = Modifier
                )
            Spacer(modifier = Modifier.height(20.dp))
            if(isContentVisible){
                HeadingText(
                    value = "Verification",
                    isSmall = false
                )
                Spacer(modifier = Modifier.height(20.dp))
                HeadingText(
                    value = "We have sent OTP to your e-mail",
                    isSmall = true
                )
                HeadingText(
                    value = "please type code in here.",
                    isSmall = true
                )
                Spacer(modifier = Modifier.height(20.dp))
                OutlinedInputField(
                    label = "One time password",
                    modifier = Modifier.width(330.dp)
                )
                Spacer(modifier = Modifier.height(25.dp))
                PrimaryButton(
                    text = "Reset Password",
                    width = 280.dp,
                    height = 16.dp,
                    borderShape = RoundedCornerShape(36)
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

}

@ExperimentalMaterial3Api
@Preview
@Composable
fun LoginPasswordMailPreview(){
    ForgotPasswordScreen(navController = rememberNavController())
}