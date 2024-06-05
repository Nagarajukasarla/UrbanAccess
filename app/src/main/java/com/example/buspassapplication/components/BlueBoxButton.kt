package com.example.buspassapplication.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.buspassapplication.ui.theme.BabyBlue
import com.example.buspassapplication.ui.theme.NavyBlue
import com.example.buspassapplication.ui.theme.PoppinsMedium
import com.example.buspassapplication.ui.theme.White


@ExperimentalMaterial3Api
@Composable
fun BlueBoxButton(
    text: String,
    fontSize: TextUnit = 17.sp,
    width: Dp,
    height: Dp,
    contentPadding: PaddingValues = PaddingValues(5.dp),
    borderShape: RoundedCornerShape = RoundedCornerShape(5),
    onClick: () -> Unit = {}
) {

    Button(
        onClick = onClick,
        modifier = Modifier
            .width(width)
            .height(height),
        shape = borderShape,
        contentPadding = contentPadding,
        colors = ButtonDefaults.buttonColors(
            contentColor = White,
            containerColor = BabyBlue
        )
    ) {
        NormalText(
            value = text,
            fontSize = fontSize,
            fontWeight = FontWeight(18),
            fontFamily = PoppinsMedium,
            color = White,
            letterSpacing = 0.5.sp,
            modifier = Modifier
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun PreviewBlueBoxButton() {
    BlueBoxButton(
        text = "Top up",
        width = 112.dp,
        height = 36.dp,
        borderShape = RoundedCornerShape(5)
    )
}