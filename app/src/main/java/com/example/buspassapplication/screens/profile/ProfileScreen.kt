package com.example.buspassapplication.screens.profile

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen (
    navController: NavHostController,
    currentUserId: String?
) {

//    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
//    val screenWidthInPixels = with (LocalDensity.current) { screenWidth.toPx() }
//    val paddingForBackIcon = (screenWidthInPixels * 0.01).dp
//    val paddingForProfileText = (screenWidthInPixels * 0.11).dp
//
//    Log.d("ProfileScreen", "screenWidth: $screenWidth")
//    Log.d("ProfileScreen", "screenWidthInPixels: $screenWidthInPixels")
//    Log.d("ProfileScreen", "paddingForBackIcon: $paddingForBackIcon")
//    Log.d("ProfileScreen", "paddingForProfileText: $paddingForProfileText")
//
//    val leftArrowResourceId = R.drawable.arrow_left
//    val profileResourceId = R.drawable.krishna
//    val personResourceId = R.drawable.account
//    val emailResourceId = R.drawable.email
//    val phoneResourceId = R.drawable.phone
//    val addressResourceId = R.drawable.location
//    val placeResourceId = R.drawable.hash
//    val stateResourceId = R.drawable.location_state
//    val countryResourceId = R.drawable.flag
//    val editResourceId = R.drawable.edit
//
//    val user = User()
//
////    var name by rememberSaveable { mutableStateOf(user.name) }
//    var email by rememberSaveable { mutableStateOf(user.email) }
//    var phone by rememberSaveable { mutableStateOf(user.phone) }
////    var place by rememberSaveable { mutableStateOf(user.place) }
//    var city by rememberSaveable { mutableStateOf(user.city) }
//    var state by rememberSaveable { mutableStateOf(user.state) }
//    var country by rememberSaveable { mutableStateOf(user.country) }
//
//    var isEditable by rememberSaveable { mutableStateOf(false) }
//
//    Column(
//        modifier = Modifier.padding(top = 5.dp)
//    ) {
//        Row (
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(start = paddingForBackIcon, end = paddingForBackIcon),
//            verticalAlignment = Alignment.CenterVertically,
//            horizontalArrangement = Arrangement.SpaceBetween
//        ) {
//            Box(
//                modifier = Modifier.width(100.dp)
//            ) {
//                IconButton(
//                    onClick = {
//                        navController.popBackStack()
//                    }
//                ) {
//                    Icon(
//                        painter = painterResource(leftArrowResourceId),
//                        contentDescription = "Back",
//                        modifier = Modifier.size(55.dp)
//                    )
//                }
//            }
//            NormalText(
//                modifier = Modifier.padding(top = 2.dp),
//                value = "Profile",
//                fontSize = 20.sp,
//                fontWeight = FontWeight.Bold,
//                fontFamily = PoppinsBold,
//                color = DarkGray,
//                letterSpacing = 0.7.sp
//            )
//            Box(modifier = Modifier
//                .width(100.dp)
//                .align(Alignment.CenterVertically)) {
//                if (isEditable) {
//                    Box(
//                        modifier = Modifier.align(Alignment.CenterEnd)
//                    ) {
//                        PrimaryButton(
//                            text = "SAVE",
//                            fontSize = 15.sp,
//                            width = 68.dp,
//                            height = 30.dp,
//                            contentPadding = PaddingValues(
//                                horizontal = 3.dp,
//                                vertical = 3.dp
//                            ),
//                            borderShape = RoundedCornerShape(30),
//                            onClick = {
//                                isEditable = false
//                            }
//                        )
//                    }
//                }
//                else {
//                    IconButton(
//                        modifier = Modifier
//                            .background(
//                                color = NavyBlue,
//                                shape = RoundedCornerShape(50)
//                            )
//                            .size(38.dp)
//                            .align(Alignment.CenterEnd),
//                        onClick = { isEditable = true }
//                    ) {
//                        Icon(
//                            painter = painterResource(id = editResourceId),
//                            contentDescription = "",
//                            tint = White
//                        )
//                    }
//                }
//            }
//        }
//        Column(
//            modifier = Modifier
//                .verticalScroll(rememberScrollState())
//        ) {
//            Row(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(top = 30.dp),
//                verticalAlignment = Alignment.CenterVertically,
//                horizontalArrangement = Arrangement.Center
//            ) {
//                CircularImageWithAddPhoto(
//                    imageResourceId = profileResourceId
//                )
//            }
//            if (isEditable) {
//                Column(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(top = 70.dp),
//                    verticalArrangement = Arrangement.Center,
//                    horizontalAlignment = Alignment.CenterHorizontally
//                ) {
////                    OutlinedInputField(
////                        modifier = Modifier.width(290.dp),
////                        label = "Name",
////                        value = user.name,
////                        onValueChanged = { name = it }
////                    )
//                    Spacer(modifier = Modifier.height(30.dp))
//                    OutlinedInputField(
//                        modifier = Modifier.width(290.dp),
//                        label = "Email",
//                        value = email,
//                        onValueChanged =  { email = it }
//                    )
//                    Spacer(modifier = Modifier.height(30.dp))
//                    OutlinedInputField(
//                        modifier = Modifier.width(290.dp),
//                        label = "Phone",
//                        value = phone.,
//                        onValueChanged = { phone = it }
//                    )
//                    Spacer(modifier = Modifier.height(30.dp))
//                    OutlinedInputField(
//                        modifier = Modifier.width(290.dp),
//                        label = "Place",
//                        value = place,
//                        onValueChanged = { place = it }
//                    )
//                    Spacer(modifier = Modifier.height(30.dp))
//                    OutlinedInputField(
//                        modifier = Modifier.width(290.dp),
//                        label = "City",
//                        value = city,
//                        onValueChanged = { city = it }
//                    )
//                    Spacer(modifier = Modifier.height(30.dp))
//                    OutlinedInputField(
//                        modifier = Modifier.width(290.dp),
//                        label = "State",
//                        value = state,
//                        onValueChanged = { state = it }
//                    )
//                    Spacer(modifier = Modifier.height(30.dp))
//                    OutlinedInputField(
//                        modifier = Modifier.width(290.dp),
//                        label = "Country",
//                        value = country,
//                        onValueChanged = { country = it }
//                    )
//                    Spacer(modifier = Modifier.height(60.dp))
//                }
//            }
//            else {
//                Column(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .padding(top = 70.dp),
//                    verticalArrangement = Arrangement.Center,
//                    horizontalAlignment = Alignment.CenterHorizontally
//                ) {
//                    DetailsContainerWithIcon(
//                        value = name,
//                        icon = personResourceId,
//                        width = 300.dp,
//                        height = 50.dp
//                    )
//                    Spacer(modifier = Modifier.height(30.dp))
//                    DetailsContainerWithIcon(
//                        value = email,
//                        icon = emailResourceId,
//                        width = 300.dp,
//                        height = 50.dp
//                    )
//                    Spacer(modifier = Modifier.height(30.dp))
//                    DetailsContainerWithIcon(
//                        value = phone,
//                        icon = phoneResourceId,
//                        width = 300.dp,
//                        height = 50.dp
//                    )
//                    Spacer(modifier = Modifier.height(30.dp))
//                    DetailsContainerWithIcon(
//                        value = place,
//                        icon = addressResourceId,
//                        width = 300.dp,
//                        height = 50.dp
//                    )
//                    Spacer(modifier = Modifier.height(30.dp))
//                    // Place
//                    DetailsContainerWithIcon(
//                        value = city,
//                        icon = placeResourceId,
//                        width = 300.dp,
//                        height = 50.dp
//                    )
//                    Spacer(modifier = Modifier.height(30.dp))
//                    // State
//                    DetailsContainerWithIcon(
//                        value = state,
//                        icon = stateResourceId,
//                        width = 300.dp,
//                        height = 50.dp
//                    )
//                    Spacer(modifier = Modifier.height(30.dp))
//                    DetailsContainerWithIcon(
//                        value = country,
//                        icon = countryResourceId,
//                        width = 300.dp,
//                        height = 50.dp
//                    )
//                    Spacer(modifier = Modifier.height(60.dp))
//                }
//            }
//        }
//    }
}

//@Preview(showBackground = true, heightDp = 700)
//@Composable
//fun ProfileScreenPreview () {
//    ProfileScreen(navController = rememberNavController(), currentUserId = currentUserId)
//}