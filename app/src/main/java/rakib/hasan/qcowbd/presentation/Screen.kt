package rakib.hasan.qcowbd.presentation

sealed class Screen(val route: String){
    object HomeScreen: Screen("home_screen")
    object ShopScreen: Screen("shop_screen")
    object ServiceScreen: Screen("service_screen")
    object CustomOrderScreen: Screen("custom_order_screen")
    object LoginScreen: Screen("login_screen")
    object RegistrationScreen: Screen("registration_screen")
}