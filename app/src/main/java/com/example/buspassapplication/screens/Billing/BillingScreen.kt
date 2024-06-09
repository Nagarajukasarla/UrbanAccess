package com.example.buspassapplication.screens.Billing

import android.app.Activity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.buspassapplication.components.BackNavigationBar
import com.example.buspassapplication.components.NormalText
import com.example.buspassapplication.components.PrimaryButton
import com.example.buspassapplication.ui.theme.Black
import com.example.buspassapplication.ui.theme.PoppinsMedium

@ExperimentalMaterial3Api
@Composable
fun BillingScreen(
    navController: NavHostController,
    currentUserId: String?,
    viewModel: BillingViewModel = hiltViewModel()
){
    val context = LocalContext.current as Activity

    Column(
        modifier = Modifier.padding(bottom = 30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        BackNavigationBar(navController = navController)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 28.dp, top = 20.dp, end = 30.dp)
        ) {
            Column {
                NormalText(
                    modifier = Modifier.padding(top = 20.dp, bottom = 0.dp, start = 10.dp),
                    value = "Bill Summary",
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = PoppinsMedium,
                    color = Black
                )
                Spacer(modifier = Modifier.height(20.dp))
                Column {
                   TODO("Add list of bills")
                }
                PrimaryButton(
                    text = "Submit",
                    width = 280.dp,
                    height = 45.dp,
                    borderShape = RoundedCornerShape(50),
                    onClick = {

                        viewModel.onSubmitClick(context)
                    }
                )
            }
        }
    }
}

@ExperimentalMaterial3Api
@Preview(showBackground = true)
@Composable
fun BillingScreenPreview(){
    BillingScreen(navController = rememberNavController(), currentUserId = "Bhuvan")
}
