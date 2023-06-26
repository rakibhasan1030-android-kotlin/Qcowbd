package rakib.hasan.qcowbd.presentation.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import rakib.hasan.qcowbd.app.ui.theme.QcowbdTheme
import kotlin.random.Random


@Composable
fun Boxes(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit,
) {
    Layout(
        modifier = modifier,
        content = content,
    ) { measurables, constraints ->
        val largeBox = measurables[0]
        val smallBox = measurables[1]
        val looseConstraints = constraints.copy(
            minWidth = 0,
            minHeight = 0,
        )
        val largePlaceable = largeBox.measure(looseConstraints)
        val smallPlaceable = smallBox.measure(looseConstraints)
        layout(
            width = constraints.maxWidth,
            height = largePlaceable.height + smallPlaceable.height / 2,
        ) {
            largePlaceable.placeRelative(
                x = 0,
                y = 0,
            )
            smallPlaceable.placeRelative(
                x = (constraints.maxWidth - smallPlaceable.width) / 2,
                y = largePlaceable.height - smallPlaceable.height / 2
            )
        }
    }
}

@Preview()
@Composable
fun BoxesPreview() {
    QcowbdTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column {
                Text(
                    text = "Before",
                    modifier = Modifier.padding(all = 16.dp)
                )
                Boxes(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Blue)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(128.dp)
                            .background(Color.Black)
                    )
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 24.dp)
                            .fillMaxWidth()
                            .height(64.dp)
                            .background(Color.Transparent)
                    ) {
                        Card(
                            modifier = Modifier,

                            ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                            ) {
                                for (i in 1..3) {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(100.dp)
                                            .weight(1f)
                                            .background(Color(Random.nextInt()))
                                    )
                                    if (i != 3) Divider(
                                        modifier = Modifier
                                            .padding(vertical = 8.dp, horizontal = 8.dp)
                                            .background(Color(0xFFd1d3e0))
                                            .width(1.dp)
                                            .fillMaxHeight()
                                    )
                                }
                            }
                        }
                    }
                }
                Text(
                    text = "After",
                    modifier = Modifier.padding(all = 16.dp)
                )
            }
        }
    }
}