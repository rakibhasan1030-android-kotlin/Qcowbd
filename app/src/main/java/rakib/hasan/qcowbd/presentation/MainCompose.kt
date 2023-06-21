package rakib.hasan.qcowbd.presentation

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import rakib.hasan.qcowbd.R
import rakib.hasan.qcowbd.app.components.appdrawer.AppDrawerContent
import rakib.hasan.qcowbd.app.components.appdrawer.AppDrawerItemInfo
import rakib.hasan.qcowbd.presentation.navigation.MainNavOption
import rakib.hasan.qcowbd.presentation.navigation.mainGraph
import rakib.hasan.qcowbd.app.ui.theme.QcowbdTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainCompose(
    navController: NavHostController = rememberNavController(),
    drawerState: DrawerState = rememberDrawerState(initialValue = DrawerValue.Closed),
) {
    QcowbdTheme {
        Surface {
            ModalNavigationDrawer(drawerState = drawerState, drawerContent = {
                AppDrawerContent(
                    drawerState = drawerState,
                    menuItems = DrawerParams.drawerButtons,
                    defaultPick = MainNavOption.HomeScreen
                ) { onUserPickedOption ->
                    when (onUserPickedOption) {
                        MainNavOption.HomeScreen -> {
                            navController.navigate(onUserPickedOption.name) {
                                popUpTo(NavRoutes.MainRoute.name)
                            }
                        }

                        MainNavOption.ShopScreen -> {
                            navController.navigate(onUserPickedOption.name) {
                                popUpTo(NavRoutes.MainRoute.name)
                            }
                        }

                        MainNavOption.ServiceScreen -> {
                            navController.navigate(onUserPickedOption.name) {
                                popUpTo(NavRoutes.MainRoute.name)
                            }
                        }

                        MainNavOption.CustomOrderScreen -> {
                            navController.navigate(onUserPickedOption.name) {
                                popUpTo(NavRoutes.MainRoute.name)
                            }
                        }

                        MainNavOption.LoginScreen -> {
                            navController.navigate(onUserPickedOption.name) {
                                popUpTo(NavRoutes.MainRoute.name)
                            }
                        }

                        MainNavOption.RegistrationScreen -> {
                            navController.navigate(onUserPickedOption.name) {
                                popUpTo(NavRoutes.MainRoute.name)
                            }
                        }

                    }
                }
            }) {
                NavHost(
                    navController, startDestination = NavRoutes.MainRoute.name
                ) {
                    mainGraph(drawerState)
                }
            }
        }
    }
}

enum class NavRoutes {
    MainRoute,
}

object DrawerParams {
    val drawerButtons = listOf(
        AppDrawerItemInfo(
            MainNavOption.HomeScreen,
            R.string.home,
            R.drawable.ic_home,
            R.string.drawer_home_description
        ), AppDrawerItemInfo(
            MainNavOption.ShopScreen,
            R.string.shop,
            R.drawable.ic_shopping,
            R.string.drawer_shop_description
        ), AppDrawerItemInfo(
            MainNavOption.ServiceScreen,
            R.string.service,
            R.drawable.ic_service,
            R.string.drawer_service_description
        ), AppDrawerItemInfo(
            MainNavOption.CustomOrderScreen,
            R.string.custom_order,
            R.drawable.ic_service,
            R.string.drawer_custom_order_description
        ), AppDrawerItemInfo(
            MainNavOption.LoginScreen,
            R.string.login,
            R.drawable.ic_service,
            R.string.drawer_login_description
        ), AppDrawerItemInfo(
            MainNavOption.RegistrationScreen,
            R.string.registration,
            R.drawable.ic_service,
            R.string.drawer_registration_description
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun MainActivityPreview() {
    MainCompose()
}