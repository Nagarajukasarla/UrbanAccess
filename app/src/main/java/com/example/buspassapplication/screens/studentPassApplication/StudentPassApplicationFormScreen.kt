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
import androidx.compose.runtime.internal.enableLiveLiterals
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
import kotlinx.coroutines.flow.MutableStateFlow


@ExperimentalMaterial3Api
@Composable
fun StudentPassApplicationFormScreen(
    navController: NavHostController,
    viewModel: StudentPassApplicationViewModel = hiltViewModel(),
    currentUserId: String?
) {

    val surname by viewModel.surname.collectAsState()
    val lastname by viewModel.lastname.collectAsState()
    val guardian by viewModel.guardian.collectAsState()
    val dateOfBirth by viewModel.dateOfBirth.collectAsState()
    val gender by viewModel.gender.collectAsState()
    val phone by viewModel.phone.collectAsState()
    val email by viewModel.email.collectAsState()
    val aadhar by viewModel.aadhar.collectAsState()
    val houseNumber by viewModel.houseNumber.collectAsState()
    val street by viewModel.street.collectAsState()
    val area by viewModel.area.collectAsState()
    val district by viewModel.district.collectAsState()
    val city by viewModel.city.collectAsState()
    val state by viewModel.state.collectAsState()
    val pincode by viewModel.pincode.collectAsState()
    val tenthBoard by viewModel.tenthBoard.collectAsState()
    val yearOfPass by viewModel.yearOfPass.collectAsState()
    val passType by viewModel.passType.collectAsState()
    val tenthHallTicketId by viewModel.tenthHallTicketId.collectAsState()
    val districtOfInstitute by viewModel.districtOfInstitute.collectAsState()
    val mandalOfInstitute by viewModel.mandalOfInstitute.collectAsState()
    val instituteAddress by viewModel.instituteAddress.collectAsState()
    val instituteName by viewModel.instituteName.collectAsState()
    val courseName by viewModel.courseName.collectAsState()
    val admissionNumber by viewModel.admissionNumber.collectAsState()
    val currentUser by viewModel.currentUser.collectAsState(null)


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
            value = "Student Pass Application",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = PoppinsBold,
            color = Color.Black
        )
        BlueLabelledText(text = "`Student 10th details`")
        DropDown(
            label = "10th Board type",
            options = listOf("State Board", "CBSE", "ICSE", "Others"),
            value = tenthBoard ?: "",
            onItemSelected = {
                viewModel.updatePassType(it)
            },
        )
        Spacer(modifier = Modifier.padding(bottom = 15.dp))
        OutlinedInputField(
            label = "Year of pass",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = yearOfPass ?: "",
            onValueChanged = {
                viewModel.updateYearOfPass(it)
            }
        )
        DropDown(
            label = "SSC Regular / Supplementary",
            options = listOf("Regular", "Supplementary"),
            value = passType ?: "",
            onItemSelected = {
                viewModel.updatePassType(it)
            }
        )
        Spacer(modifier = Modifier.padding(bottom = 15.dp))
        OutlinedInputField(
            label = "SSC Hall ticket no.",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = tenthHallTicketId ?: "",
            onValueChanged = {
                viewModel.updateTenthHallTicketId(it)
            }
        )
        BlueLabelledText(text = "Student details")
        OutlinedInputField(
            label = "Surname",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = surname ?: "",
            onValueChanged = {
                viewModel.updateSurname(it)
            },
            enabled = currentUser?.surname == null
        )
        OutlinedInputField(
            label = "Lastname",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = lastname ?: "",
            onValueChanged = {
                viewModel.updateLastname(it)
            },
            enabled = currentUser?.lastname == null
        )
        OutlinedInputField(
            label = "Guardian name",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = guardian ?: "",
            onValueChanged = {
                viewModel.updateGuardian(it)
            }
        )
        DropDown(
            label = "Gender",
            options = listOf("Male", "Female", "Others"),
            value = gender ?: "",
            onItemSelected = {
                viewModel.updateGender(it)
            }
        )
        OutlinedInputField(
            label = "Date of birth",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = dateOfBirth ?: "",
            onValueChanged = {
                viewModel.updateDateOfBirth(it)
            }
        )
        OutlinedInputField(
            label = "Email",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = email ?: "",
            onValueChanged = {
                viewModel.updateEmail(it)
            },
            enabled = currentUser?.email == null
        )
        OutlinedInputField(
            label = "Mobile",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = phone ?: "",
            onValueChanged = {
                viewModel.updatePhone(it)
            }
        )
        OutlinedInputField(
            label = "Aadhar number",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = aadhar ?: "",
            onValueChanged = {
                viewModel.updateAadhar(it)
            },
            enabled = currentUser?.aadhar == null
        )
        DropDown(
            label = "Is Employee Children",
            options = listOf("Yes", "No"),
            value = "Is Employee Children",
            onItemSelected = {  }
        )
        Spacer(modifier = Modifier.padding(bottom = 15.dp))
        BlueLabelledText(text = "Residential address details")
        OutlinedInputField(
            label = "House Number",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = houseNumber ?: "",
            onValueChanged = {
                viewModel.updateHouseNumber(it)
            }
        )
        OutlinedInputField(
            label = "Street",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = street ?: "",
            onValueChanged = {
                viewModel.updateStreet(it)
            }
        )
        OutlinedInputField(
            label = "Area",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = area ?: "",
            onValueChanged = {
                viewModel.updateArea(it)
            }
        )
        OutlinedInputField(
            label = "District",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = district ?: "",
            onValueChanged = {
                viewModel.updateDistrict(it)
            }
        )
        OutlinedInputField(
            label = "City",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = city ?: "",
            onValueChanged = {
                viewModel.updateCity(it)
            }
        )
        OutlinedInputField(
            label = "State",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = state ?: "",
            onValueChanged = {
                viewModel.updateState(it)
            }
        )
        OutlinedInputField(
            label = "Pincode",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = pincode ?: "",
            onValueChanged = {
                viewModel.updatePincode(it)
            }
        )
        BlueLabelledText(text = "Institution details")
        OutlinedInputField(
            label = "Name of the Institute",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = instituteName ?: "",
            onValueChanged = {
                viewModel.updateInstituteName(it)
            }
        )
        OutlinedInputField(
            label = "District of Institute",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = districtOfInstitute ?: "",
            onValueChanged = {
                viewModel.updateDistrictOfInstitute(it)
            }
        )
        OutlinedInputField(
            label = "Mandal of Institute",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = mandalOfInstitute ?: "",
            onValueChanged = {
                viewModel.updateMandalOfInstitute(it)
            }
        )
        OutlinedInputField(
            label = "Institution address",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = instituteAddress ?: "",
            onValueChanged = {
                viewModel.updateInstituteAddress(it)
            }
        )
        OutlinedInputField(
            label = "Course name",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = courseName ?: "",
            onValueChanged = {
                viewModel.updateCourseName(it)
            }
        )
        OutlinedInputField(
            label = "Admission number",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = admissionNumber ?: "",
            onValueChanged = {
                viewModel.updateAdmissionNumber(it)
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
