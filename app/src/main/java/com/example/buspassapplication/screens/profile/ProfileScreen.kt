package com.example.buspassapplication.screens.profile

import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.buspassapplication.R
import com.example.buspassapplication.components.CircularImageWithAddPhoto
import com.example.buspassapplication.components.DetailsContainerWithIcon
import com.example.buspassapplication.components.DropDown
import com.example.buspassapplication.components.NormalText
import com.example.buspassapplication.components.OutlinedInputField
import com.example.buspassapplication.components.Popup
import com.example.buspassapplication.components.PrimaryButton
import com.example.buspassapplication.screens.generalPassApplication.Data
import com.example.buspassapplication.ui.theme.DarkGray
import com.example.buspassapplication.ui.theme.NavyBlue
import com.example.buspassapplication.ui.theme.PoppinsBold
import com.example.buspassapplication.ui.theme.White
import toResponsiveDp
import toResponsiveSp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(
    navController: NavHostController,
    currentUserId: String?,
    viewModel: ProfileViewModel = hiltViewModel()
) {

    val screenWidth = LocalConfiguration.current.screenWidthDp.toResponsiveDp()
    val screenWidthInPixels = with(LocalDensity.current) { screenWidth.toPx() }
    val paddingForBackIcon = (screenWidthInPixels * 0.01).toResponsiveDp()
    val paddingForProfileText = (screenWidthInPixels * 0.11).toResponsiveDp()

    Log.d("ProfileScreen", "screenWidth: $screenWidth")
    Log.d("ProfileScreen", "screenWidthInPixels: $screenWidthInPixels")
    Log.d("ProfileScreen", "paddingForBackIcon: $paddingForBackIcon")
    Log.d("ProfileScreen", "paddingForProfileText: $paddingForProfileText")

    val leftArrowResourceId = R.drawable.arrow_left
    val personResourceId = R.drawable.account
    val emailResourceId = R.drawable.email
    val phoneResourceId = R.drawable.phone
    val addressResourceId = R.drawable.location
    val placeResourceId = R.drawable.hash
    val streetResourceId = R.drawable.location_state
    val countryResourceId = R.drawable.flag
    val editResourceId = R.drawable.edit
    val dateOfBirthResourceId = R.drawable.calendar
    val postalCodeResourceId = R.drawable.postal_code
    val aadharResourceId = R.drawable.aadhar
    val maleResourceId = R.drawable.male
    val femaleResourceId = R.drawable.female
    val cityResourceId = R.drawable.apartment
    val districtResourceId = R.drawable.radio_button_unchecked
    val stateResourceId = R.drawable.radio_button_checked

    val isEditable by viewModel.isEditable.collectAsState()

    val surname by viewModel.surname.collectAsState()
    val lastname by viewModel.lastname.collectAsState()
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

    val selectedImageUri by viewModel.selectedImageUri.collectAsState()

    val photoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = {
            uri -> viewModel.selectedImageUri.value = uri
        }
    )


    Column(
        modifier = Modifier.padding(top = 5.toResponsiveDp())
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = paddingForBackIcon, end = paddingForBackIcon),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Box(
                modifier = Modifier.width(100.toResponsiveDp())
            ) {
                IconButton(
                    onClick = {
                        navController.popBackStack()
                    }
                ) {
                    Icon(
                        painter = painterResource(leftArrowResourceId),
                        contentDescription = "Back",
                        modifier = Modifier.size(55.toResponsiveDp())
                    )
                }
            }
            NormalText(
                modifier = Modifier.padding(top = 2.toResponsiveDp()),
                value = "Profile",
                fontSize = 20.toResponsiveSp(),
                fontWeight = FontWeight.Bold,
                fontFamily = PoppinsBold,
                color = DarkGray,
                letterSpacing = 0.7.toResponsiveSp()
            )
            Box(
                modifier = Modifier
                    .width(100.toResponsiveDp())
                    .align(Alignment.CenterVertically)
            ) {
                if (isEditable) {
                    Box(
                        modifier = Modifier.align(Alignment.CenterEnd)
                    ) {
                        PrimaryButton(
                            text = "SAVE",
                            fontSize = 15.toResponsiveSp(),
                            width = 68.toResponsiveDp(),
                            height = 30.toResponsiveDp(),
                            contentPadding = PaddingValues(
                                horizontal = 3.toResponsiveDp(),
                                vertical = 3.toResponsiveDp()
                            ),
                            borderShape = RoundedCornerShape(30),
                            onClick = {
                                viewModel.onSaveClick()
                            }
                        )
                    }
                } else {
                    IconButton(
                        modifier = Modifier
                            .background(
                                color = NavyBlue,
                                shape = RoundedCornerShape(50)
                            )
                            .size(38.toResponsiveDp())
                            .align(Alignment.CenterEnd),
                        onClick = { viewModel.updateIsEditable(true) }
                    ) {
                        Icon(
                            painter = painterResource(id = editResourceId),
                            contentDescription = "",
                            tint = White
                        )
                    }
                }
            }
        }
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 30.toResponsiveDp()),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                CircularImageWithAddPhoto(
                    imageResourceUri = selectedImageUri,
                    onClickAddPhoto = {
                        photoPickerLauncher.launch(
                            PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                        )
                    }
                )
            }
            if (isEditable) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 70.toResponsiveDp()),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    OutlinedInputField(
                        modifier = Modifier.width(290.toResponsiveDp()),
                        label = "Surname",
                        value = surname ?: "",
                        onValueChanged = {
                            viewModel.updateSurname(it)
                        }
                    )
                    Spacer(modifier = Modifier.height(30.toResponsiveDp()))
                    OutlinedInputField(
                        modifier = Modifier.width(290.toResponsiveDp()),
                        label = "Lastname",
                        value = lastname ?: "",
                        onValueChanged = {
                            viewModel.updateLastname(it)
                        }
                    )
                    Spacer(modifier = Modifier.height(30.toResponsiveDp()))
                    OutlinedInputField(
                        modifier = Modifier.width(290.toResponsiveDp()),
                        label = "Email",
                        value = email ?: "",
                        onValueChanged = {
                            viewModel.updateEmail(it)
                        }
                    )
                    Spacer(modifier = Modifier.height(30.toResponsiveDp()))
                    OutlinedInputField(
                        modifier = Modifier.width(290.toResponsiveDp()),
                        label = "Phone",
                        value = phone ?: "",
                        onValueChanged = {
                            viewModel.updatePhone(it)
                        }
                    )
                    Spacer(modifier = Modifier.height(30.toResponsiveDp()))
                    OutlinedInputField(
                        modifier = Modifier.width(290.toResponsiveDp()),
                        label = "Date of Birth",
                        value = dateOfBirth ?: "",
                        onValueChanged = {
                            viewModel.updateDateOfBirth(it)
                        }
                    )
                    Spacer(modifier = Modifier.height(30.toResponsiveDp()))
                    DropDown(
                        label = "Gender",
                        options = Data.genderOptions,
                        value = gender ?: "",
                        onItemSelected = {
                            viewModel.updateGender(it)
                        }
                    )
                    Spacer(modifier = Modifier.height(30.toResponsiveDp()))
                    OutlinedInputField(
                        modifier = Modifier.width(290.toResponsiveDp()),
                        label = "Aadhar",
                        value = aadhar ?: "",
                        onValueChanged = {
                            viewModel.updateAadhar(it)
                        }
                    )
                    Spacer(modifier = Modifier.height(30.toResponsiveDp()))
                    OutlinedInputField(
                        modifier = Modifier.width(290.toResponsiveDp()),
                        label = "House Number",
                        value = houseNumber ?: "",
                        onValueChanged = {
                            viewModel.updateHouseNumber(it)
                        }
                    )
                    Spacer(modifier = Modifier.height(30.toResponsiveDp()))
                    OutlinedInputField(
                        modifier = Modifier.width(290.toResponsiveDp()),
                        label = "Street",
                        value = street ?: "",
                        onValueChanged = {
                            viewModel.updateStreet(it)
                        }
                    )
                    Spacer(modifier = Modifier.height(30.toResponsiveDp()))
                    OutlinedInputField(
                        modifier = Modifier.width(290.toResponsiveDp()),
                        label = "Area",
                        value = area ?: "",
                        onValueChanged = {
                            viewModel.updateArea(it)
                        }
                    )
                    Spacer(modifier = Modifier.height(30.toResponsiveDp()))
                    OutlinedInputField(
                        modifier = Modifier.width(290.toResponsiveDp()),
                        label = "District",
                        value = district ?: "",
                        onValueChanged = {
                            viewModel.updateDistrict(it)
                        }
                    )
                    Spacer(modifier = Modifier.height(30.toResponsiveDp()))
                    OutlinedInputField(
                        modifier = Modifier.width(290.toResponsiveDp()),
                        label = "City",
                        value = city ?: "",
                        onValueChanged = {
                            viewModel.updateCity(it)
                        }
                    )
                    Spacer(modifier = Modifier.height(30.toResponsiveDp()))
                    OutlinedInputField(
                        modifier = Modifier.width(290.toResponsiveDp()),
                        label = "State",
                        value = state ?: "",
                        onValueChanged = {
                            viewModel.updateState(it)
                        }
                    )
                    Spacer(modifier = Modifier.height(30.toResponsiveDp()))
                    OutlinedInputField(
                        modifier = Modifier.width(290.toResponsiveDp()),
                        label = "Pincode",
                        value = pincode ?: "",
                        onValueChanged = {
                            viewModel.updatePincode(it)
                        }
                    )
                    Spacer(modifier = Modifier.height(60.toResponsiveDp()))
                }
            } else {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 70.toResponsiveDp()),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    DetailsContainerWithIcon(
                        value = surname ?: "",
                        icon = personResourceId,
                        width = 300.toResponsiveDp(),
                        height = 50.toResponsiveDp()
                    )
                    Spacer(modifier = Modifier.height(30.toResponsiveDp()))
                    DetailsContainerWithIcon(
                        value = lastname ?: "",
                        icon = personResourceId,
                        width = 300.toResponsiveDp(),
                        height = 50.toResponsiveDp()
                    )
                    Spacer(modifier = Modifier.height(30.toResponsiveDp()))
                    DetailsContainerWithIcon(
                        value = dateOfBirth ?: "",
                        icon = dateOfBirthResourceId,
                        width = 300.toResponsiveDp(),
                        height = 50.toResponsiveDp()
                    )
                    Spacer(modifier = Modifier.height(30.toResponsiveDp()))
                    DetailsContainerWithIcon(
                        value = gender ?: "",
                        icon = if (gender == "Male") maleResourceId else femaleResourceId,
                        width = 300.toResponsiveDp(),
                        height = 50.toResponsiveDp()
                    )
                    Spacer(modifier = Modifier.height(30.toResponsiveDp()))
                    DetailsContainerWithIcon(
                        value = phone ?: "",
                        icon = phoneResourceId,
                        width = 300.toResponsiveDp(),
                        height = 50.toResponsiveDp()
                    )
                    Spacer(modifier = Modifier.height(30.toResponsiveDp()))
                    DetailsContainerWithIcon(
                        value = email ?: "",
                        icon = emailResourceId,
                        width = 300.toResponsiveDp(),
                        height = 50.toResponsiveDp()
                    )
                    Spacer(modifier = Modifier.height(30.toResponsiveDp()))
                    DetailsContainerWithIcon(
                        value = aadhar ?: "",
                        icon = aadharResourceId,
                        width = 300.toResponsiveDp(),
                        height = 50.toResponsiveDp()
                    )
                    Spacer(modifier = Modifier.height(30.toResponsiveDp()))
                    DetailsContainerWithIcon(
                        value = houseNumber ?: "",
                        icon = placeResourceId,
                        width = 300.toResponsiveDp(),
                        height = 50.toResponsiveDp()
                    )
                    Spacer(modifier = Modifier.height(30.toResponsiveDp()))
                    DetailsContainerWithIcon(
                        value = street ?: "",
                        icon = streetResourceId,
                        width = 300.toResponsiveDp(),
                        height = 50.toResponsiveDp()
                    )
                    Spacer(modifier = Modifier.height(30.toResponsiveDp()))
                    DetailsContainerWithIcon(
                        value = area ?: "",
                        icon = addressResourceId,
                        width = 300.toResponsiveDp(),
                        height = 50.toResponsiveDp()
                    )
                    Spacer(modifier = Modifier.height(30.toResponsiveDp()))
                    DetailsContainerWithIcon(
                        value = district ?: "",
                        icon = districtResourceId,
                        width = 300.toResponsiveDp(),
                        height = 50.toResponsiveDp()
                    )
                    Spacer(modifier = Modifier.height(30.toResponsiveDp()))
                    DetailsContainerWithIcon(
                        value = city ?: "",
                        icon = cityResourceId,
                        width = 300.toResponsiveDp(),
                        height = 50.toResponsiveDp()
                    )
                    Spacer(modifier = Modifier.height(30.toResponsiveDp()))
                    DetailsContainerWithIcon(
                        value = state ?: "",
                        icon = countryResourceId,
                        width = 300.toResponsiveDp(),
                        height = 50.toResponsiveDp()
                    )
                    Spacer(modifier = Modifier.height(30.toResponsiveDp()))
                    DetailsContainerWithIcon(
                        value = pincode ?: "",
                        icon = postalCodeResourceId,
                        width = 300.toResponsiveDp(),
                        height = 50.toResponsiveDp()
                    )
                    Spacer(modifier = Modifier.height(60.toResponsiveDp()))
                }
            }
        }

        if (popupStatus) {
            Popup(
                title = popupTitle,
                contentOnFirstLine = contentOnFirstLine,
                contentOnSecondLine = contentOnSecondLine,
                dismiss = false,
                onDismissRequest = {
                    viewModel.updatePopupStatus(false)
                },
                onConfirmRequest = {
                    viewModel.updatePopupStatus(false)
                }
            )
        }
    }
}

//@Preview(showBackground = true, heightDp = 700)
//@Composable
//fun ProfileScreenPreview () {
//    ProfileScreen(navController = rememberNavController(), currentUserId = currentUserId)
//}
