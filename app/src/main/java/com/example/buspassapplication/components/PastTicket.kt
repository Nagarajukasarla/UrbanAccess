package com.example.buspassapplication.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material.ContentAlpha
import androidx.wear.compose.material.Icon
import com.example.buspassapplication.R
import com.example.buspassapplication.ui.theme.Black
import com.example.buspassapplication.ui.theme.CloudGray
import com.example.buspassapplication.ui.theme.DarkGray
import com.example.buspassapplication.ui.theme.DimGray
import com.example.buspassapplication.ui.theme.PoppinsMedium
import com.example.buspassapplication.ui.theme.Shapes

@ExperimentalMaterial3Api
@Composable
fun PastTicket(
    width: Dp = 330.dp,
    height: Dp = 60.dp,
    title: String,
    titleSize: TextUnit = 25.sp,
    titlesColumnWidth: Dp = 170.dp,
    leadingIconSize: Dp = 21.dp,
    isBordered: Boolean = true,
    underLine: Boolean = false,

) {
    val forwardArrowResourceId = R.drawable.arrow_forward
    var expandedState by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(
        targetValue = if (expandedState) 90f else 270f, label = ""
    )

    val boxModifier = Modifier
        .height(height)
        .width(width)
        .let { if (isBordered) it.border(2.dp, DimGray, RoundedCornerShape(5.dp)) else it }
        .clickable { expandedState = !expandedState }

    Column(
        modifier = Modifier
            .clickable { expandedState = !expandedState }
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            )
            .padding(5.dp)
            .width(width)
    ) {
        Row(
            modifier = boxModifier,
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier.width(titlesColumnWidth)
            ) {
                NormalText(
                    modifier = Modifier.padding(start=10.dp),
                    value = title,
                    fontSize = titleSize,
                    fontWeight = FontWeight.Normal,
                    fontFamily = PoppinsMedium,
                    color = DarkGray,
                    letterSpacing = 0.5.sp
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            androidx.compose.material3.Icon(
                painter = painterResource(id = forwardArrowResourceId),
                contentDescription = "Forward arrow",
                tint = DarkGray,
                modifier = Modifier
                    .size(leadingIconSize)
                    .padding(end = 10.dp)
                    .rotate(rotationState),
            )
        }
        if (expandedState) {
            NormalText(
                modifier = Modifier.align(Alignment.Start),
                value = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Integer pretium est nulla, eu finibus orci fringilla non. Phasellus nec porta nisi. Fusce sollicitudin lacus nec laoreet ultricies. Morbi bibendum orci sit amet ultrices congue. Aenean mollis tortor ante, at consequat sapien tempus et. Morbi ornare commodo dictum. Praesent quis facilisis dui, quis ullamcorper metus. Ut felis nisl, pharetra et faucibus et, condimentum non arcu. Curabitur mi neque, ultrices et elementum eu, hendrerit non nunc.\n" +
                        "\n" +
                        "In volutpat erat eget lectus egestas, vitae rhoncus orci sodales. Fusce tempor iaculis tempus. Sed sed luctus tellus. Aenean ut lacinia dolor. Ut elementum dapibus ante, ut hendrerit ex sollicitudin in. Etiam ut ante non arcu bibendum maximus. Vestibulum dapibus ultricies felis sed faucibus. Cras ut gravida lorem. Praesent ut iaculis diam. Duis faucibus sed ante ac lobortis. Etiam tincidunt scelerisque sapien, a dapibus urna ullamcorper ut. Pellentesque erat justo, tincidunt eu elit non, tincidunt pharetra tortor. Morbi eget fermentum tellus. Fusce facilisis quam ac varius semper. Nam id nisi ut sapien bibendum sollicitudin vel vitae mi.\n" +
                        "\n" +
                        "Donec id suscipit sapien. Vestibulum fermentum eleifend fringilla. Suspendisse a ornare nulla. Vestibulum sit amet scelerisque ipsum. Donec sit amet pretium nulla. Suspendisse dapibus mi dui, a venenatis diam ultricies id. Sed nibh nulla, commodo et arcu a, vehicula dictum erat. Fusce aliquet elit sit amet orci tempor porta.\n" +
                        "\n" +
                        "Mauris vitae faucibus lacus. Ut dictum molestie eros, eget posuere lectus. Aliquam quis nisi hendrerit, rutrum odio quis, bibendum ligula. Mauris accumsan lobortis malesuada. Proin ex sem, luctus id porta a, fringilla sit amet neque. Integer a magna non orci ultrices porta eu eget risus. Aenean eu convallis lorem.\n" +
                        "\n" +
                        "Sed viverra id diam at pulvinar. Vestibulum vel ultricies ipsum. Maecenas accumsan feugiat velit sed sodales. Donec consectetur a leo at accumsan. Sed sagittis fringilla enim, sit amet ornare tortor consequat id. Nullam vitae risus ut tellus consectetur sagittis ac ut nisi. Proin justo tortor, maximus eget dictum at, viverra at velit. Proin quis enim mattis, varius felis vitae, tristique nunc. Cras feugiat mattis ligula sed sollicitudin. Pellentesque vitae urna erat. Sed aliquet, ligula quis euismod rhoncus, metus lacus congue ex, sed commodo eros dui quis risus.",
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = PoppinsMedium,
                color = Black
            )
        }
    }
    if (underLine) {
        HorizontalDivider(
            modifier = Modifier
                .height(1.dp)
                .width(width),
            color = CloudGray
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun PreviewPastTicket() {
    PastTicket(
        title = "Title"
    )
}
