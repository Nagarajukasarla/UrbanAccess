package com.example.buspassapplication.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImagePainter.State.Empty.painter
import com.example.buspassapplication.R
import com.example.buspassapplication.Screen
import com.example.buspassapplication.components.HeadingText
import com.example.buspassapplication.components.NormalText
import com.example.buspassapplication.components.OutlinedInputField
import com.example.buspassapplication.components.PasswordField
import com.example.buspassapplication.components.PrimaryButton
import com.example.buspassapplication.components.SearchScreen
import com.example.buspassapplication.ui.theme.Black
import com.example.buspassapplication.ui.theme.DarkGray
import com.example.buspassapplication.ui.theme.NavyBlue
import com.example.buspassapplication.ui.theme.PoppinsMedium
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource

@ExperimentalMaterial3Api
@Composable
fun RouteScreen(){
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

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun RoutePreview(){
    RouteScreen()
}