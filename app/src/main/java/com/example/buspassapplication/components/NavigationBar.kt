package com.example.buspassapplication.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.buspassapplication.R
import com.example.buspassapplication.ui.theme.DimGray
import androidx.compose.ui.Modifier
import com.example.buspassapplication.ui.theme.LightGray

@Composable
fun NavigationBar() {

    val homeResourceId = R.drawable.home
    val passResourceId = R.drawable.pass
    val mapResourceId = R.drawable.map
    val walletResourceId = R.drawable.wallet
    val profileResourceId = R.drawable.account_circle

    Column {
        Divider(
            modifier = Modifier.fillMaxWidth()
                .height(2.dp),
            color = DimGray
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(65.dp)
                .background(color = LightGray)
                .padding(start = 5.dp, end = 5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            NavigationBarItem(
                iconResourceId = homeResourceId,
            )
            NavigationBarItem(
                iconResourceId = walletResourceId,
            )
            NavigationBarItem(
                iconResourceId = passResourceId,
            )
            NavigationBarItem(
                iconResourceId = mapResourceId
            )
            NavigationBarItem(
                iconResourceId = profileResourceId,
            )
        }
    }
}

@Preview
@Composable
fun Dummy(){
    NavigationBar()
}