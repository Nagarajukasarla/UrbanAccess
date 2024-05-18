package com.example.buspassapplication.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.buspassapplication.R
import com.example.buspassapplication.ui.theme.DarkGray
import com.example.buspassapplication.ui.theme.PoppinsBold

@Composable
fun BackNavigationBar (
    text: String = "",
    @DrawableRes trailingIcon: Int = 0,
    navController: NavHostController
) {

    val leftArrowResourceId = R.drawable.arrow_left

    Row (
        modifier = Modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier.weight(1f)
        ) {
            IconButton(
                onClick = {
                    navController.popBackStack()
                }
            ) {
                Icon(
                    painter = painterResource(leftArrowResourceId),
                    contentDescription = "Back",
                    modifier = Modifier.size(55.dp)
                )
            }
        }
        Row(
            modifier = Modifier.weight(3f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            if (text.isNotEmpty()) {
                NormalText(
                    modifier = Modifier,
                    value = "Profile",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = PoppinsBold,
                    color = DarkGray,
                    letterSpacing = 0.7.sp
                )
            }
        }
        Box(modifier = Modifier.weight(1f)) {
            if (trailingIcon != 0) {
                IconButton(
                    onClick = {
                        //
                    }
                ) {
                    Icon(
                        painter = painterResource(trailingIcon),
                        contentDescription = "Back",
                        modifier = Modifier.size(55.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BackNavigationBarPreview() {
    BackNavigationBar(navController = rememberNavController())
}
