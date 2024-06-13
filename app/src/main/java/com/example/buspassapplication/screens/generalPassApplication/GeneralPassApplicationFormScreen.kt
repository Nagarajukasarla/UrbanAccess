package com.example.buspassapplication.screens.generalPassApplication

import android.app.Activity
import android.util.Log
import androidx.compose.foundation.LocalOverscrollConfiguration
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.buspassapplication.components.BackNavigationBar
import com.example.buspassapplication.components.DropDown
import com.example.buspassapplication.components.NormalText
import com.example.buspassapplication.components.OutlinedInputField
import com.example.buspassapplication.components.PaymentConfirmationPopup
import com.example.buspassapplication.components.Popup
import com.example.buspassapplication.components.PrimaryButton
import com.example.buspassapplication.routes.PassScreenRoutes
import com.example.buspassapplication.ui.theme.DarkGray
import com.example.buspassapplication.ui.theme.PoppinsBold
import kotlinx.coroutines.flow.MutableStateFlow


@ExperimentalMaterial3Api
@Composable
fun GeneralPassApplicationFormScreen(
    navController: NavHostController,
    currentUserId: String?,
    viewModel: GeneralPassApplicationViewModel = hiltViewModel()
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
    val currentUser by viewModel.currentUser.collectAsState(initial = null)

    val popupStatus by viewModel.popupStatus.collectAsState()
    val popupTitle by viewModel.popupTitle.collectAsState()
    val contentOnFirstLine by viewModel.contentOnFirstLine.collectAsState()
    val contentOnSecondLine by viewModel.contentOnSecondLine.collectAsState()
//    val navHostController by viewModel.navHostController.collectAsState()


    Log.d("GeneralPassApplicationFormScreen", "Popup status: $popupStatus")

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(bottom = 40.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        BackNavigationBar(navController = navController)
        NormalText(
            modifier = Modifier
                .padding(top = 15.dp, bottom = 20.dp),
            value = "General Pass Application",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = PoppinsBold,
            color = DarkGray
        )
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
            label = "Guardian Name",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = guardian ?: "",
            onValueChanged = {
                viewModel.updateGuardian(it)
            },
        )
        OutlinedInputField(
            label = "Date of Birth",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
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
        Spacer(modifier = Modifier.padding(bottom = 15.dp))
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
            label = "Aadhar no",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 15.dp),
            value = aadhar ?: "",
            onValueChanged = {
                viewModel.updateAadhar(it)
            },
            enabled = currentUser?.aadhar == null
        )
        OutlinedInputField(
            label = "House No",
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
            label = "Pin Code",
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 20.dp),
            value = pincode ?: "",
            onValueChanged = {
                viewModel.updatePincode(it)
            }
        )
        PrimaryButton(
            text = "Submit",
            width = 280.dp,
            height = 45.dp,
            borderShape = RoundedCornerShape(50),
            onClick = {
                // Call payments page here directly {testing purpose only}
                viewModel.onSubmitClick(activity)
            }
        )

        if (popupStatus) {
            Popup(
                title = popupTitle,
                contentOnFirstLine = contentOnFirstLine,
                contentOnSecondLine = contentOnSecondLine,
                dismiss = false,
                onDismissRequest = {
//                    viewModel.popupStatus.value = false
                },
                onConfirmRequest = {
                    viewModel.updatePopupStatus(false)
                }
            )
        }

//        if (paymentConfirmationPopupStatus) {
//            PaymentConfirmationPopup(
//                amount = amount,
//                onDismissRequest = {
//                    viewModel.popupStatus.value = false
//                },
//                onPayRequest = {
//                    viewModel.popupStatus.value = false
//                }
//            )
//        }
    }
}

//@OptIn(ExperimentalMaterial3Api::class)
//@Preview(showBackground = true)
//@Composable
//fun GeneralPassApplicationFormScreenPreview() {
//    GeneralPassApplicationFormScreen(navController = rememberNavController())
//}