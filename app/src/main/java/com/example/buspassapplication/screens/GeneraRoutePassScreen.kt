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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.buspassapplication.AuthenticationScreenRoutes
import com.example.buspassapplication.components.BlueLabelledText
import com.example.buspassapplication.components.DropDown
import com.example.buspassapplication.components.HeadingText
import com.example.buspassapplication.components.ImagePickerInputField
import com.example.buspassapplication.components.NormalText
import com.example.buspassapplication.components.OutlinedInputField
import com.example.buspassapplication.components.PasswordField
import com.example.buspassapplication.components.PrimaryButton
import com.example.buspassapplication.graphs.Graph
import com.example.buspassapplication.ui.theme.DarkGray
import com.example.buspassapplication.ui.theme.NavyBlue
import com.example.buspassapplication.ui.theme.PoppinsBold
import com.example.buspassapplication.ui.theme.PoppinsMedium

@ExperimentalMaterial3Api
@Composable
fun GeneralRoutePassScreen(){

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent)
            .padding(28.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            NormalText(
                modifier = Modifier
                    .padding(top=70.dp, bottom = 10.dp),
                value = "General Route",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = PoppinsBold,
                color = Color.Black
            )
            NormalText(
                modifier = Modifier
                    .padding(bottom = 30.dp),
                value = "Bus Pass Application",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = PoppinsBold,
                color = Color.Black
            )
            OutlinedInputField(
                label = "Full Name",
                modifier = Modifier
                    .width(280.dp)
                    .padding(bottom = 15.dp)
            )
            OutlinedInputField(
                label = "Guardian Name",
                modifier = Modifier
                    .width(280.dp)
                    .padding(bottom = 15.dp)
            )
            OutlinedInputField(
                label = "Date of birth",
                modifier = Modifier
                    .width(280.dp)
                    .padding(bottom = 15.dp)
            )
           DropDown()
            OutlinedInputField(
                label = "Mobile",
                modifier = Modifier
                    .width(280.dp)
                    .padding(bottom = 15.dp)
            )
            OutlinedInputField(
                label = "Email",
                modifier = Modifier
                    .width(280.dp)
                    .padding(bottom = 15.dp)
            )
            OutlinedInputField(
                label = "Aadhar number",
                modifier = Modifier
                    .width(280.dp)
                    .padding(bottom = 10.dp)
            )
            OutlinedInputField(
                label = "Applicant address",
                modifier = Modifier
                    .width(280.dp)
                    .padding(bottom = 10.dp)
            )
            OutlinedInputField(
                label = "District",
                modifier = Modifier
                    .width(280.dp)
                    .padding(bottom = 10.dp)
            )
            OutlinedInputField(
                label = "Mandal",
                modifier = Modifier
                    .width(280.dp)
                    .padding(bottom = 10.dp)
            )
            OutlinedInputField(
                label = "Village",
                modifier = Modifier
                    .width(280.dp)
                    .padding(bottom = 10.dp)
            )
            OutlinedInputField(
                label = "Pin Code",
                modifier = Modifier
                    .width(280.dp)
                    .padding(bottom = 10.dp)
            )
            ImagePickerInputField()
            BlueLabelledText(text = "Route details")
            OutlinedInputField(
                label = "From Place",
                modifier = Modifier
                    .width(280.dp)
                    .padding(bottom = 10.dp)
            )
            OutlinedInputField(
                label = "To Place",
                modifier = Modifier
                    .width(280.dp)
                    .padding(bottom = 10.dp)
            )
        }
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun GeneralRoutePassPreview(){
    GeneralRoutePassScreen()
}