package rakib.hasan.qcowbd.presentation.home

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import rakib.hasan.qcowbd.R
import rakib.hasan.qcowbd.app.components.appbar.AppBar
import rakib.hasan.qcowbd.presentation.home.components.Boxes
import rakib.hasan.qcowbd.presentation.home.components.HomeProductItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    drawerState: DrawerState,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    Scaffold(
        topBar = { AppBar(drawerState = drawerState) }
    ) {
        val scrollState = rememberScrollState()

        val context = LocalContext.current
        val state = viewModel.state.value
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                .scrollable(state = scrollState, orientation = Orientation.Vertical)
        ) {
            Column(
                modifier = Modifier
            ) {
                Boxes(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(250.dp)
                            .background(Color.Black)
                    )
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 24.dp)
                            .fillMaxWidth()
                            .height(100.dp)
                            .background(Color.Transparent)
                    ) {
                        HeaderCard()
                    }
                }
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(state.products) { product ->
                        HomeProductItem(product = product, onItemClick = {
                            Toast.makeText(context, product.title, Toast.LENGTH_SHORT).show()
                        })
                    }
                }
            }
            if (state.error.isNotBlank()) {
                Text(
                    text = state.error,
                    color = MaterialTheme.colorScheme.error,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .align(Alignment.Center)
                )
            }
            if (state.isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .align(
                            Alignment.Center
                        )
                )
            }
        }
    }
}

@Composable
fun HeaderCard() {
    Card(
        modifier = Modifier
            .wrapContentHeight(Alignment.CenterVertically),
        elevation =CardDefaults.cardElevation(
            0.5.dp
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            for (i in 0..2) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(100.dp)
                        .weight(1f)
                        .background(Color.White),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painterResource(id = R.drawable.trolly),
                            contentDescription = "Trolly",
                            modifier = Modifier
                                .height(40.dp)
                                .width(40.dp),
                        )
                        Text(
                            modifier = Modifier
                                .padding(start = 8.dp, top = 4.dp, bottom = 0.dp, end = 8.dp),
                            text = "অনলাইন পেমেন্ট",
                            style = MaterialTheme.typography.titleSmall.copy(
                                lineHeight = 14.sp,  // Here line height
                            ),
                            textAlign = TextAlign.Center,
                            textDecoration = TextDecoration.None,
                            fontSize = 12.sp
                        )
                    }

                }
                if (i != 2) Divider(
                    modifier = Modifier
                        .width(1.dp)
                        .fillMaxHeight()
                )
            }
        }
    }
}
