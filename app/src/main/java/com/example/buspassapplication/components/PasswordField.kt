package com.example.buspassapplication.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@ExperimentalMaterial3Api
@Composable
fun PasswordField (
    @DrawableRes visibilityPainterResourceId: Int,
    @DrawableRes visibilityOffResourceId: Int,
    width: Dp = 280.dp,
    maxWidth: Dp = 300.dp,
    onPasswordChange: (String) -> Unit = {}
) {
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisibilityState by remember { mutableStateOf(false) }

    val icon =
        if (passwordVisibilityState)
            painterResource(id = visibilityPainterResourceId)
        else
            painterResource(id = visibilityOffResourceId)

    OutlinedTextField(
        modifier = Modifier
            .width(width)
            //.fillMaxWidth(1f),
        ,value = password,
        onValueChange = {inputValue ->
            password = inputValue
        },
        label= {
            Text(text = "Password")
        },
        visualTransformation = if (passwordVisibilityState) VisualTransformation.None
            else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
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

