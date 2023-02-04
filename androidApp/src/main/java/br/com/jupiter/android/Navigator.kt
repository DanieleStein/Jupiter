package br.com.jupiter.android

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.jupiter.android.content.ContentScreen
import br.com.jupiter.android.courses.CourseScreen
import br.com.jupiter.android.login.LoginScreen
import br.com.jupiter.android.orders.OrderScreen
import br.com.jupiter.android.registerPayment.RegisterPaymentScreen
import br.com.jupiter.android.registerUser1.RegisterUserScreen
import br.com.jupiter.model.Usuario


enum class Route {
    CONTENT, LOGIN, COURSES, CREATE, PAYMENT, ORDER
}

@Composable
fun Navigator(
    modifier: Modifier = Modifier,
    navHostController: NavHostController = rememberNavController(),
    initial: Route = Route.LOGIN
) {

    lateinit var usuario: Usuario


    NavHost(
        navController = navHostController,
        startDestination = initial.name
    ) {
        composable(Route.CONTENT.name) {
            ContentScreen() {}
        }

        composable(Route.LOGIN.name) {
            LoginScreen(
                onHomeNavigate = {navHostController.navigate(Route.COURSES.name)},
                onCreateNavigate = {navHostController.navigate(Route.CREATE.name)}
            )

        }

        composable(Route.COURSES.name) {
            CourseScreen()

            //navHostController.navigate(Route.CONTENT.name)
        }

        composable(Route.CREATE.name) {
            RegisterUserScreen(
                onNextButtonClicked = {
                    navHostController.navigate(Route.PAYMENT.name)
                }
            )
        }

        composable(Route.PAYMENT.name) {
            RegisterPaymentScreen(
                onNextButtonClicked = {
                    navHostController.navigate(Route.ORDER.name)
                }
            )
        }

        composable(Route.ORDER.name) {
            OrderScreen(
                onNextButtonClicked = {
                    navHostController.navigate(Route.COURSES.name)
                }
            )
        }
    }


}