package com.example.buspassapplication.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.buspassapplication.routes.AuthenticationScreenRoutes
import com.example.buspassapplication.components.HeadingText
import com.example.buspassapplication.components.NormalText
import com.example.buspassapplication.components.OutlinedInputField
import com.example.buspassapplication.components.PrimaryButton
import com.example.buspassapplication.ui.theme.DarkGray
import com.example.buspassapplication.ui.theme.NavyBlue
import com.example.buspassapplication.ui.theme.PoppinsLight
import com.example.buspassapplication.ui.theme.PoppinsMedium

@ExperimentalMaterial3Api
@Composable
fun PasswordRecoveryScreen (
    navController: NavController
) {

    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    val screenHeightPixels = with (LocalDensity.current) { screenHeight.toPx() }

    var verificationContentVisibility by remember { mutableStateOf(true) }

    var email by rememberSaveable { mutableStateOf("") }
    var otp by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        HeadingText(value = "Password Recovery")
        Spacer(modifier = Modifier.height(20.dp))
        NormalText(
            value= "Enter your email and we'll send you",
            fontSize = 15.sp,
            fontFamily = PoppinsLight,
            color = DarkGray,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(horizontal = 20.dp)
        )
        NormalText(
            value= "instructions to reset password. ",
            fontSize = 15.sp,
            fontFamily = PoppinsLight,
            color = DarkGray,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(horizontal = 20.dp, vertical = 5.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedInputField(
            label = "Email",
            modifier = Modifier.width(330.dp),
            enabled = !verificationContentVisibility,
            value = email,
            onValueChanged = { email = it }
        )
        Spacer(modifier = Modifier.height(30.dp))
        if (verificationContentVisibility) {
            NormalText(
                modifier = Modifier,
                value = "We have sent OTP to your mail id",
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = PoppinsMedium,
                color = DarkGray,
                letterSpacing = 0.7.sp
            )
            NormalText(
                modifier = Modifier,
                value = "please type here",
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = PoppinsMedium,
                color = DarkGray,
                letterSpacing = 0.7.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            OutlinedInputField(
                label = "One time password",
                modifier = Modifier.width(330.dp),
                value = otp,
                onValueChanged = { otp = it }
            )
        }
        Spacer(modifier = Modifier.height(25.dp))
        if (verificationContentVisibility) {
            PrimaryButton(
                text = "Submit",
                width = 260.dp,
                height = 45.dp,
                borderShape = RoundedCornerShape(50),
                onClick = {
                    /* Verify OTP */

                    navController.navigate(AuthenticationScreenRoutes.UpdatePassword.route) {
                        navController.popBackStack()
                        launchSingleTop = true
                    }

                }
            )
        }
        else {
            PrimaryButton(
                text = "Verify",
                width = 260.dp,
                height = 45.dp,
                borderShape = RoundedCornerShape(50),
                onClick = {
                    // Verify email and send OTP
                    verificationContentVisibility = true
                }
            )

        }
        NormalText(
            value = "< Back to Log in",
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            fontFamily = PoppinsMedium,
            color = NavyBlue,
            modifier = Modifier
                .padding(top = 20.dp)
                .clickable {
                    navController.popBackStack()
                }
        )
    }
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun LoginPasswordMailPreview(){
    PasswordRecoveryScreen(navController = rememberNavController())
}
