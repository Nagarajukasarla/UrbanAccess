package com.example.buspassapplication.components


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.buspassapplication.R
import com.example.buspassapplication.ui.theme.NavyBlue

@Composable
fun Header() {

    val profileResourceId = R.drawable.account_circle
    val settingsResourceId = R.drawable.settings

    Column(

    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .height(50.dp)
                .fillMaxWidth()
        ){
            IconButton(
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    painter = painterResource(id = profileResourceId),
                    contentDescription = "Profile",
                    modifier = Modifier.size(60.dp),
                    tint = NavyBlue
                )
            }
            IconButton(
                onClick = { /*TODO*/ }
            ) {
                Icon(
                    painter = painterResource(id = settingsResourceId),
                    contentDescription = "Settings",
                    modifier = Modifier.size(60.dp),
                    tint = NavyBlue
                )
            }
        }
        Divider (
            modifier = Modifier
                .fillMaxWidth()
                .height(2.dp),
            color = Color.LightGray
        )
    }
    
}

@Preview
@Composable
fun HeaderPreview() {
    Header()
}