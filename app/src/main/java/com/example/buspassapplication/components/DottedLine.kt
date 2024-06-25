import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.example.buspassapplication.ui.theme.IceBlue

@Composable
fun CenteredDotWithVerticalLine(
    dotRadius: Dp = 16.toResponsiveDp(),
    lineColor: Color = IceBlue,
    lineWidth: Dp = 6.toResponsiveDp(),
    lineLength: Dp = 140.toResponsiveDp(),
    lineVisible: Boolean = true
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Canvas(modifier = Modifier.size(dotRadius * 2)) {
            drawCircle(
                color = lineColor,
                radius = dotRadius.toPx()
            )
        }
        if (lineVisible) {
            Spacer(
                modifier = Modifier
                    .width(lineWidth)
                    .height(lineLength)
                    .background(lineColor)
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewCenteredDotWithVerticalLine() {
    MaterialTheme {
        CenteredDotWithVerticalLine()
    }
}
