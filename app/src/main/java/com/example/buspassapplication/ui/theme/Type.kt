package com.example.buspassapplication.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.buspassapplication.R

val OpenSans = FontFamily(
    Font(resId = R.font.open_sans_medium),
    Font(resId = R.font.open_sans_regular)
)

val Roboto = FontFamily(
    Font(resId = R.font.roboto_regular),
    Font(resId = R.font.roboto_bold)
)

val PoppinsMedium = FontFamily(
    Font(resId = R.font.poppins_medium),
)

val PoppinsLight = FontFamily(
    Font(resId = R.font.poppins_light)
)

val PoppinsBold = FontFamily(
    Font(resId = R.font.poppins_bold)
)


// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    titleSmall = TextStyle(
        fontFamily = PoppinsLight,
        fontSize = 20.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.4.sp
    ),
    titleLarge = TextStyle(
        fontFamily = PoppinsMedium,
        fontWeight = FontWeight.Medium,
        fontSize = 22.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.4.sp
    ),
    labelSmall = TextStyle(
        fontFamily = PoppinsMedium,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        lineHeight = 18.sp,
        letterSpacing = 0.2.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)