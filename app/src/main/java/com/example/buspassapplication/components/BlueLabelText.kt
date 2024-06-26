package com.example.buspassapplication.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.example.buspassapplication.ui.theme.BabyBlue
import com.example.buspassapplication.ui.theme.NavyBlue
import com.example.buspassapplication.ui.theme.PoppinsMedium
import toResponsiveDp
import toResponsiveSp

@Composable
@ExperimentalMaterial3Api
fun BlueLabelledText(
    text:String
){
    Column(
        modifier = Modifier
            .padding(16.toResponsiveDp())
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Divider(
            color = BabyBlue,
            thickness = 3.toResponsiveDp(),
            modifier = Modifier.padding(vertical = 5.toResponsiveDp())
        )

        NormalText(
            value = text,
            fontSize = 20.toResponsiveSp(),
            fontWeight = FontWeight.Normal,
            fontFamily = PoppinsMedium,
            color = NavyBlue,
            modifier = Modifier
        )

        Divider(
            color = BabyBlue,
            thickness = 3.toResponsiveDp(),
            modifier = Modifier.padding(vertical = 5.toResponsiveDp())
        )
    }

}
