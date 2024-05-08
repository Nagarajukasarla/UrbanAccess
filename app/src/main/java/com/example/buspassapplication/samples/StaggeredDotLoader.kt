package com.example.buspassapplication.samples


import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.buspassapplication.ui.theme.NavyBlue
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.tooling.preview.Preview
import com.example.buspassapplication.ui.theme.Shapes
import kotlinx.coroutines.delay

@Preview
@Composable
fun StaggeredDotLoader(
) {

    val circles = listOf(
        remember { Animatable(initialValue = 0.0f) },
        remember { Animatable(initialValue = 0.0f) },
        remember { Animatable(initialValue = 0.0f) },
    )

    val radius = 15.0f
    val circlesValue = circles.map { it.value }
    val horizontalStartingPoint = 93.0f


    circles.forEachIndexed { index, animatable ->
        LaunchedEffect(key1 = animatable) {
            delay(index * 100L)
            animatable.animateTo(
                targetValue = 1f,
                animationSpec = infiniteRepeatable(
                    animation = keyframes {
                        durationMillis = 1400
                        0.0f at 0 using LinearOutSlowInEasing
                        1.0f at 350 using LinearOutSlowInEasing
                        0.0f at 700 using LinearOutSlowInEasing
                        0.0f at 1400 using LinearOutSlowInEasing
                    },
                    repeatMode = RepeatMode.Restart
                )
            )
        }
    }


        Canvas(
            modifier = Modifier
                .size(100.dp)
                .border(width = 1.dp, color = NavyBlue, shape = Shapes.medium)
        ) {
            val color = NavyBlue
            circlesValue.forEachIndexed{ index, value ->
                val center = Offset(horizontalStartingPoint + (index * 47), size.height / 2)
                drawCircle(
                    color = color,
                    center = center,
                    radius = value * radius
                )
            }
        }

//    Canvas(
//        modifier = Modifier
//            .size(100.dp)
//            .border(width = 1.dp, color = NavyBlue, shape = Shapes.medium)) {
//        val color = NavyBlue
//
//
//        drawCircle(
//            color = color,
//            center = Offset(horizontalStartingPoint, size.height / 2),
//            radius = maxRadius
//        )
//        drawCircle(
//            color = color,
//            center = Offset(horizontalStartingPoint + (47), size.height /2),
//            radius = maxRadius
//        )
//        drawCircle(
//            color = color,
//            center = Offset(horizontalStartingPoint + (47 * 2), size.height / 2),
//            radius = maxRadius
//        )
//    }
//    Canvas(modifier = Modifier.size(100.dp)) {
//        val radius = size.minDimension / 2
//        val center = Offset(size.width / 2, size.height / 2)
//        val color = Color.Red
//
//        drawCircle(
//            color = color,
//            radius = radius * animatedProgress.value,
//            center = center
//        )
//    }
}


//@Composable
//fun Ttemp() {
//    Surface {
//        Row(
//            horizontalArrangement = Arrangement.Center,
//            verticalAlignment = Alignment.CenterVertically,
//            modifier = Modifier.background(Color.Transparent)
//        ) {
//            AnimatedCircle(delay = 0f, holdDuration = 2f)
//            Spacer(modifier = Modifier.width(8.dp))
//            AnimatedCircle(delay = 1f)
//            Spacer(modifier = Modifier.width(8.dp))
//            AnimatedCircle(delay = 2f, holdDuration = 2f)
//        }
//    }
//}