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
import com.example.buspassapplication.ui.theme.BabyBlue
import com.example.buspassapplication.ui.theme.PoppinsMedium
import com.example.buspassapplication.ui.theme.White
import toResponsiveDp
import toResponsiveSp


@ExperimentalMaterial3Api
@Composable
fun BlueBoxButton(
    text: String,
    fontSize: TextUnit = 17.toResponsiveSp(),
    width: Dp,
    height: Dp,
    contentPadding: PaddingValues = PaddingValues(5.toResponsiveDp()),
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
            letterSpacing = 0.5.toResponsiveSp(),
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
        width = 112.toResponsiveDp(),
        height = 36.toResponsiveDp(),
        borderShape = RoundedCornerShape(5)
    )
}
