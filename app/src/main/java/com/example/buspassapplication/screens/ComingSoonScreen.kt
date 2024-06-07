package com.example.buspassapplication.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import com.example.buspassapplication.R
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.layout.ContentScale
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
@Composable
fun ComingSoonScreen (navController: NavController){
    Box(modifier= Modifier.fillMaxSize()){
        Image(painter = painterResource(id=R.drawable.coming_soon_image),
            contentDescription = "Coming Soon image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize())
    }
}

@Composable
@Preview
fun ComingSoonScreenPreview(){
    ComingSoonScreen(navController = rememberNavController())
}