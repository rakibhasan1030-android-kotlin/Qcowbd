package rakib.hasan.qcowbd.presentation.home

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import rakib.hasan.qcowbd.app.components.appbar.AppBar
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
        val context = LocalContext.current
        val state = viewModel.state.value
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(it)) {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.products) { product ->
                    HomeProductItem(product = product, onItemClick = {
                        Toast.makeText(context, product.title, Toast.LENGTH_SHORT).show()
                    })
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
