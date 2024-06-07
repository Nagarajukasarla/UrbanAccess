package com.example.buspassapplication.samples

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.ContentAlpha
import androidx.wear.compose.material.Icon
import com.example.buspassapplication.ui.theme.DimGray
import com.example.buspassapplication.ui.theme.Shapes

@ExperimentalMaterial3Api
@Composable
fun ExpandableCard () {
    var expandedState by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(
        targetValue = if (expandedState) 180f else 0f, label = ""
    )

    Card (
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 500,
                    easing = LinearOutSlowInEasing
                )
            ),
        shape = Shapes.small,
        onClick = {
            expandedState = !expandedState
        }

    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
                .border(width = 2.dp, DimGray)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = AnnotatedString("Hello"),
                    fontSize = MaterialTheme.typography.titleMedium.fontSize,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(6f)
                )
                IconButton(
                    modifier = Modifier
                        .alpha(ContentAlpha.medium)
                        .weight(1f)
                        .rotate(rotationState),
                    onClick = {
                        expandedState = !expandedState
                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Drop-Down-Arrow",
                        tint = DimGray
                    )
                }
            }
            if (expandedState) {
                Text(
                    text = AnnotatedString("I'm Nagaraju Kasarla, a tech enthusiast with a " +
                            "flair for blending creativity with cutting-edge technology. " +
                            "I'm passionate about developing dynamic applications " +
                            "that push boundaries. Whether it's crafting sleek user " +
                            "interfaces with ReactJS, architecting robust backends" +
                            " with Springboot, I'm always eager to explore new " +
                            "horizons in the world of databases and development."
                    ),
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    maxLines = 6,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}


@ExperimentalMaterial3Api
@Preview
@Composable
fun ExpandableCardPreview () {
    ExpandableCard()
}
