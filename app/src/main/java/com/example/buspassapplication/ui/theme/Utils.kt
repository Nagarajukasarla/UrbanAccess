import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Int.toResponsiveDp(): Dp {
    val screenWidthDp = LocalConfiguration.current.screenWidthDp
    return (this * (screenWidthDp / 411f)).dp
}
@Composable
fun Double.toResponsiveDp(): Dp {
    val screenWidthDp = LocalConfiguration.current.screenWidthDp
    return (this * (screenWidthDp / 411f)).dp
}

@Composable
fun Int.toResponsiveSp(): TextUnit {
    val screenWidthDp = LocalConfiguration.current.screenWidthDp
    return (this * (screenWidthDp / 411f)).sp
}

@Composable
fun Double.toResponsiveSp(): TextUnit {
    val screenWidthDp = LocalConfiguration.current.screenWidthDp
    return (this * (screenWidthDp / 411f)).sp
}