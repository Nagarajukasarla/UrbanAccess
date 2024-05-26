package com.example.buspassapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.buspassapplication.graphs.RootNavigationGraph
import com.example.buspassapplication.ui.theme.BusPassApplicationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {

    lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //configureFirebaseServices()
        setContent {
            BusPassApplicationTheme {
                navController = rememberNavController()
                RootNavigationGraph(navController)
            }
        }
    }

//    private fun configureFirebaseServices() {
//        if (BuildConfig.DEBUG) {
//            Firebase.auth.useEmulator("127.0.0.1", 9099)
//            Firebase.firestore.useEmulator("127.0.0.1", 8080)
//        }
//    }
}