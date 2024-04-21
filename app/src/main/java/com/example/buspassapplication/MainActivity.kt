package com.example.buspassapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.buspassapplication.samples.PasswordField
import com.example.buspassapplication.samples.StaggeredDotLoader
import com.example.buspassapplication.screens.LoginScreen
import com.example.buspassapplication.screens.SignUpScreen
import com.example.buspassapplication.ui.theme.BusPassApplicationTheme

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusPassApplicationTheme {
                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    LoginScreen()
//                }

                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
//                    GoogleSignupButton(drawableId = R.drawable.ic_google_logo)
//                    CoilImage()
//                    PasswordField(
//                        visibilityOffResourceId = R.drawable.visibility_off,
//                        visibilityPainterResourceId = R.drawable.visibilty
//                    )
                    //StaggeredDotLoader()
//                    LoadingAnimation()
//                    Home1()
//                    SignUpScreen()
                    LoginScreen()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
        color = MaterialTheme.colorScheme.primary
    )
}

@ExperimentalMaterial3Api
@Composable
fun GreetingPreview() {
    BusPassApplicationTheme {
       // GoogleSignupButton(drawableId = R.drawable.ic_google_logo)
        val visibilityOffResourceId = R.drawable.visibility_off
        val visibilityResourceId = R.drawable.visibilty
        PasswordField(
            visibilityOffResourceId = visibilityOffResourceId,
            visibilityPainterResourceId = visibilityResourceId
        )
    }
}

@Preview
@Composable
fun Home1() {
    Surface {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            // Header
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(width = 1.dp, Color.Black),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Box(
                    modifier = Modifier
                        .width(50.dp)
                        .height(50.dp)
                        .background(MaterialTheme.colorScheme.primary)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.account_circle),
                        contentDescription = "Profile",
                        tint = Color.White,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Box(
                    modifier = Modifier
                        .width(50.dp)
                        .height(50.dp)
                        .background(Color.DarkGray)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.settings),
                        contentDescription = "Settings",
                        tint = Color.White,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }

            // Middle content (Scrollable)

            LazyColumn {
                items(25) {
                    Box(
                        modifier = Modifier
                            .height(50.dp)
                            .fillMaxWidth()
                            .background(Color.LightGray)
                            .padding(8.dp)
                    ) {

                    }
                }
            }

            // Spacer to push footer to the bottom
            Spacer(modifier = Modifier.weight(1f))

            // Footer
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .border(width = 1.dp, Color.Black),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Box(
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .width(70.dp)
                        .height(60.dp)
                ) {}
                Box(
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .width(70.dp)
                        .height(60.dp)
                ) {}
                Box(
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .width(70.dp)
                        .height(60.dp)
                ) {}
                Box(
                    modifier = Modifier
                        .background(Color.DarkGray)
                        .width(70.dp)
                        .height(60.dp)
                ) {}
            }
        }
    }
}