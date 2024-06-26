package com.example.buspassapplication.screens.TopUp


import android.app.Activity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.buspassapplication.R
import com.example.buspassapplication.components.BackNavigationBar
import com.example.buspassapplication.components.NormalText
import com.example.buspassapplication.components.OutlinedInputField
import com.example.buspassapplication.components.PrimaryButton
import com.example.buspassapplication.ui.theme.DarkGray
import com.example.buspassapplication.ui.theme.DimGray
import com.example.buspassapplication.ui.theme.PoppinsMedium
import com.example.buspassapplication.ui.theme.Roboto
import toResponsiveDp
import toResponsiveSp


@Composable
fun TopUpScreen(
    navController: NavHostController,
    currentUserId: String?,
    viewModel: TopUpViewModel = hiltViewModel()
) {
    val amount by viewModel.amount.collectAsState()
    val size by viewModel.size.collectAsState()
    val context = LocalContext.current as Activity
    val curAmount by viewModel.currAmount.collectAsState()
    val rupee = R.drawable.rupee
    BackNavigationBar(navController = navController)
    Column(
        modifier = Modifier
            .padding(
                start = 33.toResponsiveDp(),
                top = 40.toResponsiveDp(),
                end = 33.toResponsiveDp()
            )
            .verticalScroll(
                rememberScrollState()
            ),
    ) {
        NormalText(
            modifier = Modifier
                .padding(top = 15.toResponsiveDp(), bottom = 10.toResponsiveDp()),
            value = "Top Up",
            fontSize = 40.toResponsiveSp(),
            fontWeight = FontWeight.Bold,
            fontFamily = PoppinsMedium,
            color = DarkGray
        )
        NormalText(
            modifier = Modifier
                .padding(top = 10.toResponsiveDp(), bottom = 20.toResponsiveDp()),
            value = "₹${curAmount}",
            fontSize = 40.toResponsiveSp(),
            fontWeight = FontWeight.Light,
            fontFamily = Roboto,
            color = DarkGray
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.toResponsiveDp()),
            contentAlignment = Alignment.Center
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                OutlinedInputField(
                    label = "Amount",
                    modifier = Modifier
                        .width(360.toResponsiveDp())
                        .padding(bottom = 15.toResponsiveDp()),
                    value = amount ?: "",
                    onValueChanged = {
                        viewModel.updateAmount(it)
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Number
                    ),
                    textStyle = TextStyle(
                        fontSize = 50.toResponsiveSp(),
                        letterSpacing = 0.7.toResponsiveSp()
                    ),
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = rupee),
                            contentDescription = null,
                            tint = DimGray,
                            modifier = Modifier.size(30.toResponsiveDp())
                        )
                    }
                )
                Spacer(modifier = Modifier.height(40.toResponsiveDp()))
                PrimaryButton(
                    text = "Add money",
                    width = 220.toResponsiveDp(),
                    height = 40.toResponsiveDp(),
                    borderShape = RoundedCornerShape(50),
                    onClick = {
                        viewModel.onSubmit()
                    }
                )
            }

        }
    }
}

//@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showBackground = true)
//@Composable
//fun TopUpScreenPreview() {
//    TopUpScreen(navController = rememberNavController(), currentUserId = null)
//}
