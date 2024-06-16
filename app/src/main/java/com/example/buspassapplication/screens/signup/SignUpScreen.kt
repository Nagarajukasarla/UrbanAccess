package com.example.buspassapplication.screens.signup

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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.buspassapplication.routes.AuthenticationScreenRoutes
import com.example.buspassapplication.components.HeadingText
import com.example.buspassapplication.components.NormalText
import com.example.buspassapplication.components.OutlinedInputField
import com.example.buspassapplication.components.PasswordField
import com.example.buspassapplication.components.Popup
import com.example.buspassapplication.components.PrimaryButton
import com.example.buspassapplication.ui.theme.DarkGray
import com.example.buspassapplication.ui.theme.NavyBlue
import com.example.buspassapplication.ui.theme.PoppinsMedium
import toResponsiveDp
import toResponsiveSp

@ExperimentalMaterial3Api
@Composable
fun SignUpScreen(
    navController: NavController,
    viewModel: SignUpViewModel = hiltViewModel()
) {

    val screenHeight = LocalConfiguration.current.screenHeightDp.toResponsiveDp()
    val screenHeightPixels = with(LocalDensity.current) { screenHeight.toPx() }
    val padding = (screenHeightPixels * 0.01).toResponsiveDp()

    val surname by viewModel.surname.collectAsState()
    val lastName by viewModel.lastName.collectAsState()
    val email by viewModel.email.collectAsState()
    val password by viewModel.password.collectAsState()
    val confirmPassword by viewModel.confirmPassword.collectAsState()
    val popStatus by viewModel.popupStatus.collectAsState()
    val popupTitle by viewModel.popupTitle.collectAsState()
    val popupMessageOnFirstLine by viewModel.popupMessageOnFirstLine.collectAsState()
    val popupMessageOnSecondLine by viewModel.popupMessageOnSecondLine.collectAsState()
    val passwordMismatch by viewModel.passwordMismatch.collectAsState()
    val accountCreated by viewModel.accountCreated.collectAsState()

    var termsAndConditionsValue by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = padding)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(0.toResponsiveDp()),
    ) {
        HeadingText(
            value = "Hey there,",
            isSmall = true
        )
        HeadingText(
            value = "Create an Account",
            isSmall = false
        )
        Spacer(modifier = Modifier.height(17.toResponsiveDp()))
        OutlinedInputField(
            label = "First Name",
            modifier = Modifier.width(300.toResponsiveDp()),
            value = surname,
            onValueChanged = {
                viewModel.updateSurname(it)
            }
        )
        Spacer(modifier = Modifier.height(16.toResponsiveDp()))
        OutlinedInputField(
            label = "Last Name",
            modifier = Modifier.width(300.toResponsiveDp()),
            value = lastName,
            onValueChanged = {
                viewModel.updateLastname(it)
            }
        )
        Spacer(modifier = Modifier.height(16.toResponsiveDp()))
        OutlinedInputField(
            label = "Email",
            modifier = Modifier.width(300.toResponsiveDp()),
            value = email,
            onValueChanged = {
                viewModel.updateEmail(it)
            }
        )
        Spacer(modifier = Modifier.height(16.toResponsiveDp()))
        PasswordField(
            label = "Password",
            modifier = Modifier.width(300.toResponsiveDp()),
            value = password,
            onValueChange = {
                viewModel.updatePassword(it)
            }
        )
        Spacer(modifier = Modifier.height(16.toResponsiveDp()))
        PasswordField(
            label = "Confirm Password",
            modifier = Modifier.width(300.toResponsiveDp()),
            value = confirmPassword,
            onValueChange = {
                viewModel.updateConfirmPassword(it)
            }
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.toResponsiveDp())
                .height(25.toResponsiveDp()),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,

            ) {
            Checkbox(
                checked = termsAndConditionsValue,
                onCheckedChange = {
                    termsAndConditionsValue = !termsAndConditionsValue
                }
            )
            Spacer(modifier = Modifier.width(3.toResponsiveDp()))
            NormalText(
                value = "Creating an account means I agree with ",
                fontSize = 12.toResponsiveSp(),
                fontWeight = FontWeight.Normal,
                fontFamily = PoppinsMedium,
                color = DarkGray,
                modifier = Modifier
            )
        }
        NormalText(
            value = "Terms and Conditions",
            fontSize = 12.toResponsiveSp(),
            fontWeight = FontWeight.Normal,
            fontFamily = PoppinsMedium,
            color = NavyBlue,
            modifier = Modifier.padding(bottom = 20.toResponsiveDp())
        )
        PrimaryButton(
            text = "Signup",
            width = 300.toResponsiveDp(),
            height = 45.toResponsiveDp(),
            borderShape = RoundedCornerShape(50),
            onClick = {
                viewModel.onSignupClick()
            }
        )
        Row(
            modifier = Modifier.padding(top = 14.toResponsiveDp())
        ) {
            NormalText(
                modifier = Modifier,
                value = "Already a member? ",
                fontSize = 14.toResponsiveSp(),
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
                fontSize = 14.toResponsiveSp(),
                fontWeight = FontWeight.Normal,
                fontFamily = PoppinsMedium,
                color = NavyBlue,
            )
        }
        if (popStatus) {
            Popup(
                width = 310.toResponsiveDp(),
                title = popupTitle,
                contentOnFirstLine = popupMessageOnFirstLine,
                contentOnSecondLine = popupMessageOnSecondLine,
                dismiss = false,
                confirmMessage = if (accountCreated) "Login" else "Okay",
                onConfirmRequest = {
                    viewModel.resetPopup()
                }
            )
        }
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun DefaultPreviewOfSignupScreen() {
    SignUpScreen(navController = rememberNavController())
}
