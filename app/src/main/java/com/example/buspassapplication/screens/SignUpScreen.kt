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

        var termsAndConditionsValue by rememberSaveable { mutableStateOf(false) }

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
                label = AnnotatedString("First Name"),
                modifier = Modifier.width(300.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedInputField(
                label = AnnotatedString("Last Name"),
                modifier = Modifier.width(300.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedInputField(
                label = AnnotatedString("Email"),
                modifier = Modifier.width(300.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            PasswordField(
                label = AnnotatedString("Password"),
                modifier = Modifier.width(300.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            PasswordField(
                label = AnnotatedString("Confirm Password"),
                modifier = Modifier.width(300.dp),
            )
            Row  (
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,

            ){
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
                modifier = Modifier
            )
            PrimaryButton(
                text = "Signup",
                width = 300.dp
            )
            Row (
            ) {
                NormalText(
                    modifier = Modifier.padding(top = 4.dp),
                    value = "Already a memeber? ",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = PoppinsMedium,
                    color = DarkGray,
                )
                NormalText(
                    modifier = Modifier
                        .padding(top = 4.dp)
                        .clickable {
                            navController.navigate(route = Screen.Login.route)
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
fun DefaultPreviewOfSignupScreeen() {
    SignUpScreen(navController = rememberNavController())
}