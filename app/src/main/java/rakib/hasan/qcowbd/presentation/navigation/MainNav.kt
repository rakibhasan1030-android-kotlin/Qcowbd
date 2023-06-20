package rakib.hasan.qcowbd.presentation.navigation

import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import rakib.hasan.qcowbd.presentation.Screen
import rakib.hasan.qcowbd.presentation.home.HomeScreen
import rakib.hasan.qcowbd.presentation.login.LoginScreen
import rakib.hasan.qcowbd.presentation.registration.RegistrationScreen
import rakib.hasan.qcowbd.presentation.service.ServiceScreen
import rakib.hasan.qcowbd.presentation.shop.ShopScreen

@OptIn(ExperimentalMaterial3Api::class)
fun NavGraphBuilder.mainGraph(drawerState: DrawerState) {
    navigation(startDestination = Screen.HomeScreen.route, route = Screen.HomeScreen.route) {
        /*composable(route = Screen.HomeScreen.route){
            HomeScreen(drawerState)
        }
        composable(route = Screen.ShopScreen.route){
            ShopScreen(drawerState)
        }
        composable(route = Screen.ServiceScreen.route){
            ServiceScreen(drawerState)
        }
        composable(route = Screen.LoginScreen.route){
            LoginScreen(drawerState)
        }
        composable(route = Screen.RegistrationScreen.route){
            RegistrationScreen(drawerState)
        }*/
    }
}