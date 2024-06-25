package com.example.buspassapplication.screens.routePassApplication

import android.app.Activity
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.buspassapplication.components.BackNavigationBar
import com.example.buspassapplication.components.BlueLabelledText
import com.example.buspassapplication.components.DropDown
import com.example.buspassapplication.components.NormalText
import com.example.buspassapplication.components.OutlinedInputField
import com.example.buspassapplication.components.PrimaryButton
import com.example.buspassapplication.screens.generalPassApplication.Data
import com.example.buspassapplication.ui.theme.DarkGray
import com.example.buspassapplication.ui.theme.PoppinsBold
import kotlinx.coroutines.flow.MutableStateFlow
import toResponsiveDp
import toResponsiveSp

@ExperimentalMaterial3Api
@Composable
fun RoutePassApplicationFormScreen(
        navController: NavHostController,
        viewModel: RoutePassApplicationViewModel = hiltViewModel(),
        currentUserId: String?
) {
    val activity = LocalContext.current as Activity
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
    val startingPoint = viewModel.startingPoint.collectAsState()
    val destinationPoint = viewModel.destinationPoint.collectAsState()
    val currentUser by viewModel.currentUser.collectAsState(initial = null)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(bottom = 40.toResponsiveDp()),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        BackNavigationBar(navController = navController)
        NormalText(
            modifier = Modifier
                .padding(top = 15.toResponsiveDp(), bottom = 20.toResponsiveDp()),
            value = "General Pass Application",
            fontSize = 25.toResponsiveSp(),
            fontWeight = FontWeight.Bold,
            fontFamily = PoppinsBold,
            color = DarkGray
        )
        OutlinedInputField(
            label = "Surname",
            modifier = Modifier
                .width(280.toResponsiveDp())
                .padding(bottom = 15.toResponsiveDp()),
            value = surname ?: "",
            onValueChanged = {
                viewModel.updateSurname(it)
            },
            enabled = currentUser?.surname == null
        )
        OutlinedInputField(
            label = "Lastname",
            modifier = Modifier
                .width(280.toResponsiveDp())
                .padding(bottom = 15.toResponsiveDp()),
            value = lastname ?: "",
            onValueChanged = {
                viewModel.updateLastname(it)
            },
            enabled = currentUser?.lastname == null
        )
        OutlinedInputField(
            label = "Guardian Name",
            modifier = Modifier
                .width(280.toResponsiveDp())
                .padding(bottom = 15.toResponsiveDp()),
            value = guardian ?: "",
            onValueChanged = {
                viewModel.updateGuardian(it)
            }
        )
        OutlinedInputField(
            label = "Date of Birth",
            modifier = Modifier
                .width(280.toResponsiveDp())
                .padding(bottom = 15.toResponsiveDp()),
            value = dateOfBirth ?: "",
            onValueChanged = {
                viewModel.updateDateOfBirth(it)
            }
        )
        DropDown(
            label = "Gender",
            options = Data.genderOptions,
            value = gender ?: "",
            onItemSelected = {
                viewModel.updateGender(it)
            }
        )
        Spacer(modifier = Modifier.padding(bottom = 15.toResponsiveDp()))
        OutlinedInputField(
            label = "Mobile",
            modifier = Modifier
                .width(280.toResponsiveDp())
                .padding(bottom = 15.toResponsiveDp()),
            value = phone ?: "",
            onValueChanged = {
                viewModel.updatePhone(it)
            }
        )
        OutlinedInputField(
            label = "Email",
            modifier = Modifier
                .width(280.toResponsiveDp())
                .padding(bottom = 15.toResponsiveDp()),
            value = email ?: "",
            onValueChanged = {
                viewModel.updateEmail(it)
            },
            enabled = currentUser?.email == null
        )
        OutlinedInputField(
            label = "Aadhar no",
            modifier = Modifier
                .width(280.toResponsiveDp())
                .padding(bottom = 15.toResponsiveDp()),
            value = aadhar ?: "",
            onValueChanged = {
                viewModel.updateAadhar(it)
            },
            enabled = currentUser?.aadhar == null
        )
        OutlinedInputField(
            label = "House No",
            modifier = Modifier
                .width(280.toResponsiveDp())
                .padding(bottom = 15.toResponsiveDp()),
            value = houseNumber ?: "",
            onValueChanged = {
                viewModel.updateHouseNumber(it)
            }
        )
        OutlinedInputField(
            label = "Street",
            modifier = Modifier
                .width(280.toResponsiveDp())
                .padding(bottom = 15.toResponsiveDp()),
            value = street ?: "",
            onValueChanged = {
                viewModel.updateStreet(it)
            }
        )
        OutlinedInputField(
            label = "Area",
            modifier = Modifier
                .width(280.toResponsiveDp())
                .padding(bottom = 15.toResponsiveDp()),
            value = area ?: "",
            onValueChanged = {
                viewModel.updateArea(it)
            }
        )
        OutlinedInputField(
            label = "District",
            modifier = Modifier
                .width(280.toResponsiveDp())
                .padding(bottom = 15.toResponsiveDp()),
            value = district ?: "",
            onValueChanged = {
                viewModel.updateDistrict(it)
            }
        )
        OutlinedInputField(
            label = "City",
            modifier = Modifier
                .width(280.toResponsiveDp())
                .padding(bottom = 15.toResponsiveDp()),
            value = city ?: "",
            onValueChanged = {
                viewModel.updateCity(it)
            }
        )
        OutlinedInputField(
            label = "State",
            modifier = Modifier
                .width(280.toResponsiveDp())
                .padding(bottom = 15.toResponsiveDp()),
            value = state ?: "",
            onValueChanged = {
                viewModel.updateState(it)
            }
        )
        OutlinedInputField(
            label = "Pincode",
            modifier = Modifier
                .width(280.toResponsiveDp())
                .padding(bottom = 15.toResponsiveDp()),
            value = pincode ?: "",
            onValueChanged = {
                viewModel.updatePincode(it)
            }
        )
        BlueLabelledText(text = "Route Details")
        OutlinedInputField(
            label = "Starting Point",
            modifier = Modifier
                .width(280.toResponsiveDp())
                .padding(bottom = 15.toResponsiveDp()),
            value = startingPoint.value ?: "",
            onValueChanged = {
                viewModel.updateStartingPoint(it)
            }
        )
        OutlinedInputField(
            label = "Destination Point",
            modifier = Modifier
                .width(280.toResponsiveDp())
                .padding(bottom = 15.toResponsiveDp()),
            value = destinationPoint.value ?: "",
            onValueChanged = {
                viewModel.updateDestinationPoint(it)
            }
        )
        PrimaryButton(
            text = "Submit",
            width = 280.toResponsiveDp(),
            height = 45.toResponsiveDp(),
            borderShape = RoundedCornerShape(50),
            onClick = {
                // Call payments page here directly {testing purpose only}
                viewModel.onClickSubmit(activity)
            }
        )
    }
}

//@ExperimentalMaterial3Api
//@Preview
//@Composable
//fun RoutePassApplicationFormScreenPreview() {
//    RoutePassApplicationFormScreen(navController = rememberNavController())
//}
