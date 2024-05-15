package com.example.buspassapplication.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.buspassapplication.R
import com.example.buspassapplication.ui.theme.DarkGray
import com.example.buspassapplication.ui.theme.NavyBlue


@ExperimentalMaterial3Api
@Composable
fun PasswordField (
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier,
    label: String,
    width: Dp = 280.dp,
    maxWidth: Dp = 340.dp,
    onPasswordChange: (String) -> Unit = {}
) {
    var passwordVisibilityState by rememberSaveable { mutableStateOf(false) }

    val visibilityResourceId = R.drawable.visibilty
    val visibilityOffResourceId = R.drawable.visibility_off

    val icon =
        if (passwordVisibilityState)
            painterResource(id = visibilityResourceId)
        else
            painterResource(id = visibilityOffResourceId)

    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        label= {
            Text(
                text = AnnotatedString(label),
                style = TextStyle(
                    letterSpacing = 0.3.sp
                )
            )
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedBorderColor = NavyBlue,
            focusedLabelColor = NavyBlue,
            cursorColor = DarkGray,
            focusedSupportingTextColor = DarkGray
        ),
        visualTransformation = if (passwordVisibilityState) VisualTransformation.None
            else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        textStyle = TextStyle(
            letterSpacing = 0.4.sp
        ),
        trailingIcon = {
            IconButton(
                onClick = {
                    passwordVisibilityState = !passwordVisibilityState
                }
            ) {
                Icon(
                    painter = icon,
                    contentDescription = "Visibility"
                )
            }
        },
        singleLine = true,
    )
}

