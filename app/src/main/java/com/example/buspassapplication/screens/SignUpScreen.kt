package com.example.buspassapplication.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
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
import com.example.buspassapplication.components.PasswordField
import com.example.buspassapplication.components.PrimaryButton
import com.example.buspassapplication.ui.theme.DarkGray
import com.example.buspassapplication.ui.theme.NavyBlue
import com.example.buspassapplication.ui.theme.PoppinsMedium
import com.example.buspassapplication.ui.theme.White

@ExperimentalMaterial3Api
@Composable
fun SignUpScreen (
    navController: NavController
) {

    val screenHeight = LocalConfiguration.current.screenHeightDp.dp
    val screenHeightPixels = with (LocalDensity.current) { screenHeight.toPx() }
    val padding = (screenHeightPixels * 0.01f).dp

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
            .padding(bottom = 15.dp)
    ) {

        var firstName by rememberSaveable { mutableStateOf("") }
        var lastName by rememberSaveable { mutableStateOf("") }
        var email by rememberSaveable { mutableStateOf("") }
        var password by rememberSaveable { mutableStateOf("") }
        var confirmPassword by rememberSaveable { mutableStateOf("") }

        var termsAndConditionsValue by rememberSaveable { mutableStateOf(false)  }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = padding)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(0.dp),
        ) {

            HeadingText(
                value = "Hey there,",
                isSmall = true
            )
            HeadingText(
                value = "Create an Account",
                isSmall = false
            )
            Spacer(modifier = Modifier.height(17.dp))
            OutlinedInputField(
                label = "First Name",
                modifier = Modifier.width(300.dp),
                value = firstName,
                onValueChanged = { firstName = it }
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedInputField(
                label = "Last Name",
                modifier = Modifier.width(300.dp),
                value = lastName,
                onValueChanged = { lastName = it }
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedInputField(
                label = "Email",
                modifier = Modifier.width(300.dp),
                value = email,
                onValueChanged = { email = it }
            )
            Spacer(modifier = Modifier.height(16.dp))
            PasswordField(
                label = "Password",
                modifier = Modifier.width(300.dp),
                value = password,
                onValueChange = { password = it }
            )
            Spacer(modifier = Modifier.height(16.dp))
            PasswordField(
                label = "Confirm Password",
                modifier = Modifier.width(300.dp),
                value = confirmPassword,
                onValueChange = { confirmPassword = it }
            )
            Row  (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp)
                    .height(25.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,

            ) {
                Checkbox(
                    checked = termsAndConditionsValue,
                    onCheckedChange = {
                        termsAndConditionsValue = !termsAndConditionsValue
                    }
                )
                Spacer(modifier = Modifier.width(3.dp))
                NormalText(
                    value = "Creating an account means I agree with ",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = PoppinsMedium,
                    color = DarkGray,
                    modifier = Modifier
                )
            }
            NormalText(
                value = "Terms and Conditions",
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = PoppinsMedium,
                color = NavyBlue,
                modifier = Modifier.padding(bottom = 20.dp)
            )
            PrimaryButton(
                text = "Signup",
                width = 300.dp,
                height = 45.dp,
                borderShape = RoundedCornerShape(50)
            )
            Row (
                modifier = Modifier.padding(top = 14.dp)
            ) {
                NormalText(
                    modifier = Modifier,
                    value = "Already a member? ",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = PoppinsMedium,
                    color = DarkGray,
                )
                NormalText(
                    modifier = Modifier
                        .clickable {
                            navController.navigate(route = AuthenticationScreenRoutes.Login.route) {
                                popUpTo(route = AuthenticationScreenRoutes.Signup.route) {
                                    inclusive = true
                                }
                                launchSingleTop = true
                            }
                        },
                    value = "Login",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = PoppinsMedium,
                    color = NavyBlue,
                )
            }
        }
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun DefaultPreviewOfSignupScreen() {
    SignUpScreen(navController = rememberNavController())
}