package rakib.hasan.qcowbd.presentation.navigation

import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import rakib.hasan.qcowbd.presentation.main.NavRoutes
import rakib.hasan.qcowbd.presentation.custom_order.CustomOrderScreen
import rakib.hasan.qcowbd.presentation.home.HomeScreen
import rakib.hasan.qcowbd.presentation.login.LoginScreen
import rakib.hasan.qcowbd.presentation.registration.RegistrationScreen
import rakib.hasan.qcowbd.presentation.service.ServiceScreen
import rakib.hasan.qcowbd.presentation.shop.ShopScreen

@OptIn(ExperimentalMaterial3Api::class)
fun NavGraphBuilder.mainGraph(drawerState: DrawerState) {
    navigation(startDestination = MainNavOption.HomeScreen.name, route = NavRoutes.MainRoute.name) {
        composable(route = MainNavOption.HomeScreen.name){
            HomeScreen(drawerState)
        }
        composable(route = MainNavOption.ShopScreen.name){
            ShopScreen(drawerState)
        }
        composable(route = MainNavOption.ServiceScreen.name){
            ServiceScreen(drawerState)
        }
        composable(route = MainNavOption.CustomOrderScreen.name){
            CustomOrderScreen(drawerState)
        }
        composable(route = MainNavOption.LoginScreen.name){
            LoginScreen(drawerState)
        }
        composable(route = MainNavOption.RegistrationScreen.name){
            RegistrationScreen(drawerState)
        }
    }
}

enum class MainNavOption {
    HomeScreen,
    ShopScreen,
    ServiceScreen,
    CustomOrderScreen,
    LoginScreen,
    RegistrationScreen,
}
