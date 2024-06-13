package com.example.buspassapplication.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.buspassapplication.R
import com.example.buspassapplication.components.BackNavigationBar

@Composable
fun ComingSoonScreen(
    navController: NavHostController,
    currentUserId: String?
) {
    BackNavigationBar(navController = navController)
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.coming_soon_image),
            contentDescription = "Coming Soon image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
    }
}

@Composable
@Preview
fun ComingSoonScreenPreview() {
    ComingSoonScreen(navController = rememberNavController(), currentUserId = null)
}
