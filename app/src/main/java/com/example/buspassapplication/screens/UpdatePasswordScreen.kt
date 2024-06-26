package com.example.buspassapplication.screens

import androidx.compose.foundation.background
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
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.buspassapplication.routes.AuthenticationScreenRoutes
import com.example.buspassapplication.components.HeadingText
import com.example.buspassapplication.components.NormalText
import com.example.buspassapplication.components.PasswordField
import com.example.buspassapplication.components.PrimaryButton
import com.example.buspassapplication.ui.theme.DarkGray
import com.example.buspassapplication.ui.theme.PoppinsLight
import toResponsiveDp
import toResponsiveSp

@ExperimentalMaterial3Api
@Composable
fun UpdatePasswordScreen (
    navController: NavController
){

    var newPassword by rememberSaveable { mutableStateOf("") }
    var confirmPassword by rememberSaveable { mutableStateOf("") }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent)
            .padding(28.toResponsiveDp())
    ) {
        Column(
            modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            HeadingText(
                value = "Update Password",
                isSmall = false
            )
            Spacer(modifier = Modifier.height(20.toResponsiveDp()))
            NormalText(
                value= "Create a strong password that ",
                fontSize = 15.toResponsiveSp(),
                fontFamily = PoppinsLight,
                color = DarkGray,
                fontWeight = FontWeight.Normal,
                modifier = Modifier
            )
            NormalText(
                value= "that you don't use for websites. ",
                fontSize = 15.toResponsiveSp(),
                fontFamily = PoppinsLight,
                color = DarkGray,
                fontWeight = FontWeight.Normal,
                modifier = Modifier
            )
            Spacer(modifier = Modifier.height(20.toResponsiveDp()))
            PasswordField(
                modifier = Modifier.width(330.toResponsiveDp()),
                label = "New Password",
                value = newPassword,
                onValueChange = { newPassword = it }
            )
            Spacer(modifier = Modifier.height(20.toResponsiveDp()))
            PasswordField(
                modifier = Modifier.width(330.toResponsiveDp()),
                label = "Confirm Password",
                value = confirmPassword,
                onValueChange = { confirmPassword = it }
            )
            Spacer(modifier = Modifier.height(45.toResponsiveDp()))
            PrimaryButton(
                text = "Save Password",
                width = 280.toResponsiveDp(),
                height = 45.toResponsiveDp(),
                borderShape = RoundedCornerShape(50),
                onClick = {
                    // Update password
                    // Notify success message
                    navController.navigate(route = AuthenticationScreenRoutes.Login.route) {
                        navController.popBackStack()
                        launchSingleTop = true
                    }
                }
            )
        }
    }

}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun ChangePasswordPreview(){
    UpdatePasswordScreen(navController = rememberNavController())
}
