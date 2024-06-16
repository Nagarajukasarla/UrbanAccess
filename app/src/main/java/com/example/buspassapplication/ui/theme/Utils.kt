package com.example.buspassapplication.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit

@Composable
fun Dp.scale():Dp{
    val denssity = LocalConfiguration.current.densityDpi/160f
    return this*denssity
}

@Composable
fun Float.scale():Float{
    val density = LocalConfiguration.current.densityDpi/160f
    return this*density
}

@Composable
fun Int.scaleText():Int{
   val density = LocalConfiguration.current.densityDpi/160f
    return this * density.toInt()
}

@Composable
fun TextUnit.scaleText(): TextUnit {
    val density = LocalConfiguration.current.densityDpi / 160f
    return this * density
}
