package com.example.buspassapplication.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.buspassapplication.R
import com.example.buspassapplication.ui.theme.NavyBlue
import com.example.buspassapplication.ui.theme.White
import toResponsiveDp
import toResponsiveSp

@Composable
fun CircularIconButton(
    iconSize: Dp = 17.toResponsiveDp(),
    width: Dp,
    height: Dp,
    contentPadding: PaddingValues = PaddingValues(5.toResponsiveDp()),
    borderShape: RoundedCornerShape = RoundedCornerShape(100.toResponsiveDp()),
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .width(width)
            .height(height),
        shape = borderShape,
        contentPadding = contentPadding,
        colors = ButtonDefaults.buttonColors(
            contentColor = White,
            containerColor = NavyBlue
        )
    ){
        Icon(
            painter = painterResource(id = R.drawable.search),
            contentDescription = null,
            tint = White,
            modifier = Modifier.size(iconSize)
        )
    }
}
