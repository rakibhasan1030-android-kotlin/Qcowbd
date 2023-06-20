package rakib.hasan.qcowbd.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.NavigationDrawerItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import rakib.hasan.qcowbd.R
import rakib.hasan.qcowbd.presentation.home.HomeScreen
import rakib.hasan.qcowbd.presentation.home.components.AppBar
import rakib.hasan.qcowbd.presentation.home.components.DrawerItem
import rakib.hasan.qcowbd.presentation.login.LoginScreen
import rakib.hasan.qcowbd.presentation.navigation.mainGraph
import rakib.hasan.qcowbd.presentation.registration.RegistrationScreen
import rakib.hasan.qcowbd.presentation.service.ServiceScreen
import rakib.hasan.qcowbd.presentation.shop.ShopScreen
import rakib.hasan.qcowbd.ui.theme.QcowbdTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QcowbdTheme {
                val drawerState = rememberDrawerState(DrawerValue.Closed)
                val scope = rememberCoroutineScope()
                val drawerItems = getDrawerItems()
                val selectedItem = remember { mutableStateOf(drawerItems[0]) }
                ModalNavigationDrawer(
                    drawerState = drawerState,
                    drawerContent = {
                        ModalDrawerSheet {
                            Spacer(Modifier.height(12.dp))
                            drawerItems.forEach { item ->
                                NavigationDrawerItem(
                                    icon = { Icon(item.icon, contentDescription = null) },
                                    label = { Text(item.title) },
                                    selected = item == selectedItem.value,
                                    onClick = {
                                        scope.launch { drawerState.close() }
                                        selectedItem.value = item
                                    },
                                    modifier = Modifier
                                        .requiredWidth(250.dp)
                                        .background(
                                            Color(Color.Transparent.value),
                                            RoundedCornerShape(topEnd = 16.dp, bottomEnd = 16.dp)
                                        )
                                        .padding(NavigationDrawerItemDefaults.ItemPadding),
                                )
                            }
                        }
                    },
                    content = {
                        Scaffold(
                            topBar = {
                                AppBar {
                                    scope.launch {
                                        if (drawerState.isClosed) drawerState.open()
                                        else drawerState.close()
                                    }
                                }
                            },
                        ) { paddingValues ->
                            Column(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(paddingValues),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                val navController = rememberNavController()
                                NavHost(
                                    navController = navController,
                                    startDestination = Screen.HomeScreen.route
                                ){
                                    mainGraph(drawerState)
                                    /*composable(route = Screen.HomeScreen.route){
                                        HomeScreen(navController)
                                    }
                                    composable(route = Screen.ShopScreen.route){
                                        ShopScreen(navController)
                                    }
                                    composable(route = Screen.ServiceScreen.route){
                                        ServiceScreen(navController)
                                    }
                                    composable(route = Screen.LoginScreen.route){
                                        LoginScreen(navController)
                                    }
                                    composable(route = Screen.RegistrationScreen.route){
                                        RegistrationScreen(navController)
                                    }*/
                                }
                            }
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun getDrawerItems() = listOf (
    DrawerItem(
        "home",
        stringResource(R.string.home),
        "Home",
        ImageVector.vectorResource(id = R.drawable.ic_home)
    ),
    DrawerItem(
        "about",
        stringResource(R.string.shop),
        "About",
        ImageVector.vectorResource(id = R.drawable.ic_shopping)
    ),
    DrawerItem(
        "service",
        stringResource(R.string.service),
        "About",
        ImageVector.vectorResource(id = R.drawable.ic_service)
    ),
    DrawerItem(
        "custom order",
        stringResource(R.string.custom_order),
        "About",
        ImageVector.vectorResource(id = R.drawable.ic_service)
    ),
    DrawerItem(
        "login",
        stringResource(R.string.login),
        "About",
        ImageVector.vectorResource(id = R.drawable.ic_service)
    ),
    DrawerItem(
        "registration",
        stringResource(R.string.registration),
        "About",
        ImageVector.vectorResource(id = R.drawable.ic_service)
    ),
)
