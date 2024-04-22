package com.example.buspassapplication.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.buspassapplication.R
import com.example.buspassapplication.ui.theme.DimGray
import androidx.compose.ui.Modifier
@Composable
fun NavigationBar() {

    val passIcon = R.drawable.pass
    val mapIcon = R.drawable.map
    val notificationIcon = R.drawable.notifications
    val walletIcon = R.drawable.wallet
    val feedbackIcon = R.drawable.feedback

    Box(
        modifier = Modifier
            .height(100.dp)
            .width(326.dp)
            .background(DimGray)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.Top
        ) {
            NavigationBarItem(
                iconResourceId = passIcon,
                isSelected = false
            )
            NavigationBarItem(
                iconResourceId = mapIcon,
                isSelected = false
            )
            NavigationBarItem(
                iconResourceId = notificationIcon,
                isSelected = true
            )
            NavigationBarItem(
                iconResourceId =walletIcon,
                isSelected = false
            )
            NavigationBarItem(
                iconResourceId = feedbackIcon,
                isSelected = false
            )
        }
    }
}

@Composable
fun NavigationBarItem(
    @DrawableRes iconResourceId : Int,
    isSelected: Boolean,

) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(horizontal = 8.dp)
    ) {
            Spacer(modifier = Modifier.width(8.dp))
        IconButton(
            onClick = { /*TODO*/ }
        ) {

            Icon(
                painter = painterResource(id = iconResourceId),
                contentDescription = "Visibility",
            )
        }
    }
}

@Preview
@Composable
fun Dummy(){
    NavigationBar()
}