package br.com.jupiter.android.nav

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.jupiter.Objects.Mock
import br.com.jupiter.android.components.CardCourse
import br.com.jupiter.android.content.ContentScreen
import br.com.jupiter.android.courses.CourseScreen
import br.com.jupiter.android.courses.CourseScreen2
import br.com.jupiter.android.courses.CourseViewModel
import br.com.jupiter.android.login.LoginScreen
import br.com.jupiter.android.orders.OrderScreen
import br.com.jupiter.android.registerPayment.RegisterPaymentScreen
import br.com.jupiter.android.registerUser1.RegisterUserScreen


enum class Route {
    CONTENT, LOGIN, COURSES, CREATE, PAYMENT, ORDER, COURSES_DETAIL, CARD, CARD_GROUP
}

@Composable
fun Navigator(
    modifier: Modifier = Modifier,
    navHostController: NavHostController = rememberNavController(),
    initial: Route = Route.COURSES
) {

    val viewModel = viewModel<CourseViewModel>()
    val cursos by viewModel.cursos.collectAsState()


    NavHost(
        navController = navHostController,
        startDestination = initial.name
    ) {

        composable(Route.LOGIN.name) {
            LoginScreen(
                onHomeNavigate = { navHostController.navigate(Route.COURSES.name) },
                onCreateNavigate = { navHostController.navigate(Route.CREATE.name) }
            )

        }

        composable(Route.COURSES.name) {
            CourseScreen(
                onCategoryDetail = { navHostController.navigate("${Route.COURSES_DETAIL}/$it") },
                navHostController = navHostController,
                cursos = cursos
            )
        }

        composable("${Route.COURSES_DETAIL}/{categoria}") {
            val categoria = it.arguments?.getString("categoria")
            CourseScreen2(
                categoria = categoria ?: "",
                navHostController = navHostController,
                cursos = cursos
            )
        }


        composable(Route.CARD.name) {
            CardCourse(
                curso = Mock.curso1,
                navHostController = navHostController,
                onCardNavigation = { id ->
                    println("Entrei com id: ${id}")
                    navHostController.navigate("${Route.CONTENT}/$id")
                })
        }


        composable("${Route.CONTENT}/{conteudo}") {
            val conteudo = it.arguments?.getString("conteudo")
            println(conteudo)
            ContentScreen(id = 1, onBack = { })
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



