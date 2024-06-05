package com.example.buspassapplication.screens.studentPassApplication

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
import androidx.compose.runtime.collectAsState
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
import androidx.hilt.navigation.compose.hiltViewModel
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
        navController: NavHostController,
        viewModel: StudentPassApplicationViewModel = hiltViewModel(),
        currentUserId: String?
) {
    var fullName = viewModel.fullName.collectAsState()
    var guardian = viewModel.guardian.collectAsState()
    var dateOfBirth = viewModel.dateOfBirth.collectAsState()
    var phone = viewModel.phone.collectAsState()
    var email = viewModel.email.collectAsState()
    var aadhar = viewModel.aadhar.collectAsState()
    var address = viewModel.address.collectAsState()
    var districtOfStudent = viewModel.districtOfStudent.collectAsState()
    var mandalOfStudent = viewModel.mandalOfStudent.collectAsState()
    var villageOfStudent = viewModel.villageOfStudent.collectAsState()
    var pincodeOfStudent = viewModel.pincodeOfStudent.collectAsState()
    var gender by rememberSaveable { mutableStateOf("") }
    var tenthBoard by rememberSaveable { mutableStateOf("") }
    var yearOfPass = viewModel.yearOfPass.collectAsState()
    var regularOrSupply by rememberSaveable { mutableStateOf("") }
    var districtOfInstitute = viewModel.districtOfInstitute.collectAsState()
    var mandalOfInstitute = viewModel.mandalOfInstitute.collectAsState()
    var instituteAddress = viewModel.instituteAddress.collectAsState()
    var instituteName = viewModel.instituteName.collectAsState()
    var courseName = viewModel.courseName.collectAsState()
    var admissionNumber = viewModel.admissionNumber.collectAsState()
    var sscHallTicket = viewModel.sscHallTicket.collectAsState()


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
            label="SSC Board type",
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
            value = yearOfPass.value,
            onValueChanged = {
                viewModel.updateYearOfPass(it)
            }
        )
        OutlinedInputField(
            label = "Date of birth",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = dateOfBirth.value,
            onValueChanged = {
                viewModel.updateDateOfBirth(it)
            }
        )
        DropDown(
            label = "SSC Regular / Supplementary",
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
            value = sscHallTicket.value,
            onValueChanged = {
                viewModel.updateSscHallTicket(it)
            }
        )
        BlueLabelledText(text = "Student details")
        OutlinedInputField(
            label = "Full name",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = fullName.value,
            onValueChanged = {
                viewModel.updateFullName(it)
            }
        )
        OutlinedInputField(
            label = "Guardian name",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = guardian.value,
            onValueChanged = {
                viewModel.updateGuardian(it)
            }
        )
        DropDown(
            label = "Gender",
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
            value = phone.value,
            onValueChanged = {
                viewModel.updatePhone(it)
            }
        )
        OutlinedInputField(
            label = "Aadhar no.",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = aadhar.value,
            onValueChanged = {
                viewModel.updateAadhar(it)
            }
        )
        DropDown(
            label = "Is Employee",
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
            value = address.value,
            onValueChanged = {
                viewModel.updateAddress(it)
            }
        )
        OutlinedInputField(
            label = "District",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = districtOfStudent.value,
            onValueChanged = {
                viewModel.updateDistrictOfStudent(it)
            }
        )
        OutlinedInputField(
            label = "Mandal",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = mandalOfStudent.value,
            onValueChanged = {
                viewModel.updateMandalOfStudent(it)
            }
        )
        OutlinedInputField(
            label = "village",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = villageOfStudent.value,
            onValueChanged = {
                viewModel.updateVillageOfStudent(it)
            }
        )
        OutlinedInputField(
            label = "Pin Code",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = pincodeOfStudent.value,
            onValueChanged = {
                viewModel.updatePincodeOfStudent(it)
            }
        )
        BlueLabelledText(text = "Institution details")
        OutlinedInputField(
            label = "District",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = districtOfInstitute.value,
            onValueChanged = {
                viewModel.updateDistrictOfInstitute(it)
            }
        )
        OutlinedInputField(
            label = "Mandal",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = mandalOfInstitute.value,
            onValueChanged = {
                viewModel.updateMandalOfInstitute(it)
            }
        )
        OutlinedInputField(
            label = "Institution Name",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = instituteName.value,
            onValueChanged = {
                viewModel.updateInstituteName(it)
            }
        )
        OutlinedInputField(
            label = "Course name",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = courseName.value,
            onValueChanged = {
                viewModel.updateCourseName(it)
            }
        )
        OutlinedInputField(
            label = "Admission number",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = admissionNumber.value,
            onValueChanged = {
                viewModel.updateAdmissionNumber(it)
            }
        )
        OutlinedInputField(
            label = "Institution Address",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = instituteAddress.value,
            onValueChanged = {
                viewModel.updateInstituteAddress(it)
            }
        )
        PrimaryButton(
            text = "Submit",
            width = 280.dp,
            height = 45.dp,
            borderShape = RoundedCornerShape(50)
        )
    }
}
