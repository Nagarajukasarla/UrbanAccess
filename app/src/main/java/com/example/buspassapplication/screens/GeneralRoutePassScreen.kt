package com.example.buspassapplication.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.buspassapplication.components.BlueLabelledText
import com.example.buspassapplication.components.DropDown
import com.example.buspassapplication.components.ImagePickerInputField
import com.example.buspassapplication.components.NormalText
import com.example.buspassapplication.components.OutlinedInputField
import com.example.buspassapplication.ui.theme.PoppinsBold

@ExperimentalMaterial3Api
@Composable
fun GeneralRoutePassScreen(
    navController: NavHostController
) {

    var fullName by rememberSaveable { mutableStateOf("") }
    var guardian by rememberSaveable { mutableStateOf("") }
    var dateOfBirth by rememberSaveable { mutableStateOf("") }
    var phone by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var aadhar by rememberSaveable { mutableStateOf("") }
    var address by rememberSaveable { mutableStateOf("") }
    var district by rememberSaveable { mutableStateOf("") }
    var mandal by rememberSaveable { mutableStateOf("") }
    var village by rememberSaveable { mutableStateOf("") }
    var fromPlace by rememberSaveable { mutableStateOf("") }
    var toPlace by rememberSaveable { mutableStateOf("") }
    var pincode by rememberSaveable { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        NormalText(
            modifier = Modifier
                .padding(top = 70.dp, bottom = 10.dp),
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
            label = "Full name",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = fullName,
            onValueChange = { fullName = it }
        )
        OutlinedInputField(
            label = "Guardian name",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = guardian,
            onValueChange = { guardian = it }
        )
        OutlinedInputField(
            label = "Date of birth",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = dateOfBirth,
            onValueChange = { dateOfBirth = it }
        )
        DropDown()
        OutlinedInputField(
            label = "Mobile",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = phone,
            onValueChange = { phone = it }
        )
        OutlinedInputField(
            label = "Email",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = email,
            onValueChange = { email = it }
        )
        OutlinedInputField(
            label = "Aadhar no",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = aadhar,
            onValueChange = { aadhar = it }
        )
        OutlinedInputField(
            label = "Applicant address",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = address,
            onValueChange = { address = it }
        )
        OutlinedInputField(
            label = "District",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = district,
            onValueChange = { district = it }
        )
        OutlinedInputField(
            label = "Mandal",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = mandal,
            onValueChange = { mandal = it }
        )
        OutlinedInputField(
            label = "village",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = village,
            onValueChange = { village = it }
        )
        OutlinedInputField(
            label = "Pin Code",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = pincode,
            onValueChange = { pincode = it }
        )
        ImagePickerInputField()
        BlueLabelledText(text = "Route details")
        OutlinedInputField(
            label = "From Place",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = fromPlace,
            onValueChange = { fromPlace = it }
        )
        OutlinedInputField(
            label = "To Place",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = toPlace,
            onValueChange = { toPlace = it }
        )
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun GeneralRoutePassPreview() {
    GeneralRoutePassScreen()
}