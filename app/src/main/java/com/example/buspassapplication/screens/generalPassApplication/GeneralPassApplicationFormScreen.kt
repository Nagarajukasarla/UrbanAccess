package com.example.buspassapplication.screens.generalPassApplication

import android.app.Activity
import android.util.Log
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
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavHostController
import com.example.buspassapplication.components.BackNavigationBar
import com.example.buspassapplication.components.DropDown
import com.example.buspassapplication.components.GenderDropDown
import com.example.buspassapplication.components.NormalText
import com.example.buspassapplication.components.OutlinedInputField
import com.example.buspassapplication.components.PaymentConfirmationPopup
import com.example.buspassapplication.components.Popup
import com.example.buspassapplication.components.PrimaryButton
import com.example.buspassapplication.enums.GenderEnum
import com.example.buspassapplication.ui.theme.DarkGray
import com.example.buspassapplication.ui.theme.PoppinsBold
import toResponsiveDp
import toResponsiveSp

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
    val duration by viewModel.duration.collectAsState()
    val houseNumber by viewModel.houseNumber.collectAsState()
    val street by viewModel.street.collectAsState()
    val area by viewModel.area.collectAsState()
    val district by viewModel.district.collectAsState()
    val city by viewModel.city.collectAsState()
    val state by viewModel.state.collectAsState()
    val pincode by viewModel.pincode.collectAsState()
    val amount by viewModel.amount.collectAsState()
    val paymentConfirmationStatus by viewModel.paymentConfirmationStatus.collectAsState()
    val currentUser by viewModel.currentUser.collectAsState(initial = null)

    val popupStatus by viewModel.popupStatus.collectAsState()
    val popupTitle by viewModel.popupTitle.collectAsState()
    val contentOnFirstLine by viewModel.contentOnFirstLine.collectAsState()
    val contentOnSecondLine by viewModel.contentOnSecondLine.collectAsState()

    val savedPopupStatus = rememberSaveable { mutableStateOf(popupStatus) }
    val savedPopupTitle = rememberSaveable { mutableStateOf(popupTitle) }
    val savedContentOnFirstLine = rememberSaveable { mutableStateOf(contentOnFirstLine) }
    val savedContentOnSecondLine = rememberSaveable { mutableStateOf(contentOnSecondLine) }

    savedPopupStatus.value = popupStatus
    savedPopupTitle.value = popupTitle
    savedContentOnFirstLine.value = contentOnFirstLine
    savedContentOnSecondLine.value = contentOnSecondLine

    val shouldRecompose by viewModel.shouldRecompose.collectAsState()

    if (shouldRecompose) {
        viewModel.clearRecompositionFlag()
    }


    Log.d("GeneralPassApplicationFormScreen", "Popup status: $popupStatus")

    val key = popupStatus
    CompositionLocalProvider(LocalLifecycleOwner provides LocalContext.current as LifecycleOwner) {
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
                },
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
            GenderDropDown(
                label = "Gender",
                options = Data.genderOptions,
                value = gender?.value ?: "",
                onItemSelected = {
                    viewModel.updateGender(it)
                },
                modifier = Modifier.width(280.toResponsiveDp())
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
                label = "Pin Code",
                modifier = Modifier
                    .width(280.toResponsiveDp())
                    .padding(bottom = 20.toResponsiveDp()),
                value = pincode ?: "",
                onValueChanged = {
                    viewModel.updatePincode(it)
                }
            )
            DropDown(
                label = "Duration",
                options = Data.durationOptions,
                value = duration ?: "",
                onItemSelected = {
                    viewModel.updateDuration(it)
                }
            )
            PrimaryButton(
                text = "Submit",
                width = 280.toResponsiveDp(),
                height = 45.toResponsiveDp(),
                borderShape = RoundedCornerShape(50),
                onClick = {
                    viewModel.onClickSubmit()
                }
            )
            if (popupStatus) {
                Popup(
                    title = popupTitle,
                    contentOnFirstLine = contentOnFirstLine,
                    contentOnSecondLine = contentOnSecondLine,
                    dismiss = false,
                    onDismissRequest = {
                        viewModel.popupStatus.value = false
                    },
                    onConfirmRequest = {
                        viewModel.updatePopupStatus(false)
                    }
                )
            }
            if (paymentConfirmationStatus) {
                PaymentConfirmationPopup(
                    amount = amount.toString().substring(0, amount.toString().length - 2),
                    onDismissRequest = {
                        viewModel.updatePaymentConfirmationStatus(false)
                    },
                    onPayRequest = {
                        viewModel.onClickPurchaseConfirm(activity = activity)
                        viewModel.updatePaymentConfirmationStatus(false)
                    }

                )
            }
        }
    }
}
