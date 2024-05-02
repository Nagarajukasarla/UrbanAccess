package com.example.buspassapplication.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.buspassapplication.R
import com.example.buspassapplication.components.NormalText
import com.example.buspassapplication.components.SearchScreen
import com.example.buspassapplication.ui.theme.Black
import com.example.buspassapplication.ui.theme.PoppinsMedium
import androidx.compose.foundation.Image
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@ExperimentalMaterial3Api
@Composable
fun MapScreen(
    navController: NavHostController
) {
Box(modifier=Modifier.fillMaxSize()) {
    Image(
        modifier=Modifier
            .matchParentSize(),
        contentScale= ContentScale.FillBounds,
        painter = painterResource(id = R.drawable.map_image),
        contentDescription = "Photo"
    )

        Column {
            NormalText(
                modifier = Modifier.padding(top = 40.dp, bottom = 20.dp, start = 20.dp),
                value = "Route Map",
                fontSize = 42.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = PoppinsMedium,
                color = Black
            )
            SearchScreen()
    }
}
}

@ExperimentalMaterial3Api
@Preview
@Composable
fun RoutePreview(){
    MapScreen(navController = rememberNavController())
}