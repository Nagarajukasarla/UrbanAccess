package com.example.buspassapplication.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.buspassapplication.components.BackNavigationBar
import com.example.buspassapplication.components.BlueLabelledText
import com.example.buspassapplication.components.DropDown
import com.example.buspassapplication.components.NormalText
import com.example.buspassapplication.components.OutlinedInputField
import com.example.buspassapplication.components.PrimaryButton
import com.example.buspassapplication.ui.theme.PoppinsBold


@ExperimentalMaterial3Api
@Composable
fun StudentPassApplicationFormScreen(
    navController: NavHostController
) {
    var fullName by rememberSaveable { mutableStateOf("") }
    var guardian by rememberSaveable { mutableStateOf("") }
    var dateOfBirth by rememberSaveable { mutableStateOf("") }
    var phone by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var aadhar by rememberSaveable { mutableStateOf("") }
    var address by rememberSaveable { mutableStateOf("") }
    var districtOfStudent by rememberSaveable { mutableStateOf("") }
    var mandalOfStudent by rememberSaveable { mutableStateOf("") }
    var villageOfStudent by rememberSaveable { mutableStateOf("") }
    var pincodeOfStudent by rememberSaveable { mutableStateOf("") }
    var gender by rememberSaveable { mutableStateOf("") }
    var tenthBoard by rememberSaveable { mutableStateOf("") }
    var yearOfPass by rememberSaveable { mutableStateOf("") }
    var regularOrSupply by rememberSaveable { mutableStateOf("") }
    var sscHallTicket by rememberSaveable { mutableStateOf("") }
    var districtOfInstitute by rememberSaveable { mutableStateOf("") }
    var mandalOfInstitute by rememberSaveable { mutableStateOf("") }
    var instituteAddress by rememberSaveable { mutableStateOf("") }
    var instituteName by rememberSaveable { mutableStateOf("") }
    var courseName by rememberSaveable { mutableStateOf("") }
    var admissionNumber by rememberSaveable { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        BackNavigationBar(navController = navController)
        NormalText(
            modifier = Modifier
                .padding(top = 15.dp, bottom = 20.dp),
            value = "Student",
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
        BlueLabelledText(text = "Student 10th details")
        DropDown(
            options = listOf("State Board", "CBSE", "ICSE", "Others"),
            value = "SSC Board type",
            onItemSelected = { tenthBoard = it }
        )
        Spacer(modifier = Modifier.padding(bottom = 15.dp))
        OutlinedInputField(
            label = "SSC Year of pass",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = phone,
            onValueChanged = { yearOfPass = it }
        )
        OutlinedInputField(
            label = "Date of birth",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = dateOfBirth,
            onValueChanged = { dateOfBirth = it }
        )
        DropDown(
            options = listOf("Regular", "Supplementary"),
            value = "SSC Regular / Supplementary",
            onItemSelected = { regularOrSupply = it }
        )
        Spacer(modifier = Modifier.padding(bottom = 15.dp))
        OutlinedInputField(
            label = "SSC Hall ticket no.",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = sscHallTicket,
            onValueChanged = { sscHallTicket = it }
        )
        BlueLabelledText(text = "Student details")
        OutlinedInputField(
            label = "Full name",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = fullName,
            onValueChanged = { fullName = it }
        )
        OutlinedInputField(
            label = "Guardian name",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = guardian,
            onValueChanged = { guardian = it }
        )
        DropDown(
            options = listOf("Male", "Female", "Others"),
            value = "Gender",
            onItemSelected = { gender = it }
        )
        Spacer(modifier = Modifier.padding(bottom = 15.dp))
        OutlinedInputField(
            label = "Mobile",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = phone,
            onValueChanged = { phone = it }
        )
        OutlinedInputField(
            label = "Aadhar no.",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = aadhar,
            onValueChanged = { aadhar = it }
        )
        DropDown(
            options = listOf("Yes", "No"),
            value = "Is Employee Children",
            onItemSelected = { gender = it }
        )
        Spacer(modifier = Modifier.padding(bottom = 15.dp))
        BlueLabelledText(text = "Residential address details")
        OutlinedInputField(
            label = "Applicant address",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = address,
            onValueChanged = { address = it }
        )
        OutlinedInputField(
            label = "District",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = districtOfStudent,
            onValueChanged = { districtOfStudent = it }
        )
        OutlinedInputField(
            label = "Mandal",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = mandalOfStudent,
            onValueChanged = { mandalOfStudent = it }
        )
        OutlinedInputField(
            label = "village",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = villageOfStudent,
            onValueChanged = { villageOfStudent = it }
        )
        OutlinedInputField(
            label = "Pin Code",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = pincodeOfStudent,
            onValueChanged = { pincodeOfStudent = it }
        )
        BlueLabelledText(text = "Institution details")
        OutlinedInputField(
            label = "District",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = districtOfInstitute,
            onValueChanged = { districtOfInstitute = it }
        )
        OutlinedInputField(
            label = "Mandal",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = mandalOfInstitute,
            onValueChanged = { mandalOfInstitute = it }
        )
        OutlinedInputField(
            label = "Institution Name",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = instituteName,
            onValueChanged = { instituteName = it }
        )
        OutlinedInputField(
            label = "Course name",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = courseName,
            onValueChanged = { courseName = it }
        )
        OutlinedInputField(
            label = "Admission number",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = admissionNumber,
            onValueChanged = { admissionNumber = it }
        )
        OutlinedInputField(
            label = "Institution Address",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = instituteAddress,
            onValueChanged = { instituteAddress = it }
        )
        PrimaryButton(
            text = "Submit",
            width = 280.dp,
            height = 45.dp,
            borderShape = RoundedCornerShape(50)
        )
    }
}